package update;

import org.springframework.jdbc.core.JdbcTemplate;

import util.JdbcUtil;

public class Test01 {

	public static void main(String[] args) {
		
		// 수정(update)
		// 대상이 업데이트되지 않아도 완료가 나옴 (실행은 했기 때문에)
		// - 조건에 따라 실행 결과가 달라지므로 이를 받아서 성공/실패 판정
		// - update 된 수(int)를 반환 (0이면 업데이트 실패)
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		String sql = "update fifa set score = ? where nation = ?";
		
		Object[] param = new Object[] {1755.35, "아르헨티나"};
		
		int result = template.update(sql, param);
		System.out.println("결과 : " + result);
		
		if(result > 0) {
			System.out.println("변경 성공");
		}
		else {
			System.out.println("해당하는 나라가 없습니다");
		}
	}
}
