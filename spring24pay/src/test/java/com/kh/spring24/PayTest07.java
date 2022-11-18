package com.kh.spring24;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.spring24.configuration.KakaoPayProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PayTest07 {

	@Autowired
	private KakaoPayProperties kakaoPayProperties;
	
	private RestTemplate template = new RestTemplate();
	
	@Test
	public void test() throws URISyntaxException {
		//목표 : 결제 취소
		
		String tid = "T376df637c755d998182";
		int cancel_amount = 100;
		
		//주소 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/cancel");
		
		//헤더 설정
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK "+kakaoPayProperties.getKey());
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		//바디 설정
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", kakaoPayProperties.getCid());//가맹점번호(테스트용)
		body.add("tid", tid);//거래번호
		body.add("cancel_amount", String.valueOf(cancel_amount));//취소 금액
		body.add("cancel_tax_free_amount", "0");//취소 비과세액
		
		//보낼 내용 합체
		HttpEntity<MultiValueMap<String, String>> entity = 
											new HttpEntity<>(body, headers);
		
		//요청
		Map response = template.postForObject(uri, entity, Map.class);
		log.debug("response = {}", response);
	}
}
