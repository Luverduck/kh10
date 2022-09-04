package com.kh.springhome.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.springhome.entity.GuestBookDto;

@Repository
public class GuestBookDaoImpl implements GuestBookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insert(GuestBookDto guestBookDto) {
		String sql = "insert into guest_book(no, name, memo) values(guest_book_seq.nextval, ?, ?)";
		Object[] param = new Object[] {guestBookDto.getName(), guestBookDto.getMemo()};
		jdbcTemplate.update(sql, param);
	}

}
