package com.kh.spring17;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring17.entity.ProductDto;

@SpringBootTest
public class ProductSearchTest {

	@Autowired
	private SqlSession sqlSession;
	
//	@Test
	public void test() {
		// 목록
		//List<ProductDto> list = sqlSession.selectList("product.complex1");
		
		// 검색
//		Map<String, Object> param = new HashMap<>();
//		param.put("type", "name");
//		param.put("keyword", "처음");
//		List<ProductDto> list = sqlSession.selectList("product.complex1", param);
		
		// 복합 검색
		Map<String, Object> param = new HashMap<>();
//		param.put("no", 1); // 있을 수도 있고 없을 수도 있다
//		param.put("name", "스크류"); // 있을 수도 있고 없을 수도 있다
//		param.put("minPrice", 500);
//		param.put("maxPrice", 3000);
//		param.put("beginMade", "2020-01-01");
//		param.put("endMade", "2020-06-30");
//		param.put("type", List.of("과자"));
//		param.put("type", List.of("과자", "사탕"));
//		param.put("type", List.of("과자", "사탕", "아이스크림"));
		param.put("type", List.of("과자", "사탕", "아이스크림", "주류"));
		List<ProductDto> list = sqlSession.selectList("product.complex4", param);
		
		for(ProductDto dto : list) {
			System.out.println(dto);
		}
	}
	
	@Test
	public void test2() {
		Map<String, Object> param = new HashMap<>();
		param.put("sort", List.of("price desc", "no asc"));
 		List<ProductDto> list = sqlSession.selectList("product.complex6", param);
 		for(ProductDto dto : list) {
			System.out.println(dto);
		}
	}
}
