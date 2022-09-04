package com.kh.springhome.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.springhome.entity.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insert(MemberDto memberDto) {
		String sql = "insert into member("
										+ "member_id, "
										+ "member_pw, "
										+ "member_nick, "
										+ "member_birth, "
										+ "member_tel, "
										+ "member_email, "
										+ "member_post, "
										+ "member_base_address, "
										+ "member_detail_address, "
										+ "member_point, "
										+ "member_grade, "
										+ "member_join, "
										+ "member_login"
										+ ") "
								+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, 0, '일반', sysdate, null)";
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

	
}
