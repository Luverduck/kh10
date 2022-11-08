package com.kh.spring17.repository;

import java.util.List;

import com.kh.spring17.entity.ProductDto;
import com.kh.spring17.vo.ProductSearchVO;

public interface ProductDao {

	// 추상 메소드 - 복합 조회
	List<ProductDto> complexSearch(ProductSearchVO productSearchVO);
}
