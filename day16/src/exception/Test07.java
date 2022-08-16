package exception;

public class Test07 {

	public static void main(String[] args) {
		
		try {
			Student s = new Student("피카츄", 50, 60, 70);
			s.setName("ggg");						// setName을 부를 때 throws Exception이 있다면 try ~ catch에서만 호출할 수 있다
			System.out.println(s.toString());	
		}
		
		catch(Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
