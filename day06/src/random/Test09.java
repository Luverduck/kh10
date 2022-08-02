package random;

//풀이는 안하고 코드만 올리는 과제
//아이템 강화 시뮬레이션
//강화 확률은 아이템과 같다
//- 성공 : 25% 확률로 아이템의 레벨이 +1 됩니다
//- 실패 : 25% 확률로 아이템의 레벨이 -1 됩니다
//- 현상 유지 : 50% 확률로 아이템의 레벨이 변하지 않습니다
//- 단, 아이템의 레벨은 0보다 작거나 15보다 커지는 일은 없습니다

import java.util.Random;

public class Test09 {
	
	public static void main(String[] args) {
		
		Random r = new Random();
		
		int count = 0;
		int itemLV = 0;
		
		while(true) {
			
			int range = r.nextInt(100) + 1;		
			//매번 다른 숫자를 뽑아서 그 숫자가 
			//25 이하의 숫자이면 성공 (itemLV +1)
			//25 이상 50 이하의 숫자이면 실패 (itemLV -1)
			//50 이상 100이하의 숫자이면 현상 유지 (itemLV += 0;)
			
			count++;
			
			if(range <= 25) {
				itemLV ++;
				if(itemLV >= 15) {	//itemLV가 15 이상이 되면 반복문 탈출
					break;
				}
			}
			else if(range <= 50) {
				itemLV --;
				if(itemLV <= 0) {
					itemLV = 0;		//itemLV가 0 이하로 떨어지면 0으로 한다
				}
			}
			else {
				itemLV += 0;
			}
			
		}
		
		System.out.println("총 시도 횟수 : " + count);
		
	}

}
