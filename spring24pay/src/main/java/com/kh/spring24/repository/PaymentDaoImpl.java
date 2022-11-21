	package com.kh.spring24.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring24.entity.PaymentDetailDto;
import com.kh.spring24.entity.PaymentDto;

@Repository
public class PaymentDaoImpl implements PaymentDao {

	// 의존성 주입
	@Autowired
	private SqlSession sqlSession;
	
	// 추상 메소드 오버라이딩 - 결제 번호 반환
	@Override
	public int paymentSequence() {
		return sqlSession.selectOne("payment.paymentSequence");
	}
	
	// 추상 메소드 오버라이딩 - 결제 정보 등록
	@Override
	public void paymentInsert(PaymentDto paymentDto) {
		sqlSession.insert("payment.paymentInsert", paymentDto);
	}
	
	// 추상 메소드 오버라이딩 - 세부 결제 번호 반환
	@Override
	public int paymentDetailSequence() {
		return sqlSession.selectOne("payment.paymentDetailSequence");
	}
	
	// 추상 메소드 오버라이딩 - 세부 결제 정보 등록
	@Override
	public void paymentDetailInsert(PaymentDetailDto paymentDetailDto) {
		sqlSession.insert("payment.paymentDetailInsert", paymentDetailDto);
	}
	
	// 추상 메소드 오버라이딩 - 결제 내역 전체 조회
	@Override
	public List<PaymentDto> paymentHistory(String memberId) {
		return sqlSession.selectList("payment.paymentHistory", memberId);
	}
	
	// 추상 메소드 오버라이딩 - 결제 번호를 이용하여 결제 정보 조회
	@Override
	public PaymentDto findPayment(int paymentNo) {
		return sqlSession.selectOne("payment.findPayment", paymentNo);
	}
	
	// 추상 메소드 오버라이딩 - 결제 번호를 이용하여 결제 상세 정보 조회
	@Override
	public List<PaymentDetailDto> findPaymentDetail(int paymentNo) {
		return sqlSession.selectList("payment.findPaymentDetail", paymentNo);
	}
	
	// 추상 메소드 오버라이딩 - 해당 결제 번호의 결제 상품의 결제 상태를 '취소'로 변경
	@Override
	public void cancelPayment(int paymentNo) {
		sqlSession.update("payment.cancelPayment", paymentNo);
	}
	
	// 추상 메소드 오버라이딩 - 해당 결제 번호의 세부 결제 상품의 결제 상태를 '취소'로 변경
	@Override
	public void cancelPaymentDetail(int paymentNo) {
		sqlSession.update("payment.cancelPaymentDetail", paymentNo);
	}
	
	// 추상 메소드 오버라이딩 - 세부 결제 번호를 이용하여 세부 결제 정보 조회
	@Override
	public PaymentDetailDto findPaymentDetailItem(int paymentDetailNo) {
		return sqlSession.selectOne("payment.findPaymentDetailItem", paymentDetailNo);
	}
	
	// 추상 메소드 오버라이딩 - 해당 세부 결제 번호의 세부 결제 상품의 결제 상태를 '취소'로 변경
	@Override
	public void cancelPaymentDetailItem(int paymentDetailNo) {
		sqlSession.update("payment.cancelPaymentDetailItem", paymentDetailNo);
	}
	
	// 추상 메소드 오버라이딩 - 부분 취소 결과에 따라 전체 결제의 상태를 '취소' 또는 '부분취소'로 변경
	@Override
	public void refreshPayment(int paymentNo) {
		sqlSession.update("payment.refreshPayment", paymentNo);
	}
}
