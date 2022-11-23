package com.kh.spring25.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kh.spring25.entity.AttachmentDto;
import com.kh.spring25.repository.AttachmentDao;

@CrossOrigin(origins = "http://127.0.0.1:5500") // CORS 접근 허용 (외부 접근 허용)
@RestController
public class AttachmentController {

	// 기준 경로
	private File dir = new File(System.getProperty("user.home"), "/upload");
	
	@Autowired
	private AttachmentDao attachmentDao;
	
	// 업로드
	@PostMapping("/upload") // 이미지 다운로드 주소 반환
	public String upload(@RequestParam MultipartFile attach) throws IllegalStateException, IOException {
		// DB 저장
		int attachmentNo = attachmentDao.sequence();	
		attachmentDao.save(AttachmentDto.builder()
					.attachmentNo(attachmentNo)
					.attachmentName(attach.getOriginalFilename())
					.attachmentType(attach.getContentType())
					.attachmentSize(attach.getSize())
				.build());
		
		// 파일 저장
		dir.mkdirs();
		
		File target = new File(dir, String.valueOf(attachmentNo));
		attach.transferTo(target);
		
//		return "http://localhost:8888/download/"+attachmentNo;
		
		return ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/").path(String.valueOf(attachmentNo)).toUriString();
	}
	
	// 다운로드 - 기존 방식과 동일
	@GetMapping("/download/{attachmentNo}") // PathVariable 방식의 장점 : 정규표현식 사용 가능
	public ResponseEntity<ByteArrayResource> download(@PathVariable int attachmentNo) throws IOException{
		
		AttachmentDto attachmentDto = attachmentDao.find(attachmentNo);
		
		if(attachmentDto == null) {
			throw new IllegalArgumentException();
		}
		
		File target = new File(dir, String.valueOf(attachmentDto.getAttachmentNo()));
		
		if(!target.exists()) {
			throw new IllegalArgumentException();
		}
		
		byte[] data = FileUtils.readFileToByteArray(target);
		
		ByteArrayResource resource = new ByteArrayResource(data);
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_ENCODING, StandardCharsets.UTF_8.name())
				.header(HttpHeaders.CONTENT_TYPE, attachmentDto.getAttachmentType())
				.header(HttpHeaders.CONTENT_DISPOSITION, 
						ContentDisposition.attachment().filename(attachmentDto.getAttachmentName(), 
						StandardCharsets.UTF_8)
						.build().toString())
				.contentLength(attachmentDto.getAttachmentSize())
				.body(resource);
	}
}
