package com.kh.springhome.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.springhome.entity.PocketMonsterDto;
import com.kh.springhome.repository.PocketMonsterDao;
import com.kh.springhome.vo.PocketMonsterCountVO;

@Controller
@RequestMapping("/pocketmon")
public class PocketMonsterController {

	@Autowired
	private PocketMonsterDao pocketMonsterDao;

	// 1. 등록 (insert)
	// 1-1. 등록 Mapping
	@GetMapping("/insert")
	public String insert() {
		// 등록 페이지 (insert.jsp)로 연결
//		return "/WEB-INF/views/pocketmon/insert.jsp";
		return "pocketmon/insert";
	}

	// 1-2. 등록 Mapping에 DTO 전달 및 DB 처리
	// DB에서 등록(insert) 처리 후 등록 완료 Mapping으로 이동
	@PostMapping("/insert")
	public String insert(@ModelAttribute PocketMonsterDto dto) {
		// 1) DB에서 등록(insert) 실행
		pocketMonsterDao.insert(dto);
		// 2) 등록 처리 후 등록 완료(insert_success) Mapping으로 강제이동(redirect) (새로고침 시 데이터 중복 입력하는 것을 방지)
		return "redirect:insert_success";
	}

	// 1-3. 등록 완료 Mapping
	@RequestMapping("/insert_success")
	public String insertSuccess() {
		// 등록 완료 페이지(insertResult.jsp)로 연결
//		return "/WEB-INF/views/pocketmon/insertResult";
		return "pocketmon/insertResult";
	}
	
	// 2. 조회 (select)
	// 조회 Mapping
	@GetMapping("/list")
	public String list(Model model) {
		// 1) DB에서 조회(select) 실행 후 결과를 List에 저장
		List<PocketMonsterDto> list = pocketMonsterDao.selectList();
		// 2) Model의 변수명과 값 설정 - List에 저장된 값으로 설정
		model.addAttribute("list", list);
		// 3) Model을 View에 전달 (list.jsp에서 전달받은 Model을 표시할 형식을 정의) 
		return "pocketmon/list";
	}
	
	// 2-1. 단일 조회 (detail)
	// 단일 조회 Mapping
	@GetMapping("/detail")
	public String detail(Model model, @RequestParam int no) {
		// 1) Model의 변수명과 값 설정 - 단일 조회 selectOne()의 결과값으로 설정
		model.addAttribute("dto", pocketMonsterDao.selectOne(no));
		// 2) Model을 View에 전달 (detail.jsp에서 전달 받은 Model을 표시할 형식을 정의)
		return "pocketmon/detail";
	}
	
	// 3. 수정 (update)
	// 3-1. 수정 Mapping
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam int no) {
		// 1) DB에서 단일 조회 selectOne() 실행 후 결과를 PocketMonsterDto 타입의 인스턴스 dto에 저장
		PocketMonsterDto dto = pocketMonsterDao.selectOne(no);
		// 2) Model의 변수명과 값 설정 - dto에 저장된 값으로 설정
		model.addAttribute("dto", dto);
		// 2) PostMapping으로 이동
//		return "/WEB-INF/views/pocketmon/edit.jsp";
		return "pocketmon/edit";
	}
	
	// 3-2. 수정 Mapping에 DTO 전달 및 DB 처리
	// DB에서 수정(update) 처리 후 처리 결과에 따라 서로 다른 Mapping으로 이동 
	@PostMapping("/edit")
	public String edit(@ModelAttribute PocketMonsterDto dto) {
		// 1) DB에서 수정(update) 실행 결과(boolean, 실행 결과가 0보다 큰지)를 반환
		boolean result = pocketMonsterDao.update(dto);
		// 2) 수정(update) 처리 후 결과에 따라 서로 다른 Mapping으로 이동
		if(result) {	// true라면 해당 번호(no) 포켓몬의 단일 조회 Mapping으로 이동
			return "redirect:detail?no=" + dto.getNo();	// 정적 바인딩
		}
		else {	// false라면 수정 실패(edit_fail) Mapping으로 이동
			return "redirect:edit_fail";
		}
	}
	
	// 3-3. 수정 실패 Mapping
	@GetMapping("/edit_fail")
	public String editFail() {
		// 수정 실패 페이지(editFail.jsp)로 연결
//		return "/WEB-INF/views/pocketmon/editFail"
		return "pocketmon/editFail";
	}
	
	// 4. 삭제 (delete)
	// 삭제 Mapping
	@GetMapping("/delete")
	public String delete(@RequestParam int no) {
		// 1) DB에서 삭제(delete) 실행 결과(boolean, 실행 결과가 0보다 큰지)를 반환
		boolean result = pocketMonsterDao.delete(no);
		// 2) 삭제(delete) 처리 후 결과에 따라 서로 다른 Mapping으로 이동
		if(result) {	// true라면 조회(list) Mapping으로 이동
			return "redirect:list";
		}
		else {	// false라면 수정 실패 페이지(editFail.jsp)로 이동
//			return "/WEB-INF/views/pocketmon/editFail.jsp";
			return "pocketmon/editFail";
		}
	}
}
