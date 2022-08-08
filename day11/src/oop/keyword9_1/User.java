package oop.keyword9_1;

public class User {

	// 변수 필드
	private String id;			// final 없이 final 효과 만들기
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
	
	public void setId(String id) {
		this.id = id;
	}
	
	// 생성자
	public User(String id, String password, String nickname) {
		this.setId(id);				// 생성시 1회 한정 아이디 초기화
		this.password = password;
		this.nickname = nickname;
	}

	// 출력 메소드
	public void print() {
		System.out.println("ID : " + this.id);
		System.out.println("닉네임 : " + this.nickname);
	}
}
