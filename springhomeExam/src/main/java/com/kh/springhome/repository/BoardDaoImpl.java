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
import com.kh.springhome.entity.BoardListSearchVO;
import com.kh.springhome.entity.CurrentBoardNoVO;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 1. 추상 메소드 오버라이딩 - 게시글 작성 (다음 시퀀스 번호를 뽑아서 게시글 작성)
	@Override
	public int write(BoardDto boardDto) {
		String sql = "select board_seq.nextval from dual";
		int boardNo = jdbcTemplate.queryForObject(sql, int.class);			
		sql = "insert into board(board_no, board_title, board_content, board_writer, board_head) values(?, ?, ?, ?, ?)";
		Object[] param = {boardNo, boardDto.getBoardTitle(), boardDto.getBoardContent(), boardDto.getBoardWriter(), boardDto.getBoardHead()};
		jdbcTemplate.update(sql, param);
		return boardNo;
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
	
	// BoardDto에 대한 RowMapper
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
			return boardDto;
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
	*/
	@Override
	public List<BoardDto> selectList(BoardListSearchVO vo) {
		String sql = "select * from board where instr(#1, ?) > 0 order by board_writetime desc";
		sql = sql.replace("#1", vo.getType());
		Object[] param = new Object[] {vo.getKeyword()};
		return jdbcTemplate.query(sql, mapper, param);
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
	public void readCount(int boardNo) {
		String sql = "update board set board_read = board_read + 1 where board_no = ?";
		Object[] param = new Object[] {boardNo};
		jdbcTemplate.update(sql, param);
	}
	
	@Override
	public BoardDto read(int boardNo) {
		this.readCount(boardNo);
		return this.selectOne(boardNo);
	}

	// #. 추상 메소드 오버라이딩 - DB 전부 삭제 (TEST용)
	@Override
	public void clear() {
		String sql = "delete board";
		jdbcTemplate.update(sql);
	}
}