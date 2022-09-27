package com.kh.springhome.service;

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
import org.springframework.stereotype.Service;

import com.kh.springhome.entity.AttachmentDto;
import com.kh.springhome.error.TargetNotFoundException;
import com.kh.springhome.repository.AttachmentDao;

@Service
public class AttachmentServiceImpl implements AttachmentService {

	@Autowired
	private AttachmentDao attachmentDao;
	
	private final File dir = new File("C:\\\\Users\\\\hyeul\\\\upload");
	
	@Override
	public ResponseEntity<ByteArrayResource> load(int attachmentNo) throws IOException {
		// 1. 파일 탐색(DB)
		AttachmentDto dto = attachmentDao.selectOne(attachmentNo);
		if(dto == null) {	// 찾으려는 파일이 없으면 null
//					return ResponseEntity.notFound().build();	// 404 error
			throw new TargetNotFoundException("존재하지 않는 파일");
		}
		
		// 찾으려는 파일이 있으면
		// 2. 파일 불러오기
		File target = new File(dir, String.valueOf(attachmentNo));
		byte[] data = FileUtils.readFileToByteArray(target);
		ByteArrayResource resource = new ByteArrayResource(data);
		
		// 3. 응답 객체를 만들어 데이터를 전송
		// 개선 - 상수를 이용한다
		return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_ENCODING, StandardCharsets.UTF_8.name())
					
					.contentLength(dto.getAttachmentSize())	// .header()와는 전혀 다른 메소드인 .contentLength() 사용
					
					.header(HttpHeaders.CONTENT_TYPE, dto.getAttachmentType())
				
					.contentType(MediaType.APPLICATION_OCTET_STREAM)	// 형태를 고정할 때만 유용하고 나머지는 header를 사용하는 것이 좋음
					
					.header(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment()
																							.filename(dto.getAttachmentName(), StandardCharsets.UTF_8)
																				.build().toString())
					.body(resource);	
	};
	
}
