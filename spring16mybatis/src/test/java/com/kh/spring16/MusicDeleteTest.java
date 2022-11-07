package com.kh.spring16;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MusicDeleteTest {

	// 이존성 주입
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		
		int no = 121;
		
		int count = sqlSession.delete("music.delete", no);
		
		System.out.println("count = " + count);
	}
}
