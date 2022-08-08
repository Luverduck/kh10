package oop.keyword9;

public class User {

	// 변수 필드
	private final String id;
	private String password;
	private String nickname;
	
	// setter & getter
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getId() {
		return id;
	}
	
	// 생성자
	public User(String id, String password, String nickname) {
		this.id = id;				// 생성시 1회 한정 아이디 초기화
		this.password = password;
		this.nickname = nickname;
	}

	// 출력 메소드
	public void print() {
		System.out.println("ID : " + this.id);
		System.out.println("닉네임 : " + this.nickname);
	}
}
