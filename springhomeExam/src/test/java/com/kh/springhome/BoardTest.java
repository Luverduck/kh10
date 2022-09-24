package com.kh.springhome;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kh.springhome.entity.BoardDto;
import com.kh.springhome.repository.BoardDao;

@SpringBootTest
public class BoardTest {

	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@BeforeEach
	public void before() {
		//boardDao.write("admin", "반가워요", "소통해요", "공지");
		// 등록한 데이터의 번호는?
		// select * from board where board_no = (select max(board)
	}
	
	@Test
	public void test() {
		for(int i = 1 ; i <= 22 ; i ++) {
			boardDao.writeTest(BoardDto.builder()
											.boardHead(null)
											.boardTitle("테스트" + i)
											.boardContent("테스트" + i)
											.boardWriter("myface")
										.build());
		}
	}
	
	@AfterEach
	public void after() {
		// DB 전부 삭제 (TEST 후 삭제용)
		//boardDao.clear();
	}
}
