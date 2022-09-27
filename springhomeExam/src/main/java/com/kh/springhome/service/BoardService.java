package com.kh.springhome.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.kh.springhome.entity.BoardDto;

public interface BoardService {
	
	// INSERT, UPDATE, DELETE를 2회 이상 같은 Controller에서 해야 한다면 Service로 처리하도록 하는게 좋다

	// 추상 메소드 - 게시글 작성 : 메소드 실행 결과로 게시글 번호르 반환하도록
	int write(BoardDto boardDto, List<MultipartFile> attachment) throws IllegalStateException, IOException;
}
