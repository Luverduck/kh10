package regex;

public class Test05 {

	public static void main(String[] args) {
		
		// 반드시 1개 이상 포함되는 경우에 대한 처리
		String password = "hello1234!@#$";
		
		int upperCount = 0, lowerCount = 0, numberCount = 0, specialCount = 0;
		
		for(int i = 0 ; i < password.length() ; i ++) {
			char ch = password.charAt(i);
			if(ch >= 'A' && ch <= 'Z') {
				upperCount ++;
			}
			else if(ch >= 'a' && ch < 'z') {
				lowerCount ++;
			}
			else if(ch >= '0' && ch <= '9') {
				numberCount ++;
			}
			else if(ch == '!' || ch == '@' || ch == '#' || ch == '$') {
				specialCount ++;
			}
		}
		
		boolean check = upperCount > 0;
		check &= lowerCount > 0;
		check &= numberCount > 0;
		check &= specialCount > 0;
		check &= password.length() >= 8 && password.length() <= 16;
		
		System.out.println("결과 : " + check);
		
		
		// 긍정 탐색 : ^(?=.*[A-Z])[A-Za-z0-9!@#$]{8,16}$	뒤에 나오는 문자 중 반드시 A-Z중 하나는 나오도록 한다
		// 부정 탐색 : ^(!=.*[A-Z])[A-Za-z0-9!@#$]{8,16}$	뒤에 나오는 문자 중 반드시 A-Z중 하나도 나오지 않도록 한다
		
		// ^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$])[A-Za-z0-9!@#$]{8,16}$
		// 뒤에 나오는 문자에 [A-Z] 중 하나, [a-z] 중 하나, [0-9] 중 하나, !@#$ 중 하나가 반드시 나와야 한다
		
	}
}
