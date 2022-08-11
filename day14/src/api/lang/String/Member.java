package api.lang.String;

import java.util.Objects;

public class Member {
	
	// 멤버 필드
	private String id;
	private String password;
	
	// getter & setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// 생성자
	public Member(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	
	// hashcode 및 equals 재정의
	@Override
	public int hashCode() {
		return Objects.hash(id, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(id, other.id) && Objects.equals(password, other.password);
	}
}
