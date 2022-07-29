package loop;

//소수 판정 프로그램
//소수는 나누어 떨어지는 값이 없는 숫자를 말합니다 (ex : 2, 3, 5, 7, 11, 13, 17, 19, ...)
//어짜피 모든 숫자는 1로 나누기가 가능하고 자기 자신으로 나누기가 가능합니다

import java.lang.*;
import java.util.Scanner;

public class Test09 {
	public static void main(String[] args) {
		
		//준비
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
		//원리 : 숫자 A를 숫자 B로 나눌 때 나머지가 0인 경우 나눌 수 있음을 의미하며 숫자 B는 숫자 A의 약수가 된다
		
		//계산
		int count = 0;
		for(int i = 1; i <= number; i++) {
			//System.out.println(number + " % " + i + " = " + number % i);
			if(number % i == 0) {//number가 i로 나누어 떨어진다면(나머지가 0이라면)
				count++;
			}
		}
		
		System.out.println("약수의 개수 = " + count);
		
		//출력
		if(count == 2) {//나눗셈을 해서 약수가 2개인 수를 찾자
			System.out.println("숫자 " + number + "는 소수입니다");
		}
		else {
			System.out.println("숫자 " + number + "는 소수가 아닙니다");
		}
		
	}

}