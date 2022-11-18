package com.kh.spring24.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.spring24.configuration.KakaoPayProperties;
import com.kh.spring24.entity.PaymentDetailDto;
import com.kh.spring24.entity.PaymentDto;
import com.kh.spring24.entity.ProductDto;
import com.kh.spring24.repository.PaymentDao;
import com.kh.spring24.vo.KakaoPayApproveRequestVO;
import com.kh.spring24.vo.KakaoPayApproveResponseVO;
import com.kh.spring24.vo.KakaoPayCancelRequestVO;
import com.kh.spring24.vo.KakaoPayCancelResponseVO;
import com.kh.spring24.vo.KakaoPayOrderRequestVO;
import com.kh.spring24.vo.KakaoPayOrderResponseVO;
import com.kh.spring24.vo.KakaoPayReadyRequestVO;
import com.kh.spring24.vo.KakaoPayReadyResponseVO;
import com.kh.spring24.vo.PurchaseItemVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KakaoPayServiceImpl implements KakaoPayService {
	
	private RestTemplate template = new RestTemplate();
	
	@Autowired
	private KakaoPayProperties kakaoPayProperties;

	@Override
	public KakaoPayReadyResponseVO ready(KakaoPayReadyRequestVO vo) throws URISyntaxException {

		// 주소 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/ready");
		
		// 헤더 설정
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + kakaoPayProperties.getKey());
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		// 바디 설정
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", kakaoPayProperties.getCid()); // 가맹점 번호(테스트용)
		body.add("partner_order_id", vo.getPartner_order_id()); // 주문 번호
		body.add("partner_user_id", vo.getPartner_user_id()); // 고객 번호
		body.add("item_name", vo.getItem_name()); // 판매할 상품명
		body.add("quantity", "1"); // 수량
		body.add("total_amount", String.valueOf(vo.getTotal_amount())); // 구매 금액
		body.add("tax_free_amount", "0"); // 비과세(0원)
		body.add("approval_url", "http://localhost:8888/pay/result/success"); // 성공시 실행될 주소
		body.add("cancel_url", "http://localhost:8888/pay/result/cancel"); // 취소시 실행될 주소
		body.add("fail_url", "http://localhost:8888/pay/result/fail"); // 실패시 실행될 주소
		
		// 헤더와 바디 결합
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
		
		// 요청 전송
		KakaoPayReadyResponseVO response = template.postForObject(uri, entity, KakaoPayReadyResponseVO.class);
		
		// 요청 내용 반환
		return response;
	}

	@Override
	public KakaoPayApproveResponseVO approve(KakaoPayApproveRequestVO vo) throws URISyntaxException {
		//주소 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/approve");
		
		//헤더 설정
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK "+kakaoPayProperties.getKey());
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		//바디 설정
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", kakaoPayProperties.getCid());//가맹점번호(테스트용)
		body.add("tid", vo.getTid());//거래번호
		body.add("partner_order_id", vo.getPartner_order_id());//주문번호
		body.add("partner_user_id", vo.getPartner_user_id());//고객번호
		body.add("pg_token", vo.getPg_token());//인증용 토큰
		
		log.debug("partner_order_id = {}", vo.getPartner_order_id());
		log.debug("partner_user_id = {}", vo.getPartner_user_id());
		log.debug("tid = {}", vo.getTid());
		log.debug("pg_token = {}", vo.getPg_token());
		
		//보낼 내용 합체
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
		
		//요청
		KakaoPayApproveResponseVO response = template.postForObject(uri, entity, KakaoPayApproveResponseVO.class);
		
		return response;
	}

	@Override
	public KakaoPayOrderResponseVO order(KakaoPayOrderRequestVO vo) throws URISyntaxException {
		//주소 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/order");

		//헤더 설정
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK "+kakaoPayProperties.getKey());
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		//바디 설정
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", kakaoPayProperties.getCid());//가맹점번호(테스트용)
		body.add("tid", vo.getTid());

		//보낼 내용 합체
		HttpEntity<MultiValueMap<String, String>> entity = 
											new HttpEntity<>(body, headers);

		//요청
		KakaoPayOrderResponseVO response = 
				template.postForObject(uri, entity, KakaoPayOrderResponseVO.class);
		return response;
	}
	
	@Autowired
	private PaymentDao paymentDao;

	@Override
	public void insertPayment(PaymentDto paymentDto, List<ProductDto> list, List<PurchaseItemVO> data) {
		//- 결제가 완료되었으니까
		//(1) 대표정보 insert 후 (2) 상세정보 상품 개수만큼 insert
		paymentDao.paymentInsert(paymentDto);
		
		for(int i=0; i < list.size(); i++) {
			ProductDto productDto = list.get(i);
			PurchaseItemVO itemVO = data.get(i);
			int paymentDetailNo = paymentDao.paymentDetailSequence();
			paymentDao.paymentDetailInsert(
					PaymentDetailDto.builder()
						.paymentDetailNo(paymentDetailNo)
						.paymentNo(paymentDto.getPaymentNo())
						.productNo(productDto.getNo())
						.productName(productDto.getName())
						.qty(itemVO.getQty())
						.productPrice(productDto.getPrice() * itemVO.getQty())
					.build());
		}
	}
	
	@Override
	public KakaoPayCancelResponseVO cancel(KakaoPayCancelRequestVO vo) throws URISyntaxException {
		//주소 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/cancel");
		
		//헤더 설정
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK "+kakaoPayProperties.getKey());
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		//바디 설정
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", kakaoPayProperties.getCid());//가맹점번호(테스트용)
		body.add("tid", vo.getTid());//거래번호
		body.add("cancel_amount", String.valueOf(vo.getCancel_amount()));//취소 금액
		body.add("cancel_tax_free_amount", "0");//취소 비과세액
		
		//보낼 내용 합체
		HttpEntity<MultiValueMap<String, String>> entity = 
											new HttpEntity<>(body, headers);
		
		//요청
		KakaoPayCancelResponseVO response = 
				template.postForObject(uri, entity, KakaoPayCancelResponseVO.class);
		return response;
	}
}
