package com.kh.spring09.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.spring09.entity.GuestBookDto;

@Repository
// DAO(Data Access Object)의 본문(구현체)
public class GuestBookDaoImpl implements GuestBookDao {

	// 형태 + 코드
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 등록 기능의 형태 + 코드를 작성
	@Override
	public void insert(GuestBookDto dto) {
		String sql = "insert into guest_book(no, name, memo) values(guest_book_seq.nextval, ?, ?)";
		Object[] param = new Object[] {dto.getName(), dto.getMemo()};
		
		// DB INSERT
		jdbcTemplate.update(sql, param);
	}

	// 수정
	@Override
	public boolean update(GuestBookDto dto) {
		String sql = "update guest_book set name = ?, memo = ? where no = ?";
		Object[] param = {dto.getName(), dto.getMemo(), dto.getNo()};
		int result = jdbcTemplate.update(sql, param);
		/*
		// result가 0보다 크면 true 반환해라! 아니면 false를 반환해라!
		if(result > 0) {
			return true;
		}
		else {
			return false;
		}
		*/
		// result가 0보다 큰지 파악해서 반환해라!
		return result > 0;
	}
	
	// 삭제
	@Override
	public boolean delete(int no) {
		String sql = "deleete guest_book where no = ?";
		Object[] param = {no};
		// jdbcTemplate.update(sql, param)의 결과가 0 이상(삭제 성공)이면 true를 리턴
		return jdbcTemplate.update(sql, param) > 0;
	}

	// - RowMapper와 ResultSetExtractor는 DAO에 만든다
	private RowMapper<GuestBookDto> mapper = new RowMapper<GuestBookDto>() {
		@Override
		public GuestBookDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			GuestBookDto dto = new GuestBookDto();
			dto.setNo(rs.getInt("no"));
			dto.setName(rs.getString("name"));
			dto.setMemo(rs.getString("memo"));
			return dto;
		}
	};
	
	// 조회 - 목록	
	@Override
	public List<GuestBookDto> selectList() {
		String sql = "select * from guest_book order by no asc";
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public List<GuestBookDto> selectList(String type, String keyword) {
		String sql = "select * from guest_book where instr(#1, ?) > 0";
		sql = sql.replace("#1", type);
		Object[] param = new Object[] {keyword};
		return jdbcTemplate.query(sql, mapper, param);
	}
	
	// - ResultSetExtractor 생성
	private ResultSetExtractor<GuestBookDto> extractor = new ResultSetExtractor<GuestBookDto>() {
		@Override
		public GuestBookDto extractData(ResultSet rs) throws SQLException, DataAccessException {
			
			return null;
		}
	};

	// 상세 조회
	@Override
	public GuestBookDto selectOne(int no) {
		String sql = "select * from guest_book where no = ?";
		Object[] param = {no};
		return jdbcTemplate.query(sql, extractor, param);
	}
}
