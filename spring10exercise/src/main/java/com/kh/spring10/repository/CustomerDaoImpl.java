package com.kh.spring10.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.kh.spring10.entity.CustomerDto;

public class CustomerDaoImpl implements CustomerDao {
	
	// template
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 1. 등록(/insert)
	@Override
	public void insert(CustomerDto customerDto) {
		// 1) SQL문 작성
		String sql = "insert into customer(customer_num, customer_id, customer_tel, customer_registration, customer_purchase, customer_point, customer_lv) values(customer_seq.nextval, ?, ?, to_date(?, 'yyyy-mm-dd'), to_date(?, 'yyyy-mm-dd'), ?, ?)";
		// 2) 변수 배열 생성
		Object[] param = new Object[] {customerDto.getCustomerId(), customerDto.getCustomerTel(), customerDto.getCustomerRegistration(), customerDto.getCustomerPurchase(), customerDto.getCustomerPoint(), customerDto.getCustomerLv()};
		// 3) 실행
		jdbcTemplate.update(sql, param);
	}

	// 2. 수정(/update)
	@Override
	public boolean update(CustomerDto customerDto) {
		// 1) SQL문 작성
		String sql = "update customer set customer_id = ?, customer_tel = ?, customer_point = ?, customer_lv = ? where customer_num = ?";
		// 2) 변수 배열 생성
		Object[] param = new Object[] {customerDto.getCustomerId(), customerDto.getCustomerTel(), customerDto.getCustomerPoint(), customerDto.getCustomerLv(), customerDto.getCustomerNum()};
		// 3) 실행
		int result = jdbcTemplate.update(sql, param);
		// 4) 실행 결과(boolean) 반환
		return result > 0;
	}
	
	// 3. 삭제(/delete)
	@Override
	public boolean delete(int customerNum) {
		// 1) SQL문 작성
		String sql = "deleete customer where customer_num = ?";
		// 2) 변수 배열 생성
		Object[] param = new Object[] {customerNum};
		int result = jdbcTemplate.update(sql, param);
		return result > 0;
	}

	// RowMapper 생성
	private RowMapper<CustomerDto> mapper = new RowMapper<CustomerDto>() {
		@Override
		public CustomerDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			CustomerDto customerDto = new CustomerDto();
			customerDto.setCustomerNum(rs.getInt("customer_num"));
			customerDto.setCustomerId(rs.getString("customer_Id"));
			customerDto.setCustomerTel(rs.getString("customer_tel"));
			customerDto.setCustomerRegistration(rs.getDate("customer_registration"));
			customerDto.setCustomerPurchase(rs.getDate(""));
			customerDto.setCustomerPoint(rs.getInt("customer_point"));
			customerDto.setCustomerLv(rs.getString("customer_lv"));
			return customerDto;
		}
	};
	
	// 4. 조회(/list)
	@Override
	public List<CustomerDto> selectList() {
		// 1) SQL문 작성
		String sql = "select * from customer order by customer_num asc";
		// 2) 변수 배열 생성 - 변수가 없으므로 생략
		// 3) 실행
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public List<CustomerDto> selectList(String type, String keyword) {
		// 1) SQL문 작성
		String sql = "select * from customer where instr(#1, ?) > 0 order by #1 asc";
		sql = sql.replace("#1", type);
		// 2) 변수 배열 생성
		Object[] param = new Object[] {keyword};
		// 3) 실행
		return jdbcTemplate.query(sql, mapper, param);
	}
	
	// ResultSetExtractor 생성
	private ResultSetExtractor<CustomerDto> extractor = new ResultSetExtractor<CustomerDto>() {
		@Override
		public CustomerDto extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()) {
				CustomerDto customerDto = new CustomerDto();
				customerDto.setCustomerNum(rs.getInt("customer_num"));
				customerDto.setCustomerId(rs.getString("customer_Id"));
				customerDto.setCustomerTel(rs.getString("customer_tel"));
				customerDto.setCustomerRegistration(rs.getDate("customer_registration"));
				customerDto.setCustomerPurchase(rs.getDate(""));
				customerDto.setCustomerPoint(rs.getInt("customer_point"));
				customerDto.setCustomerLv(rs.getString("customer_lv"));
				return customerDto;
			}
			else {
				return null;	
			}
		}
	};
	
	// 5. 상세조회(/detail)
	@Override
	public CustomerDto selectOne(int customerNum) {
		// 1) SQL문 작성
		String sql = "select * from customer where customer_num = ?";
		// 2) 변수 배열 생성
		Object[] param = new Object[] {customerNum};
		// 3) 실행
		return jdbcTemplate.query(sql, extractor, param);
	}
}
