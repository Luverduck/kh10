package com.kh.springhome.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.springhome.entity.ReplyDto;

@Repository
public class ReplyDaoImpl implements ReplyDao {

	// 의존성 주입
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	// 추상 메소드 오버라이딩 - 댓글 작성
	@Override
	public void replyWrite(ReplyDto replyDto) {
		String sql = "insert into reply(reply_no, reply_writer, reply_content, reply_origin) values(reply_seq.nextval, ?, ?, ?)";
		Object[] param = new Object[] {replyDto.getReplyWriter(), replyDto.getReplyContent(), replyDto.getReplyOrigin()};
		jdbcTemplate.update(sql, param);
	}
	
	// RowMapper
	private RowMapper<ReplyDto> mapper = new RowMapper<>() {
		@Override
		public ReplyDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			ReplyDto replyDto = new ReplyDto();
			replyDto.setReplyNo(rs.getInt("reply_no"));
			replyDto.setReplyWriter(rs.getString("reply_writer"));
			replyDto.setReplyOrigin(rs.getInt("reply_origin"));
			replyDto.setReplyWritetime(rs.getDate("reply_writetime"));
			replyDto.setReplyContent(rs.getString("reply_content"));
			return replyDto;
		}
	};

	// 추상 메소드 오버라이딩 - 댓글 목록
	@Override
	public List<ReplyDto> replyList(int replyOrigin) {
		String sql = "select * from reply where reply_origin = ? order by reply_writetime asc";
		Object[] param = new Object[] {replyOrigin};
		return jdbcTemplate.query(sql, mapper, param);
	}

	// 추상 메소드 오버라이딩 - 댓글 수정
	@Override
	public void replyUpdate(String replyContent, int replyNo) {
		String sql = "update reply set reply_content = ? where reply_no = ?";
		Object[] param = new Object[] {replyContent, replyNo};
		jdbcTemplate.update(sql, param);
	}
	
	// 추상 메소드 오버라이딩 - 댓글 삭제
	@Override
	public void replyDelete(int replyNo) {
		String sql = "delete reply where reply_no = ?";
		Object[] param = new Object[] {replyNo};
		jdbcTemplate.update(sql, param);
	}

	// 추상 메소드 오버라이딩 - 댓글 작성자 검사를 위한 작성자 반환
	@Override
	public String replyWriterReturn(int replyNo) {
		String sql = "select reply_writer from reply where reply_no = ?";
		Object[] param = new Object[] {replyNo};
		return jdbcTemplate.queryForObject(sql, String.class, param);
	}
}
