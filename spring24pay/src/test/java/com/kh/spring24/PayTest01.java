package com.kh.spring24;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PayTest01 {

	@Test
	public void test() throws URISyntaxException {
		
		// 카카오 페이 서버로 전송 도구 필요
		RestTemplate template = new RestTemplate();
		
		// 주소 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/ready");
		
		// 헤더 설정
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK 02ba9d21a91b6206d4e3822d37a444ac");
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		// 바디 설정
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", "TC0ONETIME"); // 가맹점 번호(테스트용)
		body.add("partner_order_id", UUID.randomUUID().toString()); // 주문 번호
		body.add("partner_user_id", UUID.randomUUID().toString()); // 고객 번호
		body.add("item_name", "강남아파트 외 1건"); // 판매할 상품명
		body.add("quantity", "1"); // 수량
		body.add("total_amount", "550000"); // 구매 금액
		body.add("tax_free_amount", "0"); // 비과세(0원)
		body.add("approval_url", "http://localhost:8888/pay/result/success"); // 성공시 실행될 주소
		body.add("cancel_url", "http://localhost:8888/pay/result/cancel"); // 취소시 실행될 주소
		body.add("fail_url", "http://localhost:8888/pay/result/fail"); // 실패시 실행될 주소
		
		// 헤더와 바디 결합
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
		
		// 요청 전송
		Map response = template.postForObject(uri, entity, Map.class);
		
		log.debug("response = {}", response);
	}
}
