package com.kh.spring24.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "custom.pay")
public class KakaoPayProperties {
	private String key; // REST API 요청의 header에서 Authorization 값
	private String cid; // REST API 요청의 body에서 cid 값
}
