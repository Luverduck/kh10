package com.kh.spring10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring10.entity.CustomerDto;
import com.kh.spring10.repository.CustomerDao;

@Controller
@RequestMapping("/customer")
public class ExerciseController {
	
	// DAO
	@Autowired
	private CustomerDao customerDao;

	// 1. 등록(/insert)
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@ModelAttribute CustomerDto customerDto) {
		customerDao.insert(customerDto);
		return "등록 완료";
	}

	// 2. 수정(/update)
	@RequestMapping("/update")
	@ResponseBody
	public String update(@ModelAttribute CustomerDto customerDto) {
		boolean result = customerDao.update(customerDto);
		if(result) {
			return "변경 완료";
		}
		else {
			return "없는 번호";
		}
	}

	// 3. 삭제(/delete)
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam int customerNum) {
		boolean result = customerDao.delete(customerNum);
		if(result) {
			return "삭제 완료";
		}
		else {
			return "없는 번호";
		}
	}

	// 4. 조회(/list)
	@RequestMapping("/list")
	@ResponseBody
	public String list(@RequestParam(required = false) String type, @RequestParam(required = false) String keyword) {
		boolean search = type != null && keyword != null;
		List<CustomerDto> list;
		if(search) {
			list = customerDao.selectList(type, keyword);
		}
		else {
			customerDao.selectList();
			list = customerDao.selectList();
		}
		return list.toString();
	}

	// 5. 상세 조회(/detail)
	@RequestMapping("/detail")
	@ResponseBody
	public String detail(@RequestParam int customerNum) {
		CustomerDto customerDto = customerDao.selectOne(customerNum);
		if(customerDto == null) {
			return "없는 번호";
		}
		else {
			return customerDto.toString();
		}
	}
}
