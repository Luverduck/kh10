package com.kh.springhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	// 상세 조회 페이지
	@GetMapping("/detail")
	public String detail(Model model, @RequestParam int no) {
//		model.addAttribute("dto", 상세조회 결과);
		model.addAttribute("dto", pocketMonsterDao.selectOne(no));
//		전달(return)할 경로 설정
//		return "/WEB-INF/views/pocketmon/detail.jsp";		
		return "pocketmon/detail";
	}
	
	// 수정 기능
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam int no) {
		PocketMonsterDto dto = pocketMonsterDao.selectOne(no);
		model.addAttribute("dto", dto);
//		return "수정 입력 페이지";
//		return "/WEB-INF/views/pocketmon/edit.jsp";
		return "pocketmon/edit";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute PocketMonsterDto dto) {
		// DB 수정 처리
		boolean result = pocketMonsterDao.update(dto);
		// 성공했다면 상세조회(detail) 페이지로 이동
		if(result) {
			return "redirect:detail?no=" + dto.getNo();	// 정적 바인딩
		}
		// 실패했다면 수정(edit) 페이지로 이동
		else {
			return "redirect:edit_fail";
		}
	}
	
	@GetMapping("/edit_fail")
	public String editFail() {
//		return "수정 실패 페이지";
//		return "/WEB-INF/views/pocketmon/editFail"
		return "pocketmon/editFail";
	}
	
	// 삭제
	@GetMapping("/delete")
	public String delete(@RequestParam int no) {
		boolean result = pocketMonsterDao.delete(no);
		if(result) {
			return "redirect:list";
		}
		else {
//			return "/WEB-INF/views/pocketmon/editFail.jsp";
			return "pocketmon/editFail";
		}
	}
	
}
