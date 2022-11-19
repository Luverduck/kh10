package com.kh.spring24;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring24.vo.PaymentVO;

@SpringBootTest
public class PayTest09 {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		List<PaymentVO> list= sqlSession.selectList("payment.paymentGroupList");
		System.out.println(list.size());
	}
}
