package com.kh.spring18.repository;

import com.kh.spring18.entity.CertDto;

public interface CertDao {

	// 추상 메소드 - 인증번호 등록
	void insert(CertDto certDto);
	
	// 추상 메소드 - 인증번호 삭제
	boolean delete(String who);
	
	// 추상 메소드 - 인증번호 조회(5분 이내 발급된 인증번호인지)
	boolean check(CertDto certDto);
	
	// 추상 메소드 - 만료된 인증정보 삭제
	void clear();
}
