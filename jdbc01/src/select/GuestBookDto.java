package select;

public class GuestBookDto {

	// 필드
	int no;
	String name;
	String memo;
		
	// getter & setter
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	// toString 오버라이딩 - 객체의 정보 출력을 쉽게 하기 위해
	@Override
	public String toString() {
		return "GuestBookDto [no=" + no + ", name=" + name + ", memo=" + memo + "]";
	}
}
