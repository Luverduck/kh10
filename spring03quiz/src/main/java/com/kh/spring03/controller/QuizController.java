package com.kh.spring03.controller;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// @RequestMapping("/quiz") : 공용 주소
// 만약 공용주소인 @RequestMapping("/quiz")를 쓸 경우 클래스 내부 RequestMapping에 생략 가능
public class QuizController {

	@RequestMapping("/quiz/bmi")	// 실제 주소 : /quiz/bmi
	@ResponseBody
	public String bmi(@RequestParam double kg, @RequestParam double cm) {	// 각각에 @RequestParam 쓰기
		double bmi = kg / (cm / 100) / (cm / 100);
		Format f = new DecimalFormat("#,##0.00");
		return "BMI 지수 : " + f.format(bmi);
	}
	
	@RequestMapping("/quiz/subway")	// 실제 주소 : /quiz/subway
	@ResponseBody
	public String subway(@RequestParam int year) {
		//int age = 2022 - year + 1;
		int age = Calendar.getInstance().get(Calendar.YEAR) - year + 1;
		int charge = 0;
		if(age >= 65 && age <= 7) {	// 영유아 + 어르신
			charge = 0;
		}
		else if(age < 13) {	// 어린이
			charge = 450;
		}
		else if(age < 19) {	// 청소년
			charge = 720;
		}
		else if(age < 64) {	// 성인
			charge = 1250;
		}
		return "지하철 요금 : " + charge + "원";
	}
	
	@RequestMapping("/quiz/calendar")	// 실제 주소 : /quiz/calendar
	@ResponseBody
	public String calendar(@RequestParam int year, @RequestParam int month) {
		Calendar c = Calendar.getInstance();	// Calendar의 인스턴스 생성
		c.set(year, month - 1, 1);				// 년, 월 세팅
		int day = c.getActualMaximum(Calendar.DATE);
		return year + "년 " + month + "월은 " + day + "일까지 있습니다";
		/*
		boolean leap = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
		int day = 0;
		switch(month) {
		case 2: 
			if(leap) {
				day = 29;
			}
			else {
				day = 28;
			}
			break;
		case 4: case 6: case 9: case 11:
			day = 30;
			break;
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			day = 31;
			break;
		}
		*/
	}
}
