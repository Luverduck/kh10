package select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dto.PocketMonsterDto;
import util.JdbcUtil;

public class Test08 {

	public static void main(String[] args) {
		
		// 문자열 유사 검색
		
		// 1. template 불러오기
		JdbcTemplate template = JdbcUtil.getTemplate();
		
		// 2. SQL문 작성 - like 사용
		//String sql = "select * from pocket_monster where name like '%?%'";
		String sql = "select * from pocket_monster where name like '%'||?||'%'"; 
		// Oracle에서 ||로 문자열 연결
		
		// 배열 생성
		Object[] param = new Object[] {"이상해"};
		
		// 3. RowMapper 클래스 작성
		RowMapper<PocketMonsterDto> mapper = (rs, idx) -> {
			PocketMonsterDto dto = new PocketMonsterDto();
			dto.setNo(rs.getInt("no"));
			dto.setName(rs.getString("name"));
			dto.setType(rs.getString("type"));
			return dto;
		};
		
		List<PocketMonsterDto> list = template.query(sql, mapper, param);
		System.out.println("검색 결과 : " + list.size() + "개");
		for(PocketMonsterDto dto : list) {
			System.out.println(dto);
		}
	}
}
