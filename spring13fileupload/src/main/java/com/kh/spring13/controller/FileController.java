package com.kh.spring13.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

	@GetMapping("/")
	public String root() {
		return "root";
	}
	
	// 컨트롤러에서 파일 수신 처리
	// -> Multipart Request를 처리한다고 부름
	// -> apache commons fileupload 의존성의 CommonsMultipartResolver가 사용
	// -> Spring boot에서 내부적으로 multipartResolver를 등록
	// -> Spring Controller에서는 MultipartFile 형태로 파일을 수신
	// -> 기존에 사용하던 annotation 전부 지원
	
	@PostMapping("/")
	public String upload(
							@RequestParam String uploader,
							@RequestParam MultipartFile attachment
							) throws IllegalStateException, IOException {
		System.out.println("uploader = " + uploader);
		System.out.println("attachement = " + attachment);
		
		// attachement 분석
		System.out.println("content type = " + attachment.getContentType());
		System.out.println("name = " + attachment.getName());
		System.out.println("original file name = " + attachment.getOriginalFilename());	// 첨부파일의 이름
		System.out.println("size = " + attachment.getSize());
		
		// 사용자가 올린 파일을 저장
		// File 클래스 - java.io 패키지에 있는 클래스
		File directory = new File("C:\\Users\\hyeul\\upload");	// 업로드할 폴더(경로) 선택
		
		directory.mkdirs();	// 폴더 생성 명령
		
		File target = new File(directory, attachment.getOriginalFilename());	// 저장될 파일 생성 - 선택한 디렉토리 안에 해당 이름으로 저장
		
		attachment.transferTo(target);	// 실제 저장 처리 명령
		
		return "redirect:/";
	}
}
