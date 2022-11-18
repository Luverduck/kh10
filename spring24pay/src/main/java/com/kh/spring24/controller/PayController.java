package com.kh.spring24.controller;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring24.entity.MemberDto;
import com.kh.spring24.entity.PaymentDetailDto;
import com.kh.spring24.entity.PaymentDto;
import com.kh.spring24.entity.ProductDto;
import com.kh.spring24.repository.PaymentDao;
import com.kh.spring24.repository.ProductDao;
import com.kh.spring24.service.KakaoPayService;
import com.kh.spring24.vo.KakaoPayApproveRequestVO;
import com.kh.spring24.vo.KakaoPayApproveResponseVO;
import com.kh.spring24.vo.KakaoPayOrderRequestVO;
import com.kh.spring24.vo.KakaoPayReadyRequestVO;
import com.kh.spring24.vo.KakaoPayReadyResponseVO;
import com.kh.spring24.vo.PurchaseItemVO;
import com.kh.spring24.vo.PurchaseVO;

@Controller
public class PayController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private PaymentDao paymentDao;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDto memberDto, HttpSession session) {
		
		MemberDto findDto = sqlSession.selectOne("member.get", memberDto.getMemberId());
		
		if(findDto == null) return "redirect:/";
		
		boolean judge = memberDto.getMemberPw().equals(findDto.getMemberPw());
		
		if(judge) {
			session.setAttribute("loginId", findDto.getMemberId());
			session.setAttribute("loginNick", findDto.getMemberNick());
			session.setAttribute("loginAuth", findDto.getMemberGrade());
		}
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// 결제 페이지 1번 - 입력창에 입력하면 결제가 되도록 구현
	@GetMapping("/pay1")
	public String pay1() {
		return "pay1";
	}
	
	@Autowired
	private KakaoPayService kakaoPayService;
	
	// 결제 페이지 2번
	@PostMapping("/pay1")
	public String pay1(@ModelAttribute KakaoPayReadyRequestVO vo, HttpSession session) throws URISyntaxException {
		String memberId = (String)session.getAttribute("loginId");
		vo.setPartner_user_id(memberId);
		vo.setPartner_order_id(UUID.randomUUID().toString());
		
		KakaoPayReadyResponseVO response = kakaoPayService.ready(vo);
		
		// 4번 시점에서 9번 시점에 필요한 데이터를 세션에 저장
		session.setAttribute("tid", response.getTid());
		session.setAttribute("partner_order_id", vo.getPartner_order_id());
		session.setAttribute("partner_user_id", vo.getPartner_user_id());
		
		return "redirect:" + response.getNext_redirect_pc_url();
	}
	
	// 결제 성공시 자동으로 호출될 주소
	@GetMapping("/pay/result/success")
	public String paySuccess(HttpSession session, @RequestParam String pg_token) throws URISyntaxException {
		
		// 9번 시점에서 4번 시점에서 세션에 저장한 데이터를 추출 및 삭제
		String tid = (String)session.getAttribute("tid");
		String partner_order_id = (String)session.getAttribute("partner_order_id");
		String partner_user_id = (String)session.getAttribute("partner_user_id");
		List<ProductDto> list = (List<ProductDto>)session.getAttribute("list");
		List<PurchaseItemVO> data = (List<PurchaseItemVO>)session.getAttribute("data");
		
		session.removeAttribute("tid");
		session.removeAttribute("partner_order_id");
		session.removeAttribute("partner_user_id");
		session.removeAttribute("list");
		session.removeAttribute("data");
		
		KakaoPayApproveRequestVO vo = KakaoPayApproveRequestVO.builder()
																	.tid(tid)
																	.partner_order_id(partner_order_id)
																	.partner_user_id(partner_user_id)
																	.pg_token(pg_token)
																.build();
		
		KakaoPayApproveResponseVO response = kakaoPayService.approve(vo);
		
		// 이 시점에서 데이터베이스에 모든 정보를 INSERT 해야 한다
		// - 결제가 완료되었으므로
		// (1) 대표 정보 INSERT 후 (2) 상세정보 INSERT
		int paymentNo = paymentDao.paymentSequence();
		paymentDao.paymentInsert(PaymentDto.builder()
												.paymentNo(paymentNo)
												.memberId((String)session.getAttribute("loginId"))
												.itemName(response.getItem_name())
												.totalAmount(response.getAmount().getTotal())
												.approveAt(response.getApproved_at())
												.tid(tid)
											.build());
		
		for(int i = 0 ; i < list.size() ; i ++) {
			ProductDto productDto = list.get(i);
			PurchaseItemVO itemVO = data.get(i);
			int paymentDetailNo = paymentDao.paymentDetailSequence();
			paymentDao.paymentDetailInsert(PaymentDetailDto.builder()
																.paymentDetailNo(paymentDetailNo)
																.paymentNo(paymentNo)
																.productNo(productDto.getNo())
																.productName(productDto.getName())
																.qty(itemVO.getQty())
																.productPrice(productDto.getPrice() * itemVO.getQty())
															.build());
		}
		
		return "redirect:/pay/result/success_view";
	}
	
	@GetMapping("/pay/result/success_view")
	public String successView() {
		return "success_view";
	}
	
	@Autowired
	private ProductDao productDao;
	
	@GetMapping("/pay2")
	public String pay2(Model model) {
		model.addAttribute("list", productDao.list());
		return "pay2";
	}
	
	@PostMapping("/pay2")
	public String pay2(HttpSession session, @ModelAttribute PurchaseVO purchaseVO) throws URISyntaxException {
		// 카카오 페이에 보낼 정보를 계산
		// - 상품이 1개이면 - 상품 이름이 결제 상품명이고 결제 금액은 상품 금액 * 수량
		// EX) 500원짜리 초코파이 3개를 사면 결제명="초코파이", 금액 = 1500
		// - 상품이 여러개이면 - 상품명은 첫 번째 상품명 외 ?개로 한다
		// EX) 500원짜리 초코파이 2개와 300원짜리 마이쮸 3개를 사면 결제명="초코파이 외 1개", 금액 = 1900
		
		if(purchaseVO.getData().isEmpty()) {
			return "redirect:pay2";
		}
		
		// (추가)
		// - 결제 정보를 등록하려면 반드시 상품 정보를 알아야 한다(List<ProductDto>)
		List<ProductDto> list = new ArrayList<>();
		int total_amount = 0;
		for(PurchaseItemVO vo : purchaseVO.getData()) {
			// 상품 번호로 상품 찾기
			ProductDto productDto = productDao.find(vo.getNo());
			// 찾은 상품 정보를 list에 저장
			list.add(productDto);
			// 상품 가격과 갯수의 곱을 총액에 더함
			total_amount += productDto.getPrice() * vo.getQty();
		}
		
		// 상품명 설정
		// - 첫 번째 상품명 가져오기
		String item_name = list.get(0).getName();
		if(list.size() >= 2) {
			item_name += " 외 " + (list.size() - 1) + "개";
		}
		
		int paymentNo = paymentDao.paymentSequence();
		KakaoPayReadyRequestVO vo = KakaoPayReadyRequestVO.builder()
																.partner_order_id(UUID.randomUUID().toString())
																.partner_order_id(String.valueOf(paymentNo))
																.partner_user_id((String)session.getAttribute("loginId"))
																.item_name(item_name)
																.total_amount(total_amount)
															.build();
		
		KakaoPayReadyResponseVO response = kakaoPayService.ready(vo); // 3
		
		//4번 시점에서 9번 시점에 필요한 데이터를 세션에 저장
		session.setAttribute("tid", response.getTid());
		session.setAttribute("partner_order_id", vo.getPartner_order_id());
		session.setAttribute("partner_user_id", vo.getPartner_user_id());
		session.setAttribute("list", list); // 상품 목록
		session.setAttribute("data", purchaseVO.getData()); // 상품 수량 목록
		
		return "redirect:" + response.getNext_redirect_pc_url();
	}
	
	//주문 조회 페이지
	@GetMapping("/detail")
	public String detail(@RequestParam String tid, Model model) throws URISyntaxException {
		KakaoPayOrderRequestVO vo = KakaoPayOrderRequestVO
				.builder().tid(tid).build();
		model.addAttribute("info", kakaoPayService.order(vo));
		return "detail";
	}
}
