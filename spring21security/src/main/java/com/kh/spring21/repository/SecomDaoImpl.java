package com.kh.spring21.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.kh.spring21.entity.SecomDto;

@Repository
public class SecomDaoImpl implements SecomDao {
	
	// 의존성 주입
	@Autowired
	private SqlSession sqlSession;
	
	// 의존성 주입
	@Autowired
	private PasswordEncoder encoder;

	// 추상 메소드 오버라이딩 - 회원 가입
	@Override
	public void join(SecomDto secomDto) {
		// 암호 반환
		String pw = secomDto.getPw();
		// 암호화
		String enc = encoder.encode(pw);
		// 암호화한 암호를 secomDto에 설정
		secomDto.setPw(enc);
		// 암호화된 암호로 회원 가입
		sqlSession.insert("secom.join", secomDto);
	}

	// 추상 메소드 오버라이딩 - 단일 조회
	@Override
	public SecomDto find(String id) {
		return sqlSession.selectOne("secom.get", id);
	}

	// 추상 메소드 오버라이딩 - 로그인
	@Override
	public boolean login(SecomDto secomDto) {
		// secomDto에서 아이디를 반환하여 단일 조회
		SecomDto findDto = sqlSession.selectOne("secom.get", secomDto.getId());
		// 찾는 데이터가 없으면 false 반환
		if(findDto == null) return false;
		// 원래 암호와 암호화된 암호 비교(반드시 matches로 할 것)
		boolean judge = encoder.matches(secomDto.getPw(), findDto.getPw());
		// 판정 결과 반환
		return judge;
	}

}
