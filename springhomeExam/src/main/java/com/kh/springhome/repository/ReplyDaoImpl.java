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

import com.kh.springhome.entity.ReplyDto;
import com.kh.springhome.vo.ReplyListVO;

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
			// DB의 char(1)을 논리로 변환
			replyDto.setReplyBlind(rs.getString("reply_blind") != null);
			return replyDto;
		}
	};
	
	// ReplyListVO를 위한 RowMapper
	private RowMapper<ReplyListVO> listMapper = new RowMapper<>() {

		@Override
		public ReplyListVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			ReplyListVO replyListVO = new ReplyListVO();
			replyListVO.setReplyNo(rs.getInt("reply_no"));
			replyListVO.setReplyWriter(rs.getString("reply_writer"));
			replyListVO.setReplyOrigin(rs.getInt("reply_origin"));
			replyListVO.setReplyWritetime(rs.getDate("reply_writetime"));
			replyListVO.setReplyContent(rs.getString("reply_content"));
			// DB의 char(1)을 논리로 변환
			replyListVO.setReplyBlind(rs.getString("reply_blind") != null);
			replyListVO.setMemberNick(rs.getString("member_nick"));
			replyListVO.setMemberGrade(rs.getString("member_grade"));
			return replyListVO;
		}
	};

	// 추상 메소드 오버라이딩 - 댓글 목록
	@Override
	public List<ReplyListVO> replyList(int replyOrigin) {
		String sql = "select R.*, M.member_nick, M.member_grade from reply R left outer join member M on R.reply_writer = M.member_id where R.reply_origin = ? order by reply_no asc";
		Object[] param = new Object[] {replyOrigin};
		return jdbcTemplate.query(sql, listMapper, param);
	}

	// 추상 메소드 오버라이딩 - 댓글 수정
	@Override
	public boolean replyUpdate(ReplyDto replyDto) {
		String sql = "update reply set reply_content = ? where reply_no = ?";
		Object[] param = new Object[] {replyDto.getReplyContent(), replyDto.getReplyNo()};
		return jdbcTemplate.update(sql, param) > 0;
	}
	
	// 추상 메소드 오버라이딩 - 댓글 삭제
	@Override
	public boolean replyDelete(int replyNo) {
		String sql = "delete reply where reply_no = ?";
		Object[] param = new Object[] {replyNo};
		return jdbcTemplate.update(sql, param) > 0;
	}
	
	// ResultSetExtractor
	private ResultSetExtractor<ReplyDto> extractor = new ResultSetExtractor<>() {
		@Override
		public ReplyDto extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()) {
				ReplyDto replyDto = new ReplyDto();
				replyDto.setReplyNo(rs.getInt("reply_no"));
				replyDto.setReplyWriter(rs.getString("reply_writer"));
				replyDto.setReplyOrigin(rs.getInt("reply_origin"));
				replyDto.setReplyWritetime(rs.getDate("reply_writetime"));
				replyDto.setReplyContent(rs.getString("reply_content"));
				// DB의 char(1)을 논리로 변환
				replyDto.setReplyBlind(rs.getString("reply_blind") != null);
				return replyDto;
			}
			else {
				return null;
			}
		}	
	};

	// 추상 메소드 오버라이딩 - 댓글 정보
	@Override
	public ReplyDto selectOne(int replyNo) {
		String sql = "select * from reply where reply_no = ?";
		Object[] param = new Object[] {replyNo};
		return jdbcTemplate.query(sql, extractor, param);
	}

	// 추상 메소드 오버라이딩 - 댓글 블라인드
	@Override
	public boolean updateBlind(int replyNo, boolean replyBlind) {
		String sql = "update reply set reply_blind = ? where reply_no = ?";
		String setReplyBlind = replyBlind ? "Y" : null;	// 삼항 연산
		Object[] param = new Object[] {setReplyBlind, replyNo};
		return jdbcTemplate.update(sql, param) > 0;
	}
}
