package com.kh.springhome.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.springhome.entity.MemberBoardLikeDto;

@Repository
public class MemberBoardLikeDaoImpl implements MemberBoardLikeDao {

	// 의존성 주입
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 추상 메소드 오버라이딩 - 좋아요 등록
	@Override
	public void insert(MemberBoardLikeDto dto) {
		String sql = "insert into member_board_like(member_id, board_no) values(?, ?)";
		Object[] param = new Object[] {dto.getMemberId(), dto.getBoardNo()};
		jdbcTemplate.update(sql, param);
	}

	// 추상 메소드 오버라이딩 - 좋아요 삭제
	@Override
	public void delete(MemberBoardLikeDto dto) {
		String sql = "delete member_board_like where member_id = ? and board_no = ?";
		Object[] param = new Object[] {dto.getMemberId(), dto.getBoardNo()};
		jdbcTemplate.update(sql, param);
	}

	// 추상 메소드 오버라이딩 - 좋아요 여부 조회
	@Override
	public boolean check(MemberBoardLikeDto dto) {
		String sql = "select count(*) from member_board_like where member_id = ? and board_no = ?";
		Object[] param = new Object[] {dto.getMemberId(), dto.getBoardNo()};
		int count = jdbcTemplate.queryForObject(sql, int.class, param);
		return count == 1;	// 좋아요가 이미 되어 있으면 1 아니면 0 -> 좋아요가 되어 있는지(boolean)를 반환
	}

	// 추상 메소드 오버라이딩 - 좋아요 여부
	@Override
	public int count(int boardNo) {
		String sql = "select count(*) from member_board_like where board_no = ?";
		Object[] param = new Object[] {boardNo};
		return jdbcTemplate.queryForObject(sql, int.class, param);
	}

	// 추상 메소드 오버라이딩 - 좋아요 총 갯수 갱신
	@Override
	public void refresh(int boardNo) {
		String sql = "update board set board_like = (select count(*) from member_board_like where board_no = ?) where board_no = ?";
		Object[] param = new Object[] {boardNo, boardNo};
		jdbcTemplate.update(sql, param);
	}
}
