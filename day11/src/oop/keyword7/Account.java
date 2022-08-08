package oop.keyword7;

public class Account {

	// 멤버 필드
	private String name;
	// 2. Account 클래스에서 직접 입력
	// private static double interestN = 1.2;
	private static double interestN;
	private double interestV;
	private long balance;
	
	// 3. static 전용 초기화 구문
	static {
		interestN = 1.2;
	}
	
	// getter & setter (static 제외)
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setInterestV(double interestV) {
		if(interestV < 0) {
			return;
		}
		this.interestV = interestV;
	}
	public double getInterestV() {
		return interestV;
	}
	public void setBalance(long balance) {
		if(balance < 0) {
			return;
		}
		this.balance = balance;
	}
	public long getBalance() {
		return balance;
	}
	
	// setter & getter (static에 대한)
	public static void setInterestN(double interestN) {
		Account.interestN = interestN;
	}
	public static double getInterestN() {
		return interestN;
	}
	
	// 생성자 (생성자에서 static을 초기화할 필요가 없다 (한번만 초기화하도록 따로 설정)
	public Account(String name, double interestV, long balance) {
		this.setName(name);
		this.setInterestV(interestV);
		this.setBalance(balance);
	}
	
	// 출력 메소드
	public void print() {
		System.out.println("이름 : " + this.name);
		System.out.println("기본이율 : " + Account.interestN);
		System.out.println("우대이율 : " + this.interestV);
		System.out.println("잔액 : " + this.balance);
		System.out.println();
	}
}
