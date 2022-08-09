package oop.inherit5;

// 상위 클래스 - 파일의 공통 특징
public class File {

	// 공용 필드
	protected String fileName;
	protected long fileSize;		// 요즘 파일 크기가 크므로 long으로 쓴다
	
	// getter && setter
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		if(fileSize < 0) {
			return;
		}
		this.fileSize = fileSize;
	}
	
	// 생성자 - 파일명은 무조건 있어야 한다
	public File(String fileName){
		this.setFileName(fileName);	
	}
	
	// 공용 메소드
	public void execute() {
		System.out.println(this.fileName + " 실행");
	}
}
