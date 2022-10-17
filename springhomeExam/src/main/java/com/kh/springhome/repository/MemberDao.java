package com.kh.springhome.repository;

import java.util.List;

import com.kh.springhome.entity.MemberDto;
import com.kh.springhome.vo.MemberMyBoardVO;
import com.kh.springhome.vo.MemberMyLikeVO;
import com.kh.springhome.vo.MemberMyReplyVO;
import com.kh.springhome.vo.MemberWriteCountVO;

public interface MemberDao {
 
	// MemberDao의 추상 메소드 (입력 메소드)
	void insert(MemberDto memberDto);
	
	// MemberDao의 추상 메소드 (조회 메소드)
	List<MemberDto> selectList();
	List<MemberDto> selectList(String type, String keyword);
	
	// MemberDao의 추상 메소드 (상세 조회 메소드)
	MemberDto selectOne(String memberId);
	
	// MemberDao의 추상 메소드 (수정 메소드)
	boolean update(MemberDto memberDto);
	
	// MemberDao의 추상 메소드 (삭제 메소드)
	boolean delete(String memberId);
	
	// MemberDao의 추상 메소드 (비밀번호 변경)
	boolean changePassword(String memberId, String memberPw);
	
	// MemberDao의 추상 메소드 (개인정보 변경)
	boolean changeInformation(MemberDto memberDto);
	
	// MemberDao의 추상 메소드 (로그인 시간 갱신)
	boolean updateLoginTime(String memberId);
	
	// 추상 메소드 - 글을 가장 많이 쓴 회원
	List<MemberWriteCountVO> writeCount();
	
	List<MemberWriteCountVO> writeCount(Integer memberEnd);
	
	// 추상 메소드 - 내가 작성한 게시글
	List<MemberMyBoardVO> myBoard(String memberId);
	
	// 추상 메소드 - 내가 좋아요한 작성글
	List<MemberMyLikeVO> myLike(String memberId);
	
	// 추상 메소드 - 내가 작성한 댓글
	List<MemberMyReplyVO> myReply(String memberId);
	
	// 추상 메소드 - 닉네임을 이용한 단일 조회 (닉네임 검사용)
	MemberDto findByNickname(String memberNick);
}
