package com.kh.spring24;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring24.entity.PaymentDetailDto;
import com.kh.spring24.entity.PaymentDto;
import com.kh.spring24.repository.PaymentDao;

@SpringBootTest
public class PayTest08 {

	@Autowired
	private PaymentDao paymentDao;
	
	@Test
	public void test() {
		// 계층형 조회를 myBatis 도움 없이 직접 구현
		// 1. 모든 payment를 조회
		List<PaymentDto> list = paymentDao.paymentHistory("eomhyunyoung1");
		System.out.println(list.size());
		
		for(PaymentDto paymentDto : list) {
			// PaymentDto
			List<PaymentDetailDto> subList = paymentDao.findPaymentDetail(paymentDto.getPaymentNo());
			System.out.println(subList.size());
		}
	}
}
