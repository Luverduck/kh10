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

import com.kh.springhome.entity.AttachmentDto;

@Repository
public class AttachmentDaoImpl implements AttachmentDao {

	// 의존성 주입
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// RowMapper
	private RowMapper<AttachmentDto> mapper = new RowMapper<>() {
		@Override
		public AttachmentDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return AttachmentDto.builder()
										.attachmentNo(rs.getInt("attachment_no"))
										.attachmentName(rs.getString("attachment_name"))
										.attachmentType(rs.getString("attachment_type"))
										.attachmentSize(rs.getLong("attachment_size"))
										.attachmentTime(rs.getDate("attachment_time"))
									.build();
		}
	};
	
	// ResultSetExtractor
	private ResultSetExtractor<AttachmentDto> extractor = new ResultSetExtractor<>() {
		@Override
		public AttachmentDto extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()) {
				return AttachmentDto.builder()
						.attachmentNo(rs.getInt("attachment_no"))
						.attachmentName(rs.getString("attachment_name"))
						.attachmentType(rs.getString("attachment_type"))
						.attachmentSize(rs.getLong("attachment_size"))
						.attachmentTime(rs.getDate("attachment_time"))
					.build();
			}
			else {
				return null;
			}
		}
	};

	@Override
	public int sequence() {
		String sql = "select attachment_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}	
	
	@Override
	public void insert(AttachmentDto attachmentDto) {
		String sql = "insert into attachment("
									+ "attachment_no, "
									+ "attachment_name, "
									+ "attachment_type, "
									+ "attachment_size) "
								+ "values(?, ?, ?, ?)";
		Object[] param = new Object[] {attachmentDto.getAttachmentNo(), 
										attachmentDto.getAttachmentName(), 
										attachmentDto.getAttachmentType(), 
										attachmentDto.getAttachmentSize()};
		jdbcTemplate.update(sql, param);
	}

	@Override
	public List<AttachmentDto> selectList() {
		String sql = "select * from attachment";
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public AttachmentDto selectOne(int attachmentNo) {
		String sql = "select * from attachment where attachment_no = ?";
		Object[] param = new Object[] {attachmentNo};
		return jdbcTemplate.query(sql, extractor, param);
	}

	@Override
	public boolean delete(int attachmentNo) {
		String sql = "delete attachment where attachment_no = ?";
		Object[] param = new Object[] {attachmentNo};
		return jdbcTemplate.update(sql, param) > 0;
	}
}