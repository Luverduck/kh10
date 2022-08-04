package array2d;

//다음 규칙에 따라 지뢰찾기를 만드세요
//- 9x9 크기의 정수 배열을 준비합니다
//- 지뢰는 9로 표시하며, 배열 내에 무작위로 20개가 배치됩니다
//- 배치된 이후 전체 지도를 출력하세요

//아래의 내용은 추가 문제이며 따로 풀이하지 않습니다
//- 지뢰를 제외한 나머지 칸은 자신을 제외한 반경 8칸의 지뢰 개수를 세어 숫자를 기록해야 합니다
//- 가장자리에 있는 칸의 경우 배열을 벗어나는 부분을 제외하고 계산해야 합니다
//- 반경에 지뢰가 하나도 없다면 0이 설정됩니다

import java.util.Random;

public class Test08_me {
	
	public static void main(String[] args) {
		
		int[][] array = new int[9][9];		//9x9 배열	//총 칸 수 81개
		
		Random r = new Random();
		
		for(int k = 0 ; k < 20 ; k++) {
			int x = r.nextInt(9);					//9x9 배열의 랜덤 위치 표시
			int y = r.nextInt(9);
			
			if(array[x][y] == 0) {					//위치 중복 제거 코드
				array[x][y] = 9;					//1에서 9까지 숫자를 좌표에 입력
			}
			else {
				k--;
			}
		}
		
		//오른쪽을 +1 하기
		for(int j = 0 ; j < array.length ; j ++) {
			for(int i = 0 ; i < array.length ; i ++) {
				if(i < array.length - 1) {
					if(array[j][i] == 9) {
						if(array[j][i+1] == 9) {
							array[j][i+1] += 0;
						}
						else {
							array[j][i+1] += 1;
						}
					}
					else {
						array[j][i+1] += 0;
					}
				}
				else if(i == array.length - 1) {
					break;
				}
			}
		}
		
		//왼쪽을 +1
		for(int j = 0 ; j < array.length ; j ++) {
			for(int i = array.length - 1 ; i >= 0 ; i --) {
				if(i > 0) {
					if(array[j][i] == 9) {
						if(array[j][i-1] == 9) {
							array[j][i-1] += 0;
						}
						else {
							array[j][i-1] += 1;
						}
					}
					else {
						array[j][i-1] += 0;
					}
				}
				else if(i == 0) {
					break;
				}
			}
		}
		
		
		
		//아래를 +1 하기
		for(int i = 0 ; i < array.length ; i ++) {
			for(int j = 0 ; j < array.length ; j ++) {
				if(j < array.length - 1) {
					if(array[j][i] == 9) {
						if(array[j+1][i] == 9) {
							array[j+1][i] += 0;
						}
						else {
							array[j+1][i] += 1;
						}
					}
					else {
						array[j+1][i] += 0;
					}
				}
				else if(j == array.length - 1) {
					break;
				}
			}
		}
		
		//위쪽을 +1
		for(int i = 0 ; i < array.length ; i ++) {
			for(int j = array.length - 1 ; j >= 0 ; j --) {
				if(j > 0) {
					if(array[j][i] == 9) {
						if(array[j-1][i] == 9) {
							array[j-1][i] += 0;
						}
						else {
							array[j-1][i] += 1;
						}
					}
					else {
						array[j-1][i] += 0;
					}
				}
				else if(j == 0) {
					break;
				}
			}
		}
		
		//오른쪽 대각선 아래를 +1
		for(int j = 0 ; j < array.length ; j ++) {
			for(int i = 0 ; i < array.length ; i ++) {
				if(i == array.length - 1 || j == array.length - 1) {
					break;
				}
				else {
					if(array[j][i] == 9) {
						if(array[j+1][i+1] == 9) {
							array[j+1][i+1] += 0;
						}
						else {
							array[j+1][i+1] += 1;
						}
					}
					else {
						array[j+1][i+1] += 0;
					}
				}
			}
		}
		
		//오른쪽 대각선 위를 +1
		for(int i = 0 ; i < array.length ; i ++) {
			if(i == array.length - 1) {
				break;
			}
			else {
				for(int j = array.length - 1 ; j >= 0 ; j --) {
					if(j == 0) {
						break;
					}
					else {
						if(array[j][i] == 9) {
							if(array[j-1][i+1] == 9) {
								array[j-1][i+1] += 0;
							}
							else {
								array[j-1][i+1] += 1;
							}
						}
						else {
							array[j-1][i+1] += 0;
						}
					}
				}
			}
		}
		
		//왼쪽 대각선 아래를 +1
		for(int j = 0 ; j < array.length ; j ++) {
			if(j == array.length - 1) {
				break;
			}
			else {
				for(int i = array.length - 1 ; i >= 0 ; i --) {
					if(i == 0) {
						break;
					}
					else {
						if(array[j][i] == 9) {
							if(array[j+1][i-1] == 9) {
								array[j+1][i-1] += 0;
							}
							else {
								array[j+1][i-1] += 1;
							}
						}
						else {
						array[j+1][i-1] += 0;
						}
					}
				}
			}
		}
		
		//왼쪽 대각선 위를 +1
		for(int j = array.length - 1 ; j >= 0 ; j --) {
			if(j == 0) {
				break;
			}
			else {
				for(int i = array.length - 1 ; i >= 0 ; i --) {
					if(i == 0) {
						break;
					}
					else {
						if(array[j][i] == 9) {
							if(array[j-1][i-1] == 9) {
								array[j-1][i-1] += 0;
							}
							else {
								array[j-1][i-1] += 1;
							}
						}
						else {
							array[j-1][i-1] += 0;
						}
					}
				}
			}
		}
		
		
		//출력
		for(int j = 0 ; j < array.length ; j ++) {
			for(int i = 0 ; i < array[j].length ; i++) {
				System.out.print(array[j][i]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
