package com.kh.springhome.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kh.springhome.entity.AttachmentDto;
import com.kh.springhome.error.TargetNotFoundException;
import com.kh.springhome.repository.AttachmentDao;

@Service
public class AttachmentServiceImpl implements AttachmentService {
	
	@Autowired
	private AttachmentDao attachmentDao;
	
	private final File dir = new File("D:/upload");
	
	@Override
	public ResponseEntity<ByteArrayResource> load(int attachmentNo) throws IOException {
		//[1] 파일 탐색(DB)
		AttachmentDto dto = attachmentDao.selectOne(attachmentNo);
		if(dto == null) {//파일이 없으면
			//return ResponseEntity.notFound().build();//404 error 전송
			throw new TargetNotFoundException("존재하지 않는 파일");
		}
		
		//[2] 파일 불러오기
		File target = new File(dir, String.valueOf(attachmentNo));
		byte[] data = FileUtils.readFileToByteArray(target);
		ByteArrayResource resource = new ByteArrayResource(data);
		
		//[3] 응답 객체를 만들어 데이터를 전송
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_ENCODING, 
										StandardCharsets.UTF_8.name())
				.contentLength(dto.getAttachmentSize())
				.header(HttpHeaders.CONTENT_TYPE , 
										dto.getAttachmentType())
				.header(HttpHeaders.CONTENT_DISPOSITION, 
									ContentDisposition.attachment()
											.filename(
													dto.getAttachmentName(), 
													StandardCharsets.UTF_8)
											.build().toString())
				.body(resource);
	}
	
}
