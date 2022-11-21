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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.spring24.entity.MemberDto;
import com.kh.spring24.entity.PaymentDetailDto;
import com.kh.spring24.entity.PaymentDto;
import com.kh.spring24.entity.ProductDto;
import com.kh.spring24.repository.PaymentDao;
import com.kh.spring24.repository.ProductDao;
import com.kh.spring24.service.KakaoPayService;
import com.kh.spring24.vo.KakaoPayApproveRequestVO;
import com.kh.spring24.vo.KakaoPayApproveResponseVO;
import com.kh.spring24.vo.KakaoPayCancelRequestVO;
import com.kh.spring24.vo.KakaoPayCancelResponseVO;
import com.kh.spring24.vo.KakaoPayOrderRequestVO;
import com.kh.spring24.vo.KakaoPayOrderResponseVO;
import com.kh.spring24.vo.KakaoPayReadyRequestVO;
import com.kh.spring24.vo.KakaoPayReadyResponseVO;
import com.kh.spring24.vo.PurchaseItemVO;
import com.kh.spring24.vo.PurchaseVO;

@Controller
public class PayController {
	
	// 의존성 주입
	@Autowired
	private SqlSession sqlSession;
	
	// 의존성 주입
	@Autowired
	private KakaoPayService kakaoPayService;
	
	// 의존성 주입 - 상품 목록 조회를 위함
	@Autowired
	private ProductDao productDao;
	
	// 의존성 주입
	@Autowired
	private PaymentDao paymentDao;
	
	// 홈 Mapping
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	// 로그인 Mapping
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDto memberDto, HttpSession session) {
		
		// 입력받은 회원 아이디로 단일 조회
		MemberDto findDto = sqlSession.selectOne("member.get", memberDto.getMemberId());
		
		// 해당 아이디의 회원 정보가 없으면 홈 Mapping으로 강제 이동(redirect)
		if(findDto == null) return "redirect:/";
		
		// 해당 아이디의 회원 정보가 존재하면 비밀번호를 비교하여 일치 여부 반환
		boolean judge = memberDto.getMemberPw().equals(findDto.getMemberPw());
		
		// 해당 아이디의 비밀번호가 입력한 비밀번호와 같으면
		if(judge) {
			session.setAttribute("loginId", findDto.getMemberId()); // HttpSession에 아이디 저장
			session.setAttribute("loginNick", findDto.getMemberNick()); // HttpSession에 닉네임 저장
			session.setAttribute("loginAuth", findDto.getMemberGrade()); // HttpSession에 회원등급 저장
		}
		
		// 그 외의 경우는 모두 홈 Mapping으로 강제 이동(redirect)
		return "redirect:/";
	}
	
	// 로그아웃 Mapping
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		// HttpSession 무효화
		session.invalidate();
		
		// 홈 Mapping으로 강제 이동(redirect)
		return "redirect:/";
	}
	
	// 사이트 결제 Mapping
	@GetMapping("/pay1")
	public String pay1() {
		// 사이트 결제 페이지(pay1.jsp)로 연결
		return "pay1";
	}
	
	// 카카오페이 결제 준비 Mapping
	@PostMapping("/pay1")
	public String pay1(@ModelAttribute KakaoPayReadyRequestVO request, HttpSession session) throws URISyntaxException {
		
		// 결제 준비 요청을 위한 VO에 정보 설정
		request.setPartner_order_id(UUID.randomUUID().toString()); // 가맹점 주문 번호 설정
		String memberId = (String)session.getAttribute("loginId"); // HttpSession에서 회원 아이디 반환
		request.setPartner_user_id(memberId); // 반환한 회원 아이디를 가맹점 회원 ID로 설정
		
		// 카카오페이로 결제 준비 요청 전송 후 응답 반환
		KakaoPayReadyResponseVO response = kakaoPayService.ready(request);
		
		// 결제 승인을 위한 값을 미리 HttpSession에 저장
		session.setAttribute("tid", response.getTid());
		session.setAttribute("partner_order_id", request.getPartner_order_id());
		session.setAttribute("partner_user_id", request.getPartner_user_id());
		
		// 사용자를 결제 준비 응답에 포함된 PC URL로 강제 이동(redirect)
		return "redirect:" + response.getNext_redirect_pc_url();
	}
	
	// 다중 상품 결제 Mapping
	@GetMapping("/pay2")
	public String pay2(Model model) {
		// 상품 목록을 조회하여 Model에 첨부
		model.addAttribute("list", productDao.list());
		// 상품 목록 페이지(pay2.jsp)로 연결
		return "pay2";
	}
	
	// 카카오페이 상품 결제 준비 Mapping
	@PostMapping("/pay2")
	public String pay2(HttpSession session, @ModelAttribute PurchaseVO purchaseVO) throws URISyntaxException {
		
		// 체크된 상품 정보가 없으면 상품 구메 Mapping으로 강제 이동(redirect)
		if(purchaseVO.getData().isEmpty()) {
			return "redirect:pay2";
		}
		
		// 다중 항목 구매에 대한 처리
		// 구매 정보를 DB에 등록하기 위한 List
		List<ProductDto> list = new ArrayList<>();
		// 결제 준비 요청을 위한 총액(total_amount)
		int total_amount = 0;
		// PurchaseVO의 List 형태인 data 안의 PurchaseItemVO 각각에 대해 다음 시행을 반복
		for(PurchaseItemVO vo : purchaseVO.getData()) {
			// 상품 번호로 단일 조회하여 ProductDto 반환
			ProductDto productDto = productDao.find(vo.getNo());
			// 반환한 ProductDto를 List에 저장
			list.add(productDto);
			// ProductDto에서 반환한 상품 가격과 PurchaseItemVO에서 반환한 갯수의 곱을 총액에 덧셈
			total_amount += productDto.getPrice() * vo.getQty();
		}
		
		// 다중 항목 구매에 대한 상품명 처리
		// 첫 번째 상품의 상품명 반환
		String item_name = list.get(0).getName();
		// 상품이 2개 이상이라면
		if(list.size() >= 2) {
			// 상품명이 "[첫 번째 상품명] 외 N개"의 형태가 되도록 문자열 덧셈 
			item_name += " 외 " + (list.size() - 1) + "개";
		}
		
		// 결제 번호 반환
		int paymentNo = paymentDao.paymentSequence();
		
		// 결제 준비 요청을 위한 VO에 정보 설정
		KakaoPayReadyRequestVO request = KakaoPayReadyRequestVO.builder()
									.partner_order_id(String.valueOf(paymentNo))
									.partner_user_id((String)session.getAttribute("loginId"))
									.item_name(item_name)
									.total_amount(total_amount) 
								.build();
		
		// 카카오페이로 결제 준비 요청 전송 후 응답 반환
		KakaoPayReadyResponseVO response = kakaoPayService.ready(request);
		
		// 결제 승인을 위한 값을 미리 HttpSession에 저장
		session.setAttribute("tid", response.getTid());
		session.setAttribute("partner_order_id", request.getPartner_order_id());
		session.setAttribute("partner_user_id", request.getPartner_user_id());
		
		// 결제 승인 후 DB 등록을 위한 값을 HttpSession에 저장
		session.setAttribute("list", list); // 구매 상품의 List<ProductDto>
		session.setAttribute("data", purchaseVO.getData()); // 구매 상품의 List<PurchaseItemVO>
		
		// 사용자를 결제 준비 응답에 포함된 PC URL로 강제 이동(redirect)
		return "redirect:" + response.getNext_redirect_pc_url();
	}
	
	// 카카오페이 결제 승인 Mapping
	@GetMapping("/pay/result/success")
	public String paySuccess(HttpSession session, @RequestParam String pg_token) throws URISyntaxException {
		
		// 결제 승인을 위해 HttpSession에 저장했던 값을 반환
		String tid = (String)session.getAttribute("tid");
		String partner_order_id = (String)session.getAttribute("partner_order_id");
		String partner_user_id = (String)session.getAttribute("partner_user_id");
		List<ProductDto> list = (List<ProductDto>)session.getAttribute("list");
		List<PurchaseItemVO> data = (List<PurchaseItemVO>)session.getAttribute("data");
		
		// 반환이 끝난 값을 HttpSession에서 삭제
		session.removeAttribute("tid");
		session.removeAttribute("partner_order_id");
		session.removeAttribute("partner_user_id");
		session.removeAttribute("list");
		session.removeAttribute("data");
		
		// 결제 승인 요청을 위한 VO에 정보 설정
		KakaoPayApproveRequestVO request = KakaoPayApproveRequestVO.builder()
																	.tid(tid)
																	.partner_order_id(partner_order_id)
																	.partner_user_id(partner_user_id)
																	.pg_token(pg_token)
																.build();
		
		// 카카오페이로 결제 승인 요청 전송 후 응답 반환
		KakaoPayApproveResponseVO response = kakaoPayService.approve(request);
		
		// Integer 형태의 partner_order_id 값을 int로 변환
		int paymentNo = Integer.parseInt(partner_order_id);
		
		// payment 테이블에 결제 정보 등록
		paymentDao.paymentInsert(PaymentDto.builder()
												.paymentNo(paymentNo)
												.memberId((String)session.getAttribute("loginId"))
												.itemName(response.getItem_name())
												.totalAmount(response.getAmount().getTotal())
												.approveAt(response.getApproved_at())
												.tid(tid)
											.build());
		
		// payment_detail 테이블에 세부 결제 정보 등록
		for(int i = 0 ; i < list.size() ; i ++) {
			// 구매 상품 List<ProductDto>에서 ProductDto 반환
			ProductDto productDto = list.get(i);
			// 구매 상품 List<PurchaseItemVO>에서 PurchaseItemVO 반환
			PurchaseItemVO itemVO = data.get(i);
			// 세부 결제 번호 반환
			int paymentDetailNo = paymentDao.paymentDetailSequence();
			// 반환한 값들로 payment_detail 테이블에 정보 등록
			paymentDao.paymentDetailInsert(PaymentDetailDto.builder()
																.paymentDetailNo(paymentDetailNo)
																.paymentNo(paymentNo)
																.productNo(productDto.getNo())
																.productName(productDto.getName())
																.qty(itemVO.getQty())
																.productPrice(productDto.getPrice() * itemVO.getQty())
															.build());
		}
		
		// 결제 승인 완료 Mapping으로 강제 이동(redirect)
		return "redirect:/pay/result/success_view";
	}
	
	// 카카오페이 결제 승인 완료 Mapping
	@GetMapping("/pay/result/success_view")
	public String successView() {
		
		// 최종 결제 성공 페이지(succes_view.jsp)로 연결
		return "success_view";
	}
	
	// 주문 내역 조회 Mapping
	@GetMapping("/list")
	public String list(HttpSession session, Model model) {
		
		// HttpSession에서 로그인 중인 회원 아이디 반환
		String memberId = (String)session.getAttribute("loginId");
		
		// 반환한 회원 아이디로 결제 정보 단일 조회
		List<PaymentDto> list = paymentDao.paymentHistory(memberId);
		
		// 조회의 결과를 model에 첨부
		model.addAttribute("list", list);
		
		// 주문 내역 목록 페이지(list.jsp)로 연결
		return "list";
	}
	
	// 카카오페이 결제 조회 Mapping
	@GetMapping("/detail")
	public String detail(@RequestParam int paymentNo, Model model) throws URISyntaxException {
		
		// 주문 내역 목록 페이지에서 전달받은 결제 번호(paymentNo)를 통해 결제 정보 조회
		PaymentDto paymentDto = paymentDao.findPayment(paymentNo);
		
		// 결제 조회 요청을 위한 VO에 정보 설정
		KakaoPayOrderRequestVO request = KakaoPayOrderRequestVO.builder().tid(paymentDto.getTid()).build();
		
		// 카카오페이로 결제 조회 요청 전송 후 응답 반환
		KakaoPayOrderResponseVO response = kakaoPayService.order(request);
		
		// 카카오페이로부터 받은 결제 조회 응답을 model에 첨부
		model.addAttribute("info", response);
		
		// 결제 번호로 조회한 결제 정보를 model에 첨부
		model.addAttribute("paymentDto", paymentDto);
		
		// 결제 번호로 조회한 결제 상세 정보를 model에 첨부
		model.addAttribute("paymentDetailList", paymentDao.findPaymentDetail(paymentNo));
		
		// 결제 상세 페이지(detail.jsp)로 연결
		return "detail";
	}
	
	// 카카오페이 전체 취소 Mapping
	@GetMapping("/cancel_all")
	public String cancelAll(@RequestParam int paymentNo, RedirectAttributes attr) throws URISyntaxException {

		// 결제 번호(paymentNo)로 결제 정보 조회
		PaymentDto paymentDto = paymentDao.findPayment(paymentNo);

		// 결제 취소 요청을 위한 VO에 정보 설정
		KakaoPayCancelRequestVO request = KakaoPayCancelRequestVO.builder().tid(paymentDto.getTid()).cancel_amount(paymentDto.getTotalAmount()).build();
		
		// 카카오페이로 결제 취소 요청 전송 후 응답 반환
		KakaoPayCancelResponseVO response = kakaoPayService.cancel(request);

		// 결제 정보 테이블(payment)에서 해당 결제 번호 상품의 결제 상태를 '취소'로 변경
		paymentDao.cancelPayment(paymentNo);
		
		// 세부 결제 정보 테이블(payment_detail)에서 해당 결제 번호의 모든 세부 결제 상품의 결제 상태를 '취소'로 변경
		paymentDao.cancelPaymentDetail(paymentNo);

		// 해당 결제 번호의 카카오페이 결제 조회 Mapping으로 강제 이동(redirect)
		attr.addAttribute("paymentNo", paymentNo);
		return "redirect:detail";
	}

	// 카카오페이 부분 취소 Mapping
	@GetMapping("/cancel_item")
	public String cancelItem(@RequestParam int paymentDetailNo, RedirectAttributes attr) throws URISyntaxException {
		
		// 해당 세부 결제 번호(paymentDetailNo)의 세부 결제 상품의 세부 결제 정보를 조회
		PaymentDetailDto paymentDetailDto = paymentDao.findPaymentDetailItem(paymentDetailNo);
		
		// 세부 결제 상품의 결제 번호(paymentNo)를 반환하여 결제 정보를 조회
		PaymentDto paymentDto = paymentDao.findPayment(paymentDetailDto.getPaymentNo());

		// 결제 취소 요청을 위한 VO에 정보 설정
		KakaoPayCancelRequestVO request = KakaoPayCancelRequestVO.builder().tid(paymentDto.getTid()).cancel_amount(paymentDetailDto.getProductPrice()).build();
		
		// 카카오페이로 결제 취소 요청 전송 후 응답 반환
		KakaoPayCancelResponseVO response = kakaoPayService.cancel(request);

		// 세부 결제 번호에 해당하는 세부 결제 상품의 결제 상태를 '취소'로 변경
		paymentDao.cancelPaymentDetailItem(paymentDetailNo);
		
		// 부분 취소의 갯수에 따라 전체 결제 상태 변경
		paymentDao.refreshPayment(paymentDto.getPaymentNo());

		// 해당 결제 번호의 카카오페이 결제 조회 Mapping으로 강제 이동(redirect)
		attr.addAttribute("paymentNo", paymentDto.getPaymentNo());
		return "redirect:detail";
	}
}
