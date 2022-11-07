package com.kh.spring15;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring15.entity.GuestBookDto;

@SpringBootTest
public class GuestBookInsertTest {
	
	// 의존성 주입
	@Autowired
	private SqlSession sqlSession;

	@Test
	public void test() {
		
		// assertNotNull(sqlSession);
		
		GuestBookDto guestBookDto = GuestBookDto.builder().no(3).name("사람").memo("잘먹감").build();
		
		sqlSession.insert("guestbook.insertGuestBook", guestBookDto);
	}
}
