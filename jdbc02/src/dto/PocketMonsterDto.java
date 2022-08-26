package dto;

public class PocketMonsterDto {

	// 필드
	private int no;
	private String name;
	private String type;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	// 생성자
	public PocketMonsterDto() {
		super();
	}
	
	// toString 오버라이딩
	@Override
	public String toString() {
		return "PocketMonsterDto [no=" + no + ", name=" + name + ", type=" + type + "]";
	}
}
