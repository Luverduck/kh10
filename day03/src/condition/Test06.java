package condition;

//과속 단속 카메라 프로그래밍
//다음 요구사항에 맞는 과속단속 카메라용 프로그래밍을 구현하세요
//-50km/h를 초과하는 속도로 달리는 자동차를 단속합니다
//-벌금은 제한속도보다 10km/h 늘어날 때마다 10000원씩 증가 ex) 65km시 40000원
//-벌금은 시작이 30000원입니다
//-벌금은 최대 70000원까지 부여할 수 있습니다
//자동차 속도를 입력 받아서 에상되는 벌금을 출력하는 프로그램을 구현

import java.lang.*;

public class Test06 {
	public static void main(String[] args) {
		
		//준비
		int V = 20;
		int limitV = 50;
		int initialFine = 30000;
		int kmPerFine = 10000;
		
		//계산
		//boolean over = 주항속도 > 제한속도; (의사코드)
		boolean over = V > limitV;
		
		int fine;
		if(over) {//if(over == true)와 같은 코드
			fine = initialFine + (kmPerFine * ((V - limitV) / 10));
			if(fine > 70000) {//벌금이 70000원 이상일 경우
				fine = 70000;
			}
			else {//생략 가능
				
			}
		}
		else {
			fine = 0;
		}
		
		//출력
		System.out.println("벌금은 " + fine + "원 입니다");
		
	}

}
