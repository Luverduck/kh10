package com.kh.spring17.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring17.entity.ProductDto;
import com.kh.spring17.vo.ProductSearchVO;

@Repository
public class ProductDaoImpl implements ProductDao {

	// 의존성 주입
	@Autowired
	private SqlSession sqlSession;

	// 추상 메소드 오버라이딩 - 복합 조회
	@Override
	public List<ProductDto> complexSearch(ProductSearchVO productSearchVO) {
		
		return sqlSession.selectList("product.complex5", productSearchVO);
	}
}
