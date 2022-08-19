package api.util.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test03_me {
/*
	검색엔진 검색어 수집기 만들기
	검색엔진은 사용자가 입력한 정보를 수집하도록 설계되어 있습니다. 
	이를 토대로 예측을 한다던가 다양한 방법으로 활용을 합니다. 
	빈도만 측정하려고 할 때, 사용자에게 지속적으로 검색어를 입력받고 이를 카운팅하는 프로그램을 구현

	주의사항
	- 대문자 소문자를 무시하도록 구현하세요
	- java와 j a v a는 같은 단어로 취급되도록 처리
		검색어 입력 : 자바
		[자바] 검색이 완료되었습니다. 현재 검색횟수 [1]

		검색어 입력 : 자바
		[자바] 검색이 완료되었습니다. 현재 검색횟수 [2]

		검색어 입력 : 파이썬
		[파이썬] 검색이 완료되었습니다. 현재 검색횟수 [3]

		검색어 입력 : 종료
		검색 프로그램을 종료합니다.
*/	
	public static void main(String[] args) {
		
		// Map 생성 - 검색어(String)과 빈도수(Integer)를 세트로 저장해야 한다
		Map<String, Integer> data = new HashMap<>();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			// 검색어(input) 입력
			System.out.print("검색어를 입력하세요 : ");
			String input = sc.nextLine();

			// "종료" 입력시 구문 탈출
			if (input.equals("종료")) {
				break;
			}

			// 입력을 대문자로 전환 (대소문자 구분이 없도록 대문자로 변환하여 저장하기 위해)
			String inputUpper = input.toUpperCase();	// 1) 소문자 변환
			inputUpper = inputUpper.trim();				// 2) 좌우 불필요한 여백 제거
			inputUpper = inputUpper.replace("","");		// 3) 문자열 내 공백 제거
			
			// 판정
			if(data.containsKey(input.toUpperCase())) {			// 이전에 검색한 적이 있다면
				data.put(inputUpper, data.get(inputUpper) + 1);	// 해당 검색어의 Integer를 이전값보다 1만큼 증가 (+1)
			}
			
			else {												// 이전에 검색한 적이 없다면
				data.put(inputUpper, 1);						// 해당 검색어의 Integer를 1로 설정 (처음 검색했으므로)
			}
			
			// 출력
			System.out.println(input + " 검색이 완료되었습니다. 검색 횟수 [" + data.get(inputUpper) + "]");	// 문구 출력
		}
		
		sc.close();
	}
}
