package oop.basic2;

public class Test01 {

	public static void main(String[] args) {
		
		//3개의 나라 정보 (객체 or 인스턴스) 생성
		
		Country one = new Country();		//객체 생성
		one.rank = 1;				//데이터 입력
		one.nation = "브라질";
		one.score = 1828.45;
		
		Country two = new Country();
		two.rank = 2;
		two.nation = "벨기에";
		two.score = 1823.42;
		
		
		Country three = new Country();
		three.rank = 3;
		three.nation = "프랑스";
		three.score = 1786.15;
		
		
		//출력
		System.out.println("FIFA 세계 축구 랭킹");
		System.out.print(one.rank + "\t" + one.nation + "\t\t" + one.score);
		System.out.println();
		System.out.print(two.rank + "\t" + two.nation + "\t\t" + two.score);
		System.out.println();
		System.out.print(three.rank + "\t" + three.nation + "\t\t" + three.score);
		
	}
}
