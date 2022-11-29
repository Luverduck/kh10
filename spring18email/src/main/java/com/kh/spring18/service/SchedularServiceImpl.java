package com.kh.spring18.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.kh.spring18.repository.CertDao;

@Service
public class SchedularServiceImpl implements SchedulerService {
	
	// 의존성 주입
	@Autowired
	private CertDao certDao;

	// Scheduler (스케쥴러)
	// - 특정 작업을 정기적으로 반복하여 실행하는 도구
	// - @EnableScheduling 필요
	// - 서비스에 @Scheduled를 추가
	
//	@Scheduled(fixedRate = 1000) // 1000ms마다 실행됨
//	@Scheduled(cron = "* * * * * *") // cron 표현식 - 매초 매분 매시 매일 매월 매요일 (= 매 1초마다)
	@Scheduled(cron = "0 * * * * *") // 0초 매분 매시 매일 매월 매요일 (= 매 1분마다)
//	@Scheduled(cron = "0,3	0 * * * * *") //0,30초 매분 매시 매일 매월 매요일 
//	@Scheduled(cron = "0-10 * * * * *") // 0~10초 매분 매시 매일 매월 매요일
//	@Scheduled(cron = "*/5 * * * * *") // 5초주기 매분 매시 매일 매월 매요일
	
	// 매시 정각 실행
//	@Scheduled(cron = "0 0 * * * *")
	
	// 출근(9), 퇴근(6)시에만
//	@Scheduled(cron = "0 0 9,18 * * *")
	
	// 매 업무시각 정각마다(9 to 6)
//	@Scheduled(cron = "0 0 9-18 * * *")
	
	// 월(mon) ~ 금(fri) 업무시각 정각마다(9 to 6)
//	@Scheduled(cron = "* * 9-18 * * mon-fri")
	
	// 매월 25일 오후 3시마다(ex : 급여)
	// - ? : 어떤 것이던 상관없음을 나타냄
//	@Scheduled(cron = "0 0 15 25 * ?")
	
	// 매 월 목요일
//	@Scheduled(cron = "* * * ? * thu")
	
	// 매 월 둘째주 목요일
//	@Scheduled(cron = "* * * ? * thu#2")
	
	// 매월 마지막 목요일
//	@Scheduled(cron = "* * * ? * 4L")
	
	// 매월 마지막 목요일
//	@Scheduled(cron = "* * * ? * thuL")
	
	// 추상 메소드 오버라이딩 - 만료된 인증정보 삭제
	@Override
	public void clearCert() {
		//System.out.println(LocalDateTime.now());
		certDao.clear();
	}
}
