package com.kh.springhome.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.springhome.entity.GuestBookDto;

@Repository
public class GuestBookDaoImpl implements GuestBookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 등록(insert)
	@Override
	public void insert(GuestBookDto guestBookDto) {
		String sql = "insert into guest_book(no, name, memo) values(guest_book_seq.nextval, ?, ?)";
		Object[] param = new Object[] {guestBookDto.getName(), guestBookDto.getMemo()};
		jdbcTemplate.update(sql, param);
	}
	
	// RowMapper
	RowMapper<GuestBookDto> mapper = new RowMapper<>() {
		@Override
		public GuestBookDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			GuestBookDto guestBookDto = new GuestBookDto();
			guestBookDto.setNo(rs.getInt("no"));
			guestBookDto.setName(rs.getString("name"));
			guestBookDto.setMemo(rs.getString("memo"));
			return guestBookDto;
		}
	};

	// 조회(select)
	@Override
	public List<GuestBookDto> selectList() {
		String sql = "select * from guest_book order by no asc";
		return jdbcTemplate.query(sql, mapper);
	}

	// 조회(select) - 키워드 조회
	@Override
	public List<GuestBookDto> selectList(String type, String keyword) {
		String sql = "select * from guest_book where instr(#1, ?) > 0 order by no asc";
		sql = sql.replace("#1", type);
		Object[] param = new Object[] {keyword};
		return jdbcTemplate.query(sql, mapper, param);
	}
	
	// ResultSetExtractor
	ResultSetExtractor<GuestBookDto> extractor = new ResultSetExtractor<>() {
		@Override
		public GuestBookDto extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()) {
				GuestBookDto guestBookDto = new GuestBookDto();
				guestBookDto.setNo(rs.getInt("no"));
				guestBookDto.setName(rs.getString("name"));
				guestBookDto.setMemo(rs.getString("memo"));
				return guestBookDto;
			}
			else {
				return null;
			}
		}
	};
	
	// 상세 조회(detail)
	@Override
	public GuestBookDto detail(int no) {
		String sql = "select * from guest_book where no = ?";	
		Object[] param = new Object[] {no};
		return jdbcTemplate.query(sql, extractor, param);
	}

	// 수정(update)
	@Override
	public boolean update(GuestBookDto guestBookDto) {
		String sql = "update guest_book set name = ?, memo = ? where no = ?";
		Object[] param = new Object[] {guestBookDto.getName(), guestBookDto.getMemo(), guestBookDto.getNo()};
		return jdbcTemplate.update(sql, param) > 0;
	}

}
