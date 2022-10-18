package com.kh.spring13.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring13.entity.AttachmentDto;
import com.kh.spring13.repository.AttachmentDao;

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
	
	// 의존성 주입
	@Autowired
	private AttachmentDao attachmentDao;
	
	// 파일 업로드 Mapping
	// 파일 업로드 Mapping에 DTO 전달 및 DB 처리 후 파일 저장
	@PostMapping("/upload")
	public String upload(@RequestParam MultipartFile attachment) throws IllegalStateException, IOException {
		
		// 첨부파일 업로드 기록 등록
		// 파일 업로드 기록 등록을 위해 다음 시퀀스 번호 반환
		int attachmentNo = attachmentDao.sequence();
		
		// AttachmentDto의 인스턴스 생성
		// - 첨부파일 번호(attachmentNo)는 반환한 다음 시퀀스 번호
		// - 첨부파일 이름(attachmentName)은 전달받은 MultipartFile의 원본 파일 이름
		// - 첨부파일 종류(attachmentType)는 전달받은 MultipartFile의 파일 종류
		// - 첨부파일 크기(attachmentSize)는 전달받은 MultipartFile의 파일 크기
		// 생성한 AttachmentDto의 인스턴스로 첨부파일 업로드 기록 등록(INSERT) 
		attachmentDao.insert(AttachmentDto.builder()
											.attachmentNo(attachmentNo)
											.attachmentName(attachment.getOriginalFilename())
											.attachmentType(attachment.getContentType())
											.attachmentSize(attachment.getSize())
										.build());
		
		// 실제 첨부파일을 특정 경로에 저장
		// 해당 문자열을 추상 경로로 변환하여 File 클래스의 인스턴스 생성
		File dir = new File("C:\\\\Users\\\\hyeul\\\\upload");
		
		// 해당 추상 경로의 디렉토리 생성 (폴더가 없으면 자동으로 생성)
		dir.mkdirs();
		
		// dir의 추상 경로를 상위 경로, 해당 파일의 시퀀스 번호를 하위 경로로 하는 File의 인스턴스 생성
		File target = new File(dir, String.valueOf(attachmentNo));
		
		// View에서 전달받은 MultipartFile을 해당 디렉토리로 보내서 시퀀스 번호를 파일명으로 바꿔서 저장
		attachment.transferTo(target);
		return "redirect:/";
	}
	
	// 파일 업로드 기록 전체조회 Mapping
	@GetMapping("/list")
	public String list(Model model) {
		
		// model에 전체조회 결과를 첨부
		model.addAttribute("list", attachmentDao.selectList());
		return "list";
	}
	
	// 파일 다운로드 Mapping
	// - 
	@GetMapping("/download")
	public ResponseEntity<ByteArrayResource> download(@RequestParam int attachmentNo) throws IOException{
		
		// 입력받은 첨부파일 번호(attachmentNo)로 단일 조회 실행
		AttachmentDto attachmentDto = attachmentDao.selectOne(attachmentNo);
		
		// 해당 첨부파일 번호(attachmentNo)의 첨부파일이 존재하지 않을 경우
		if(attachmentDto == null) {
			return ResponseEntity.notFound().build();	// 404 error
		}
		
		// 해당 첨부파일 번호(attachmentNo)의 첨부파일이 존재할 경우
		// 해당 문자열을 추상 경로로 변환하여 File 클래스의 인스턴스 생성
		File directory = new File("C:\\\\Users\\\\hyeul\\\\upload");
		
		// dir의 추상 경로를 상위 경로, 해당 파일의 시퀀스 번호를 하위 경로로 하는 File의 인스턴스 생성
		File target = new File(directory, String.valueOf(attachmentNo));
		
		// target의 내용을 byte 배열로 변환
		byte[] data = FileUtils.readFileToByteArray(target);
		
		// byte 배열인 data를 이용하여 ByteArrayResource의 인스턴스 생성
		ByteArrayResource resource = new ByteArrayResource(data);
		
		// HTTP Response Header에 내용의 인코딩 방식, 길이, 배치 방식, resource의 형식 정보를 반환
		// HTTP Response Body에 ByteArrayResource를 포함하는 ResponseEntity 반환
/*		// 원형
		return ResponseEntity.ok()
			.header("Content-Encoding", "UTF-8")
			.header("Content-Length", String.valueOf(attachmentDto.getAttachmentSize()))	// DB에 있는 size 정보로
			.header("Content-Disposition", "attachment; filename=" + attachmentDto.getAttachmentName())	// DB의 첨부파일명으로
			.header("Content-Type", attachmentDto.getAttachmentType())	// DB에 있는 type 정보로
			.body(resource);
*/
		// 개선 - 상수를 이용한다
		return ResponseEntity.ok()
//			.header("Content-Encoding", "UTF-8")
			.header(HttpHeaders.CONTENT_ENCODING, StandardCharsets.UTF_8.name())
			
//			.header("Content-Length", String.valueOf(dto.getAttachmentSize()))
			.contentLength(attachmentDto.getAttachmentSize())	// .header()와는 전혀 다른 메소드인 .contentLength() 사용
			
//			.header("Content-Type", dto.getAttachmentType())
			.contentType(MediaType.APPLICATION_OCTET_STREAM)	// 형태를 고정할 때만 유용하고 나머지는 header를 사용하는 것이 좋음
			
//			.header("Content-Disposition", "attachment; filename=" + dto.getAttachmentName())
			.header(HttpHeaders.CONTENT_DISPOSITION, 
					ContentDisposition.attachment().filename(attachmentDto.getAttachmentName(), 
					StandardCharsets.UTF_8)
					.build().toString())
			.body(resource);			
	}
}
