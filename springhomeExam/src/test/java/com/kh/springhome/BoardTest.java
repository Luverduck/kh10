package com.kh.springhome;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

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
		// DB의 시퀀스 번호 생성
		String sql = "select board_seq.nextval from dual";
		int boardNo = jdbcTemplate.queryForObject(sql, int.class);
		System.out.println("boardNo = " + boardNo);
		
		// 등록
		sql = "insert into board(board_no, board_title, board_content, board_writer, board_head) values(?, ?, ?, ?, ?)";
		Object[] param = new Object[] {boardNo, "테스트", "테스트", "hello1234", null};
		jdbcTemplate.update(sql, param);
	}
	
	@AfterEach
	public void after() {
		// DB 전부 삭제 (TEST 후 삭제용)
		//boardDao.clear();
	}
}
