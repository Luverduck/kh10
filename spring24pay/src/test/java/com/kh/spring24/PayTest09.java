package com.kh.spring24;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring24.vo.PaymentVO;

@SpringBootTest
public class PayTest09 {

	// 의존성 주입
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		
		// 계층형 조회 구문 실행
		List<PaymentVO> list= sqlSession.selectList("payment.paymentGroupList");
		
		// 조회 결과
		System.out.println(list.size());
	}
}
