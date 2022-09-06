package com.kh.springhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springhome.entity.PocketMonsterDto;
import com.kh.springhome.repository.PocketMonsterDao;

@Controller
@RequestMapping("/pocketmon")
public class PocketMonsterController {

	// 등록 기능은 매핑이 2개가 필요(등록, 등록완료)한데 주소는 같을 수 없다
	// 주소를 맞추려면 방식이라도 달라야 하므로 구분해야 한다
	// RequestMapping에 조건을 주거나 다른 annotation쓰기
//	@RequestMapping(value = "/insert", method = RequestMethod.GET)
//	@RequestMapping(value = "/insert", method = RequestMethod.POST)

	@Autowired
	private PocketMonsterDao pocketMonsterDao;

	// 입력 페이지
	@GetMapping("/insert")
	public String insert() {
//		return "/WEB-INF/views/pocketmon/insert.jsp";
		return "pocketmon/insert";
	}

	// 입력을 받은 데이터
	@PostMapping("/insert")
	public String insert(@ModelAttribute PocketMonsterDto dto) {
		// DB insert
		pocketMonsterDao.insert(dto);

		// insert_success 매핑으로 redirect(강제이동) 처리하세요
		return "redirect:insert_success";
	}

	// 등록 완료 페이지로 연결
	@RequestMapping("/insert_success")
	public String insertSuccess() {
		// return "/WEB-INF/views/pocketmon/insertREsult.jsp";
		return "pocketmon/insertSuccess";
	}
	
	// 조회 페이지
	@GetMapping("/list")
	public String list(Model model) {
		List<PocketMonsterDto> list = pocketMonsterDao.selectList();
		model.addAttribute("list", list);
		return "pocketmon/list";
	}
}
