package oop.inherit5;

public class PPT extends File {	// PPT는 File을 상속받도록 만들어야 한다
	
	// PPT 고유 필드
	private long pageSize;

	// getter & setter
	public long getPageSize() {	
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if(pageSize < 0) {
			return;
		}
		this.pageSize = pageSize;
	}
	
	// PPT 고유 메소드
	public void information() {
		System.out.println("<파일 정보>");
		System.out.println("파일명 : " + super.fileName);
		System.out.println("파일크기 : " + super.fileSize + " bytes");
		System.out.println("페이지 수 : " + this.pageSize);
	}
	
	// 생성자 - 페이지 사이즈를 지정않는 경우
	public PPT(String fileName, long fileSize) {
		this(fileName, fileSize, 1);
	}
		
	// 생성자 - 페이즈 사이즈를 지정하는 경우
	public PPT(String fileName, long fileSize, int pageSize) {
		super(fileName);
		this.setFileSize(fileSize);
		this.setPageSize(pageSize);
	}
}
