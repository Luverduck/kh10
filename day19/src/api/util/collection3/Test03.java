package api.util.collection3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test03 {
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
		Map<String, Integer> history = new TreeMap<>();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			// 입력
			System.out.print("검색어 : ");
			String keyword = sc.nextLine();
			
			// "종료" 입력시 구문 탈출
			if (keyword.equals("종료")) {
				break;
			}
			
			// 대문자, 소문자 구별을 없애기 - 문자열 전체를 하나로 통일하기
			//keyword = keyword.toLowerCase();		1) 소문자 변환
			//keyword = keyword.tirm();				2) 좌우 불필요한 여백 제거
			//keyword = keyword.replace("","");		3) 문자열 내 공백 제거
			
			
			//int count = 1 or history.get(keyword);	// 해당 String의 Integer를 대입
			int count;
			if(history.containsKey(keyword)) {	// 검색한 적이 있으면
				count = history.get(keyword) + 1;
			}
			
			else {
				count = 1;
			}
			
			history.put(keyword, count);
			
			System.out.println("[" + keyword + "] 검색이 완료되었습니다. 현재 검색 횟수 [" + history.get(keyword) + "]");
		}
		
		sc.close();
	}
}
