package com.kh.spring16;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring16.entity.MusicDto;

@SpringBootTest
public class MusicUpdateTest {

	// 이존성 주입
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		
		MusicDto musicDto = MusicDto.builder().musicTitle("윤하").musicArtist("우리가사랑한진짜이유").musicAlbum("몰름").musicPlay(50).musicNo(9).build();
		
		int count = sqlSession.update("music.edit", musicDto);
		
		System.out.println(count);
	}
}
