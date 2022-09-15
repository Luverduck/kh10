package com.kh.spring12;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data					// getter & setter, toString을 생성
//@Setter @Getter		// 클래스 위에 붙이면 이 클래스의 모든 필드는 getter & setter를 가진다
//@ToString				// toString 생성
@NoArgsConstructor		// 기본 생성자를 생성
@AllArgsConstructor		// 모든 필드를 매개변수로 하는 생성자를 생성 -> 매개변수 있는 경우와 없는 경우 모두를 포함하기 위해
@Builder				
public class Student {

	// 필드 위에 붙이면 해당 필드만 getter & setter를 가진다
	private String name;
	private int score;
	
}
