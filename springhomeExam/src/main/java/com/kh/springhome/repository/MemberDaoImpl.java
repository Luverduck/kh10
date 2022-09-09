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

import com.kh.springhome.entity.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 추상 메소드 오버라이딩 (입력)
	@Override
	public void insert(MemberDto memberDto) {
		// 테이블 생성시 default를 설정한 컬럼(point, grade, join, login)의 값은 입력하지 않아도 된다
		String sql = "insert into member("
										+ "member_id, "
										+ "member_pw, "
										+ "member_nick, "
										+ "member_birth, "
										+ "member_tel, "
										+ "member_email, "
										+ "member_post, "
										+ "member_base_address, "
										+ "member_detail_address) "
								+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] param = new Object[] {
										memberDto.getMemberId(), 
										memberDto.getMemberPw(), 
										memberDto.getMemberNick(), 
										memberDto.getMemberBirth(), 
										memberDto.getMemberTel(), 
										memberDto.getMemberEmail(), 
										memberDto.getMemberPost(), 
										memberDto.getMemberBaseAddress(), 
										memberDto.getMemberDetailAddress()
										// 관리자가 설정해야 할 항목
										// memberDto.getMemberPoint(),
										// memberDto.getMemberGrade(),
										// memberDto.getMemberJoin(),
										// 로그인시 설정해야 할 항목 (일단 null)
										// memberDto.getMemberLogin()
										};
		jdbcTemplate.update(sql, param);
	}
	
	// RowMapper
	private RowMapper<MemberDto> mapper = new RowMapper<>() {
		@Override
		public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberId(rs.getString("member_id"));
			memberDto.setMemberPw(rs.getString("member_pw"));
			memberDto.setMemberNick(rs.getString("member_nick"));
			memberDto.setMemberBirth(rs.getDate("member_birth"));
			memberDto.setMemberTel(rs.getString("member_tel"));
			memberDto.setMemberEmail(rs.getString("member_email"));
			memberDto.setMemberPost(rs.getString("member_post"));
			memberDto.setMemberBaseAddress(rs.getString("member_base_address"));
			memberDto.setMemberDetailAddress(rs.getString("member_detail_address"));
			memberDto.setMemberPoint(rs.getInt("member_point"));
			memberDto.setMemberGrade(rs.getString("member_grade"));
			memberDto.setMemberJoin(rs.getDate("member_join"));
			memberDto.setMemberLogin(rs.getDate("member_login"));
			return memberDto;
		}
	};
	
	// 추상 메소드 오버라이딩 (조회)
	@Override
	public List<MemberDto> selectList() {
		String sql = "select * from member order by member_id asc";
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public List<MemberDto> selectList(String type, String keyword) {
		String sql = "select * from member where instr(#1, ?) > 0 order by #1 asc";
		sql = sql.replace("#1", type);
		Object[] param = new Object[] {keyword};
		return jdbcTemplate.query(sql, mapper, param);
	}
	
	// ResultSetExtractor
	private ResultSetExtractor<MemberDto> extractor = new ResultSetExtractor<>() {
		@Override
		public MemberDto extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()) {
				MemberDto memberDto = new MemberDto();
				memberDto.setMemberId(rs.getString("member_id"));
				memberDto.setMemberPw(rs.getString("member_pw"));
				memberDto.setMemberNick(rs.getString("member_nick"));
				memberDto.setMemberBirth(rs.getDate("member_birth"));
				memberDto.setMemberTel(rs.getString("member_tel"));
				memberDto.setMemberEmail(rs.getString("member_email"));
				memberDto.setMemberPost(rs.getString("member_post"));
				memberDto.setMemberBaseAddress(rs.getString("member_base_address"));
				memberDto.setMemberDetailAddress(rs.getString("member_detail_address"));
				memberDto.setMemberPoint(rs.getInt("member_point"));
				memberDto.setMemberGrade(rs.getString("member_grade"));
				memberDto.setMemberJoin(rs.getDate("member_join"));
				memberDto.setMemberLogin(rs.getDate("member_login"));
				return memberDto;
			}
			else {
				return null;
			}
		}
	};

	// 추상 메소드 오버라이딩 (상세 조회)
	@Override
	public MemberDto selectOne(String memberId) {
		String sql = "select * from member where member_id = ? order by member_join asc";
		Object[] param = new Object[] {memberId};
		return jdbcTemplate.query(sql, extractor, param);
	}

	// 추상 메소드 오버라이딩 (수정)
	@Override
	public boolean update(MemberDto memberDto) {
		// 바꿀 정보 : pw, nick, tel, email, post, baseaddress, detailaddress, point, grade
		String sql = "update member set member_pw = ?, member_nick = ?, member_tel = ?, member_email = ?, member_post = ?, member_base_address = ?, member_detail_address = ?, member_point = ?, member_grade = ? where member_id = ?";
		Object[] param = new Object[] {
										memberDto.getMemberPw(), 
										memberDto.getMemberNick(), 
										memberDto.getMemberTel(), 
										memberDto.getMemberEmail(), 
										memberDto.getMemberPost(), 
										memberDto.getMemberBaseAddress(), 
										memberDto.getMemberDetailAddress(), 
										memberDto.getMemberPoint(), 
										memberDto.getMemberGrade(), 
										memberDto.getMemberId()
										};
		return jdbcTemplate.update(sql, param) > 0;
	}

	// 추상 메소드 오버라이딩 (삭제)
	@Override
	public boolean delete(String memberId) {
		String sql = "delete member where member_id = ?";
		return jdbcTemplate.update(sql, memberId) > 0;
	}
}
