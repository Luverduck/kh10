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
	
	// REST 방식의 API를 호출하기 위한 RestTemplate의 인스턴스 생성
	private RestTemplate template = new RestTemplate();
	
	// 의존성 주입 - Admin Key와 cid를 반환하기 위함
	@Autowired
	private KakaoPayProperties kakaoPayProperties;
	
	// 의존성 주입 - 결제 정보 등록을 위함
	@Autowired
	private PaymentDao paymentDao;

	// 추상 메소드 오버라이딩 - 결제 준비 요청을 보낸 후 결제 준비 응답을 반환
	@Override
	public KakaoPayReadyResponseVO ready(KakaoPayReadyRequestVO request) throws URISyntaxException {

		// 결제 준비 요청을 보낼 주소 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/ready");
		
		// REST API 요청의 header 설정
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + kakaoPayProperties.getKey()); // Admin Key
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		// REST API 요청의 body 설정
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", kakaoPayProperties.getCid()); // 가맹점 코드
		body.add("partner_order_id", request.getPartner_order_id()); // 가맹점 주문 번호
		body.add("partner_user_id", request.getPartner_user_id()); // 가맹점 회원 ID
		body.add("item_name", request.getItem_name()); // 상품명
		body.add("quantity", "1"); // 상품 수량
		body.add("total_amount", String.valueOf(request.getTotal_amount())); // 상품 총액
		body.add("tax_free_amount", "0"); // 상품 비과세 금액
		body.add("approval_url", "http://localhost:8888/pay/result/success"); // 결제 성공시 Redirect 주소
		body.add("cancel_url", "http://localhost:8888/pay/result/cancel"); // 결제 취소시 Redirect 주소
		body.add("fail_url", "http://localhost:8888/pay/result/fail"); // 결제 실패시 Redirect 주소
		
		// REST API 요청을 위한 HttpEntity 생성 - header와 body 결합
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
		
		// 요청 전송 후 KakaoPayReadyResponseVO 형태로 응답 반환
		KakaoPayReadyResponseVO response = template.postForObject(uri, entity, KakaoPayReadyResponseVO.class);
		
		// 응답 반환
		return response;
	}

	// 추상 메소드 오버라이딩 - 결제 승인 요청을 보낸 후 결제 승인 응답을 반환
	@Override
	public KakaoPayApproveResponseVO approve(KakaoPayApproveRequestVO request) throws URISyntaxException {
		
		// 결제 승인 요청을 보낼 주소 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/approve");
		
		// REST API 요청의 header 설정
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK "+kakaoPayProperties.getKey()); // Admin Key
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		// REST API 요청의 body 설정
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", kakaoPayProperties.getCid()); // 가맹점 코드
		body.add("tid", request.getTid()); // 결제 고유 번호
		body.add("partner_order_id", request.getPartner_order_id()); // 가맹점 주문 번호
		body.add("partner_user_id", request.getPartner_user_id()); // 가맹점 회원 ID
		body.add("pg_token", request.getPg_token()); // 결제 승인을 인증하는 토큰
		
		log.debug("partner_order_id = {}", request.getPartner_order_id());
		log.debug("partner_user_id = {}", request.getPartner_user_id());
		log.debug("tid = {}", request.getTid());
		log.debug("pg_token = {}", request.getPg_token());
		
		// REST API 요청을 위한 HttpEntity 생성 - header와 body 결합
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
		
		// 요청 전송 후 KakaoPayApproveResponseVO 형태로 응답 반환
		KakaoPayApproveResponseVO response = template.postForObject(uri, entity, KakaoPayApproveResponseVO.class);
		
		// 응답 반환
		return response;
	}

	// 추상 메소드 오버라이딩 - 결제 조회 요청을 보낸 후 결제 조회 응답을 반환
	@Override
	public KakaoPayOrderResponseVO order(KakaoPayOrderRequestVO request) throws URISyntaxException {
		
		// 결제 조회 요청을 보낼 주소 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/order");

		// REST API 요청의 header 설정
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + kakaoPayProperties.getKey());
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		// REST API 요청의 body 설정
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", kakaoPayProperties.getCid());//가맹점번호(테스트용)
		body.add("tid", request.getTid());

		// REST API 요청을 위한 HttpEntity 생성 - header와 body 결합
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
		
		// 요청 전송 후 KakaoPayOrderResponseVO 형태로 응답 반환
		KakaoPayOrderResponseVO response = template.postForObject(uri, entity, KakaoPayOrderResponseVO.class);
		
		// 응답 반환
		return response;
	}
	
	// 추상 메소드 오버라이딩 - 결제 취소 요청을 보낸 후 결제 취소 응답을 반환
	@Override
	public KakaoPayCancelResponseVO cancel(KakaoPayCancelRequestVO request) throws URISyntaxException {
		
		// 결제 취소 요청을 보낼 주소 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/cancel");
		
		// REST API 요청의 header 설정
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK "+kakaoPayProperties.getKey());
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		// REST API 요청의 body 설정
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", kakaoPayProperties.getCid());//가맹점번호(테스트용)
		body.add("tid", request.getTid());//거래번호
		body.add("cancel_amount", String.valueOf(request.getCancel_amount()));//취소 금액
		body.add("cancel_tax_free_amount", "0");//취소 비과세액
		
		// REST API 요청을 위한 HttpEntity 생성 - header와 body 결합
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
		
		// 요청 전송 후 KakaoPayCancelResponseVO 형태로 응답 반환
		KakaoPayCancelResponseVO response = template.postForObject(uri, entity, KakaoPayCancelResponseVO.class);
		
		// 응답 반환
		return response;
	}

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
}
