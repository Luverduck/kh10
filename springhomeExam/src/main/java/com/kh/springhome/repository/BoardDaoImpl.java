package com.kh.springhome.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.springhome.entity.BoardDto;
import com.kh.springhome.vo.BoardLatestListVO;
import com.kh.springhome.vo.BoardListSearchVO;
import com.kh.springhome.vo.BoardListVO;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 1-1. 추상 메소드 - 시퀀스 번호 반환 메소드
	@Override
	public int sequence() {
		String sql = "select board_seq.nextval from dual";
		int boardNo = jdbcTemplate.queryForObject(sql, int.class);
		return boardNo;
	}

	// 1. 추상 메소드 오버라이딩 - 게시글 작성 (다음 시퀀스 번호를 뽑아서 게시글 작성)
	@Override
	public void write(BoardDto boardDto) {		
		String sql = "insert into board(board_no, board_title, board_content, board_writer, board_head, board_group, board_parent, board_depth) values(?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] param = {boardDto.getBoardNo(), boardDto.getBoardTitle(), boardDto.getBoardContent(), boardDto.getBoardWriter(), boardDto.getBoardHead(), boardDto.getBoardGroup(), boardDto.getBoardParentInteger(), boardDto.getBoardDepth()};
		jdbcTemplate.update(sql, param);
	}
	
	// #. 추상 메소드 - 게시글 작성 테스트용
	@Override
	public void writeTest(BoardDto boardDto) {		
		String sql = "select board_seq.nextval from dual";
		int boardNo = jdbcTemplate.queryForObject(sql, int.class);
		sql = "insert into board(board_no, board_title, board_content, board_writer, board_head, board_group, board_parent, board_depth) values(?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] param = {boardNo, boardDto.getBoardTitle(), boardDto.getBoardContent(), boardDto.getBoardWriter(), boardDto.getBoardHead(), boardDto.getBoardGroup(), boardDto.getBoardParentInteger(), boardDto.getBoardDepth()};
		jdbcTemplate.update(sql, param);
	}
	
	// 2. 추상 메소드 오버라이딩 - 게시글 수정
	@Override
	public boolean update(BoardDto boardDto) {
		String sql = "update board set board_title = ?, board_content = ?, board_head = ?, board_updatetime = sysdate where board_no = ?";
		Object[] param = new Object[] {boardDto.getBoardTitle(), boardDto.getBoardContent(), boardDto.getBoardHead(), boardDto.getBoardNo()};
		return jdbcTemplate.update(sql, param) > 0;
	}
		
	// 3. 추상 메소드 오버라이딩 - 게시글 삭제
	@Override
	public boolean delete(int boardNo) {
		String sql = "delete board where board_no = ?";
		Object[] param = new Object[] {boardNo};
		return jdbcTemplate.update(sql, param) > 0;
	}
	
	// BoardDto에 대한 RowMapper (계층형 게시판 항목을 위해 수정)
	private RowMapper<BoardDto> mapper = new RowMapper<>() {
		@Override
		public BoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardDto boardDto = new BoardDto();
			boardDto.setBoardNo(rs.getInt("board_no"));
			boardDto.setBoardWriter(rs.getString("board_writer"));
			boardDto.setBoardTitle(rs.getString("board_title"));
			boardDto.setBoardContent(rs.getString("board_content"));
			boardDto.setBoardWritetime(rs.getDate("board_writetime"));
			boardDto.setBoardUpdatetime(rs.getDate("board_updatetime"));
			boardDto.setBoardRead(rs.getInt("board_read"));
			boardDto.setBoardLike(rs.getInt("board_like"));
			boardDto.setBoardHead(rs.getString("board_head"));
			boardDto.setBoardGroup(rs.getInt("board_group"));
			boardDto.setBoardParent(rs.getInt("board_parent"));
			boardDto.setBoardDepth(rs.getInt("board_depth"));
			return boardDto;
		}
	};
	
	// BoardDto에 대한 RowMapper (계층형 게시판 항목을 위해 수정)
	private RowMapper<BoardListVO> listMapper = new RowMapper<BoardListVO>() {
		@Override
		public BoardListVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			return BoardListVO.builder()
						.boardNo(rs.getInt("board_no"))
						.boardWriter(rs.getString("board_writer"))
						.boardTitle(rs.getString("board_title"))
						.boardContent(rs.getString("board_content"))
						.boardWritetime(rs.getDate("board_writetime"))
						.boardUpdatetime(rs.getDate("board_updatetime"))
						.boardRead(rs.getInt("board_read"))
						.boardLike(rs.getInt("board_like"))
						.boardHead(rs.getString("board_head"))
						.boardGroup(rs.getInt("board_group"))
						.boardParent(rs.getInt("board_parent"))
						.boardDepth(rs.getInt("board_depth"))
						.replyCount(rs.getInt("reply_count"))
					.build();
		}
	};
	
	// 4. 추상 메소드 오버라이딩 - 게시글 목록	
	// - 전체 목록
	@Override
	public List<BoardDto> selectList() {
		String sql = "select * from board order by board_writetime desc";
		return jdbcTemplate.query(sql, mapper);
	}
	
	// - 검색 목록
	/*
	@Override
	public List<BoardDto> selectList(String type, String keyword) {
		String sql = "select * from board where instr(#1, ?) > 0 order by board_writetime desc";
		sql = sql.replace("#1", type);
		Object[] param = new Object[] {keyword};
		return jdbcTemplate.query(sql, mapper, param);
	}
	/*
	@Override
	public List<BoardDto> selectList(BoardListSearchVO vo) {
		String sql = "select * from board where instr(#1, ?) > 0 order by board_writetime desc";
		sql = sql.replace("#1", vo.getType());
		Object[] param = new Object[] {vo.getKeyword()};
		return jdbcTemplate.query(sql, mapper, param);
	}
	*/
	
	// - 통합 검색
	@Override
	public List<BoardListVO> selectList(BoardListSearchVO vo) {
		if(vo.isSearch()) {	// 검색 조회이라면
			return search(vo);
		}
		else {	// 전체 조회라면
			return list(vo);
		}
	}
	
	// - 통합 검색 1) 전체 조회
	@Override
	public List<BoardListVO> list(BoardListSearchVO vo) {
		String sql = "select * from ("
									+ "select rownum rn, TMP.* from ("
											+ "select * from ("
												+ "select distinct B.*, "
													+ "count(R.reply_no) over(partition by B.board_no) reply_count "
												+ "from board B left outer join reply R on B.board_no = R.reply_origin "
											+ ")"
											+ "connect by prior board_no=board_parent "
											+ "start with board_parent is null "
											+ "order siblings by board_group desc, board_no asc "
										+ ")TMP"
									+ ") where rn between ? and ?";
		Object[] param = new Object[] {vo.startRow(), vo.endRow()};
		return jdbcTemplate.query(sql, listMapper, param);
	}

	// - 통합 검색 2) 검색 조회
	@Override
	public List<BoardListVO> search(BoardListSearchVO vo) {
		String sql =   "select * from ("
									+ "select rownum rn, TMP.* from ("
										+ "select * from ("
												+ "select distinct B.*, "
													+ "count(R.reply_no) over(partition by B.board_no) reply_count "
												+ "from board B left outer join reply R on B.board_no = R.reply_origin "
											+ ")"
											+ "where instr(#1, ?) > 0 "
											+ "connect by prior board_no=board_parent "
											+ "start with board_parent is null "
											+ "order siblings by board_group desc, board_no asc "
										+ ")TMP"
									+ ") where rn between ? and ?";
		sql = sql.replace("#1", vo.getType());
		Object[] param = new Object[] {vo.getKeyword(), vo.startRow(), vo.endRow()};
		return jdbcTemplate.query(sql, listMapper, param);
	}
	
	@Override
	public int count(BoardListSearchVO vo) {
		if(vo.isSearch()) {
			return searchCount(vo);
		}
		else {
			return listCount(vo);
		}
	}

	@Override
	public int searchCount(BoardListSearchVO vo) {
		String sql = "select count(*) from board where instr(#1, ?) > 0";
		sql = sql.replace("#1", vo.getType());
		Object[] param = new Object[] {vo.getKeyword()};
		return jdbcTemplate.queryForObject(sql, int.class, param);
	}

	@Override
	public int listCount(BoardListSearchVO vo) {
		String sql = "select count(*) from board";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	// ResultSetExtractor
	ResultSetExtractor<BoardDto> extractor = new ResultSetExtractor<>() {
		@Override
		public BoardDto extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()) {
				/*
				BoardDto boardDto = new BoardDto();
	            boardDto.setBoardNo(rs.getInt("board_no"));
	            boardDto.setBoardWriter(rs.getString("board_writer"));
	            boardDto.setBoardTitle(rs.getString("board_title"));
	            boardDto.setBoardContent(rs.getString("board_content"));
	            boardDto.setBoardWritetime(rs.getDate("board_writetime"));
	            boardDto.setBoardUpdatetime(rs.getDate("board_updatetime"));
	            boardDto.setBoardRead(rs.getInt("board_read"));
	            boardDto.setBoardLike(rs.getInt("board_like"));
	            boardDto.setBoardHead(rs.getString("board_head"));
	            return boardDto;  
	            */
				return BoardDto.builder()
										.boardNo(rs.getInt("board_no"))
										.boardWriter(rs.getString("board_writer"))
										.boardTitle(rs.getString("board_title"))
										.boardContent(rs.getString("board_content"))
										.boardWritetime(rs.getDate("board_writetime"))
										.boardUpdatetime(rs.getDate("board_updatetime"))
										.boardRead(rs.getInt("board_read"))
										.boardLike(rs.getInt("board_like"))
										.boardHead(rs.getString("board_head"))
										.build();
			}
			else {
				return null;
			}
		}
	};

	// 5. 추상 메소드 오버라이딩 -  조회수 증가 + 게시글 상세
	@Override
	public BoardDto selectOne(int boardNo) {
		String sql = "select * from board where board_no = ?";
		Object[] param = new Object[] {boardNo};
		return jdbcTemplate.query(sql, extractor, param);
	}

	// 5-1. 추상 메소드 오버라이딩 - 조회수 증가
	@Override
	public boolean updateReadcount(int boardNo) {
		String sql = "update board set board_read = board_read + 1 where board_no = ?";
		Object[] param = {boardNo};
		return jdbcTemplate.update(sql, param) > 0;
	}
	
	@Override
	public BoardDto read(int boardNo) {
		this.updateReadcount(boardNo);
		return this.selectOne(boardNo);
	}

	// #. 추상 메소드 오버라이딩 - DB 전부 삭제 (TEST용)
	@Override
	public void clear() {
		String sql = "delete board";
		jdbcTemplate.update(sql);
	}

	// BoardDto에 대한 RowMapper (계층형 게시판 항목을 위해 수정)
	private RowMapper<BoardLatestListVO> latestListMapper = new RowMapper<BoardLatestListVO>() {
		@Override
		public BoardLatestListVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			return BoardLatestListVO.builder()
						.boardNo(rs.getInt("board_no"))
						.boardWriter(rs.getString("board_writer"))
						.boardTitle(rs.getString("board_title"))
						.boardWritetime(rs.getDate("board_writetime"))
						.boardRead(rs.getInt("board_read"))
					.build();
		}
	};
	
	// 추상 메소드 오버라이딩 - 최근에 작성된 게시글
	@Override
	public List<BoardLatestListVO> boardLatest() {
		String sql = "select * from (select TMP.*, rownum rn from (select * from board order by board_writetime desc)TMP) where rn between 1 and 5";
		return jdbcTemplate.query(sql, latestListMapper);
	}
	
	// 추상 메소드 오버라이딩 - 최근에 작성된 게시글
	@Override
	public List<BoardLatestListVO> boardLatest(Integer boardEnd) {
		String sql = "select * from (select TMP.*, rownum rn from (select * from board order by board_writetime desc)TMP) where rn between 1 and ?";
		Object[] param = new Object[] {boardEnd};
		return jdbcTemplate.query(sql, latestListMapper, param);
	}

	// 첨부파일 관련 기능
	// 추상 메소드 오버라이딩 - board_attachment 테이블에 등록하기 위한 메소드
	@Override
	public void connectAttachment(int boardNo, int attachmentNo) {
		String sql = "insert into board_attachment(board_no, attachment_no) values(?, ?)";
		Object[] param = new Object[] {boardNo, attachmentNo};
		jdbcTemplate.update(sql, param);
	}
}