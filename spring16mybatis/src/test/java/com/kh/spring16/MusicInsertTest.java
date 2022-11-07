package com.kh.spring16;

import java.sql.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring16.entity.MusicDto;

@SpringBootTest
public class MusicInsertTest {

	// 의존성 주입
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		
		MusicDto musicDto = MusicDto.builder().musicTitle("죽일놈").musicArtist("다이나믹듀오").musicAlbum("몰름").musicPlay(100).releaseTitle(Date.valueOf("2022-11-07")).build();
		
		sqlSession.insert("music.insert", musicDto);
		
	}
}
