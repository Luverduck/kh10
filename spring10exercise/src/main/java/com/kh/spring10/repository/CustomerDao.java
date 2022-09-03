package com.kh.spring10.repository;

import java.util.List;

import com.kh.spring10.entity.CustomerDto;

public interface CustomerDao {

	// 1. 등록(/insert)
	void insert(CustomerDto customerDto);
	
	// 2. 수정(/update)
	boolean update(CustomerDto customerDto);
	
	// 3. 삭제(/delete)
	boolean delete(int customerNum);
	
	// 4. 조회(/list)
	List<CustomerDto> selectList();
	List<CustomerDto> selectList(String type, String keyword);
	
	// 5. 상세조회(/detail)
	CustomerDto selectOne(int customerNum);
}
