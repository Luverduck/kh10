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

import com.kh.springhome.entity.PocketMonsterDto;

@Repository
public class PocketMonsterDaoImpl implements PocketMonsterDao {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 등록
	@Override
	public void insert(PocketMonsterDto pocketMonsterDto) {
		String sql = "insert into pocket_monster(no,name,type)" + "values(?,?,?)";
		Object[] param = { pocketMonsterDto.getNo(), pocketMonsterDto.getName(), pocketMonsterDto.getType() };
		jdbcTemplate.update(sql, param);
	}

	// RowMapper
	private RowMapper<PocketMonsterDto> mapper = new RowMapper<>() {
		@Override
		public PocketMonsterDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			PocketMonsterDto dto = new PocketMonsterDto();
			dto.setNo(rs.getInt("no"));
			dto.setName(rs.getString("name"));
			dto.setType(rs.getString("type"));
			return dto;
		}

	};

	// 조회
	@Override
	public List<PocketMonsterDto> selectList() {
		String sql = "select * from pocket_monster order by no asc";
		return jdbcTemplate.query(sql, mapper);
	}

	// ResultSetExtractor
	ResultSetExtractor<PocketMonsterDto> extractor = new ResultSetExtractor<PocketMonsterDto>() {
		@Override
		public PocketMonsterDto extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()) {
				PocketMonsterDto dto = new PocketMonsterDto();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setType(rs.getString("type"));
				return dto;
			}
			else {
				return null;	
			}
		}
	};
	
	// 단일 조회
	@Override
	public PocketMonsterDto selectOne(int no) {
		String sql = "select * from pocket_monster where no = ?";
		Object[] param = new Object[] {no};
		return jdbcTemplate.query(sql, extractor, param);
	}

	// 수정
	@Override
	public boolean update(PocketMonsterDto dto) {
		String sql = "update pocket_monster set name = ?, type = ? where no = ?";
		Object[] param = new Object[] {dto.getName(), dto.getType(), dto.getNo()};
		return jdbcTemplate.update(sql, param) > 0;
	}

	// 삭제
	@Override
	public boolean delete(int no) {
		String sql = "delete pocket_monster where no = ?";
		Object[] param = new Object[] {no};
		return jdbcTemplate.update(sql, param) > 0;
	}
}