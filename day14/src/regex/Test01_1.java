package regex;

public class Test01_1 {

	public static void main(String[] args) {
		
		// 유니코드표 안보고 한글 번호 맞추기
		System.out.println((int)'가');
		System.out.println((int)'힣');
		System.out.println((int)'ㅋ');
		System.out.println((int)'ㄱ');
		System.out.println((int)'ㄲ');
		System.out.println((int)'ㄴ');
		System.out.println((int)'ㅡ');
		
		// 정규식 범위를 설정할 때 자음, 모음, 글자 범위를 따로 설정해야 한다
		// 자음 : ㄱ - ㅎ
		// 모음 : ㅏ - ㅣ
		// 글자 : 가 - 힣
	}
}
