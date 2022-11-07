package com.kh.spring15;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring15.entity.GuestBookDto;

@SpringBootTest
public class GuestBookSelectTest {

	// 의존성 주입
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		// 주의 : select는 selectList()와 selectOne()으로 나눠지며 목표에 맞게 사용
		List<GuestBookDto> list =  sqlSession.selectList("guestbook.list");
		System.out.println(list.size());
		for(GuestBookDto dto : list) {
			System.out.println(dto);
		}
	}
}
