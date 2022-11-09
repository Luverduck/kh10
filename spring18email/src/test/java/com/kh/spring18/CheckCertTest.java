package com.kh.spring18;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring18.entity.CertDto;

@SpringBootTest
public class CheckCertTest {

	@Autowired
	private SqlSession sqlSession;
	
	String email = "eomhyunyoung@gmail.com";
	String serial = "849892";
	
	@Test
	public void test() {
		// 5분 이내 보내진 인증번호인가?
		CertDto result = sqlSession.selectOne("cert.check", CertDto.builder().who(email).serial(serial).build());
		// 5분이 지난 인증번호밖에 없으므로 null이 나옴
		System.out.println(result);
		//assertNull(result);
		
		if(result != null) { // 인증 성공
			System.out.println("인증 성공");
			sqlSession.delete("cert.delete", email);
		}
		else {
			System.out.println("인증 실패");
		}
	}
	
}
