package com.kh.spring15;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring15.entity.GuestBookDto;

@SpringBootTest
public class GuestBookUpdateTest {

	// 의존성 주입
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		
		int count = sqlSession.update("guestbook.edit", GuestBookDto.builder()
																		.no(3)
																		.name("바꾼이름")
																		.memo("바꾼내용")
																	.build());
		System.out.println("count = " + count);
	}
}
