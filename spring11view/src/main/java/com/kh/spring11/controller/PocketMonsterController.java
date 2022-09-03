package com.kh.spring11.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring11.entity.PocketMonsterDto;

// pocket_monster 테이블에 대한 CRUD 처리를 위한 컨트롤러

@Controller
@RequestMapping("/pocket-monster")
public class PocketMonsterController {

	// JDBC를 위해서 이미 설정으로 만들어둔 JdbcTemplate를 가져온다
	// -> 만드는 것이 아니라 Spring에게 "주세요~"라고 해야 한다
	
	// 0. template 생성 부탁(등록)
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 1. 입력(insert)	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@RequestParam int no, @RequestParam String name, @RequestParam String type) {
		String sql = "insert into pocket_monster(no, name, type) values(?, ?, ?)";
		Object[] param = new Object[] {no, name, type};
		jdbcTemplate.update(sql, param);
		return "등록 완료!";
	}
	
	// http://localhost:8888/pocket-monster/insert?no=5&name=리자드&type=불꽃
	
	// 2. 수정(update) - 번호(no)를 이용해서 이름(name)과 유형(type) 변경
	@RequestMapping("/update")
	@ResponseBody
	public String update(@RequestParam int no, @RequestParam String name, @RequestParam String type) {
		String sql = "update pocket_monster set name = ?, type = ? where no = ?";
		Object[] param = new Object[] {name, type, no};
		int result = jdbcTemplate.update(sql, param);
		if(result > 0) {
			return "수정 완료!";
		}
		else {
			return "없는 번호";
		}
	}
	
	// http://localhost:8888/pocket-monster/update?no=5&name=꼬부기&type=물
	
	// 3. 삭제(delete) - 번호(no)를 이용해서 삭제
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam int no) {
		String sql = "delete pocket_monster where no = ?";
		Object[] param = new Object[] {no};
		int result = jdbcTemplate.update(sql, param);
		if(result > 0) {
			return "삭제 완료!";
		}
		else {
			return "없는 번호";
		}
	}
	
	// http://localhost:8888/pocket-monster/delete?no=5
	
	// 4. 조회(select) -> RowMapper<PocketMonsterDto>	-> 여기서 PocketMonsterDto를 개체(Entity)라고 한다
	@RequestMapping("/select")
	@ResponseBody
	public String select() {
		String sql = "select * from pocket_monster order by no asc";
		List<PocketMonsterDto> list = jdbcTemplate.query(sql, PocketMonsterDto.getMapper());
		StringBuffer buffer = new StringBuffer();
		for(PocketMonsterDto dto : list) {
			buffer.append(dto);
			buffer.append("<br>");
		}
		return buffer.toString();
	}
	
	// http://localhost:8888/pocket-monster/select
	
	// 5. 단일 조회 -> ResultSetExtractor<PocketMonsterDto>
	@RequestMapping("/detail")
	@ResponseBody
	public String detail(@RequestParam int no) {
		String sql = "select * from pocket_monster where no = ?";
		Object[] param = {no};
		PocketMonsterDto dto = jdbcTemplate.query(sql, PocketMonsterDto.getExtractor(), param);
		if(dto == null) {
			return "없는 번호";
		}
		else {
			return dto.toString();
		}
	}
	
	// http://localhost:8888/pocket-monster/detail?no=1
}
