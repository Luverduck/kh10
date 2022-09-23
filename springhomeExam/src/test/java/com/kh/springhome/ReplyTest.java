package com.kh.springhome;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.springhome.entity.ReplyDto;
import com.kh.springhome.repository.ReplyDao;
import com.kh.springhome.vo.ReplyListVO;

@SpringBootTest
public class ReplyTest {

	@Autowired
	private ReplyDao replyDao;
	
	@BeforeEach
	public void before() {
		// replyWrite()
		for(int i = 1 ; i <= 100 ; i ++) {
			replyDao.replyWrite(ReplyDto.builder()
											.replyWriter("tester1")
											.replyContent("댓글테스트" + i)
											.replyOrigin(1)
										.build());
		}
	}
	
	@Test
	public void test() {
		// replyList()
		List<ReplyListVO> list = replyDao.replyList(1);
		for(ReplyListVO replyDto : list) {
			System.out.println(replyDto);
		}
	}
}
