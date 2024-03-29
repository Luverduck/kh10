package com.kh.spring18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling // 스케쥴러 사용 설정
@SpringBootApplication
public class Spring18emailApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring18emailApplication.class, args);
	}

}
