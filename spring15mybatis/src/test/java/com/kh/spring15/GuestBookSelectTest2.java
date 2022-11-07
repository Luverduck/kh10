package com.kh.spring15;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring15.entity.GuestBookDto;

@SpringBootTest
public class GuestBookSelectTest2 {

	// 의존성 주입
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		// 단일 조회 : selectOne() - 결과가 2개 이상 나오면 error
		int no = 12;
		GuestBookDto dto = sqlSession.selectOne("guestbook.one", no);
		System.out.println(dto);
	}
}
