package com.kh.spring11.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class GuestBookDto {

	// field
	private int no;
	private String name;
	private String memo;
	
	// 생성자
	public GuestBookDto() {
		super();
	}
	
	// getter & setter
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	// toString 오버라이딩
	@Override
	public String toString() {
		return "GuestBookDto [no=" + no + ", name=" + name + ", memo=" + memo + "]";
	}
	
	// RowMapper
	private static RowMapper<GuestBookDto> mapper = new RowMapper<GuestBookDto>() {
		@Override
		public GuestBookDto mapRow(ResultSet rs, int idx) throws SQLException {
			GuestBookDto guestBookDto = new GuestBookDto();
			guestBookDto.setNo(rs.getInt("no"));
			guestBookDto.setName(rs.getString("name"));
			guestBookDto.setMemo(rs.getString("memo"));
			return guestBookDto;
		}	
	};
	
	// RowMapper에 대한 getter
	public static RowMapper<GuestBookDto> getMapper() {
		return mapper;
	}
	
	// ResultSetExtractor
	private static ResultSetExtractor<GuestBookDto> extractor = new ResultSetExtractor<GuestBookDto>() {
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
	
	// ResultSetExtractor에 대한 getter
	public static ResultSetExtractor<GuestBookDto> getExtractor() {
		return extractor;
	}
}
