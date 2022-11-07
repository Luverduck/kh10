package com.kh.spring16;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring16.entity.MusicDto;

@SpringBootTest
public class MusicDetailTest {

	// 이존성 주입
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		MusicDto musicDto = sqlSession.selectOne("music.one", 46);
		System.out.println(musicDto);
	}
}
