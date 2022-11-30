package com.kh.react.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.react.entity.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	// 의존성 주입
	@Autowired
	private SqlSession sqlSession;

	// 추상 메소드 - 회원 단일 조회
	@Override
	public MemberDto login(MemberDto memberDto) {
		
		// 단일 조회
		MemberDto findDto = sqlSession.selectOne("member.get", memberDto.getMemberId());
		
		// 조회 결과가 null이면 return
		if(findDto == null) return null;
		
		// 비밀번호 일치 여부 판정
		boolean judge = memberDto.getMemberPw().equals(findDto.getMemberPw());
		
		// 비밀번호가 일치한다면
		if(judge) {
			return findDto; // 해당 조회 결과 반환
		}
		
		// 그 외 null 반환
		return null;
	}
}
