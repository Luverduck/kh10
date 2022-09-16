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

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 1. 추상 메소드 오버라이딩 - 게시글 작성
	@Override
	public void write(String boardWriter, String boardTitle, String boardContent, String boardHead) {
		String sql = "insert into board(board_no, board_writer, board_title, board_content, board_head) values(board_seq.nextval, ?, ?, ?, ?)";
		Object[] param = new Object[] {boardWriter, boardTitle, boardContent, boardHead};
		jdbcTemplate.update(sql, param);
	}

	// 2. 추상 메소드 오버라이딩 - 게시글 수정
	@Override
	public boolean update(BoardDto boardDto) {
		String sql = "update board set board_title = ?, board_content = ?, board_head = ? where board_no = ?";
		Object[] param = new Object[] {boardDto.getBoardTitle(), boardDto.getBoardContent(), boardDto.getBoardHead(), boardDto.getBoardNo()};
		return jdbcTemplate.update(sql, param) > 0;
	}
		
	// 3. 추상 메소드 오버라이딩 - 게시글 삭제
		
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
	@Override
	public List<BoardDto> selectList(String type, String keyword) {
		String sql = "select * from board where instr(#1, ?) > 0 order by board_writetime desc";
		sql = sql.replace("#1", type);
		Object[] param = new Object[] {keyword};
		return jdbcTemplate.query(sql, mapper, param);
	}
	
	// ResultSetExtractor
	ResultSetExtractor<BoardDto> extractor = new ResultSetExtractor<>() {
		@Override
		public BoardDto extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()) {
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
			else {
				return null;
			}
		}
	};

	// 5. 추상 메소드 오버라이딩 - 게시글 상세
	@Override
	public BoardDto selectOne(int boardNo) {
		String sql = "select * from board where board_no = ?";
		Object[] param = new Object[] {boardNo};
		return jdbcTemplate.query(sql, extractor, param);
	}

}
