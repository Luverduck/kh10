package com.kh.spring04.controller;

import java.util.Random;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/quiz")
public class QuizController {

	// 1. 시작(begin)과 종료(end)값을 정수로 입력받아 해당 구간의 숫자 합계 출력
	@RequestMapping("/sum")
	@ResponseBody
	public String sum(@RequestParam int begin, @RequestParam int end) {
		int sum = 0;
		for(int i = begin ; i <= end ; i ++) {
			sum += i;
		}
		return begin + "부터 " + end + "까지 정수의 합계 : " + sum;
	}
	
	// 2. 문제 개수(count)를 입력받아 해당 개수만큼 구구단 문제를 랜덤으로 출력
	// 다중 접속 환경이므로 StringBuffer를 사용해야 한다 (쓰레드 동기화)
	@RequestMapping("/gugudan")
	@ResponseBody
	public StringBuffer gugudan(@RequestParam int count) {
		Random r = new Random();
		StringBuffer problem = new StringBuffer();
		for(int i = 1 ; i <= count ; i ++) {
			int first = r.nextInt(8) + 2;
			int second = r.nextInt(9) + 1;
			problem.append(first + " X " + second + " = ?");
			problem.append("<br>");
		}
		return problem;
	}
	
	/*
	@RequestMapping("/gugudan")
	@ResponseBody
	public String gugudan(@RequestParam int count) {
		Random r = new Random();
		String[] problem = new String[count];
		for(int i = 0 ; i < count ; i ++) {
			int first = r.nextInt(8) + 2;
			int second = r.nextInt(9) + 1;
			problem[i] = first + " X " + second + " = ?";
		};
		return Arrays.toString(problem);
	}
	*/
	
	// *** 파라미터가 같은 이름으로 여러 개 존재하는 경우
	// - 1) 배열
	// - 2) collection
	// 3. 전달된 v에 해당하는 모든 값들의 합계를 구하여 출력
	@RequestMapping("/total")
	@ResponseBody
	public String sum(@RequestParam List<Integer> v) {
		int total = 0;
		/*
		for(int i = 0 ; i < v.size() ; i ++) {
			total += v.get(i);
		}
		*/
		// 또는
		for(int n : v) {
			total += n;
		}
		
		return "합계 : " + total;
	}
}
