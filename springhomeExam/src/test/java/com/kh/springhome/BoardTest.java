package com.kh.springhome;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.springhome.entity.BoardDto;
import com.kh.springhome.repository.BoardDao;

@SpringBootTest
public class BoardTest {

	@Autowired
	private BoardDao boardDao;
	
	@BeforeEach
	public void before() {
		boardDao.write("admin", "반가워요", "소통해요", "공지");
	}
	
	@Test
	public void test() {
		
	}
	
	@AfterEach
	public void after() {
		// DB 전부 삭제 (TEST 후 삭제용)
		boardDao.clear();
	}
}
