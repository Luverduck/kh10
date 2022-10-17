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

import com.kh.springhome.entity.MemberDto;
import com.kh.springhome.vo.MemberMyBoardVO;
import com.kh.springhome.vo.MemberMyLikeVO;
import com.kh.springhome.vo.MemberMyReplyVO;
import com.kh.springhome.vo.MemberWriteCountVO;

@Repository
public class MemberDaoImpl implements MemberDao {
 
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 추상 메소드 오버라이딩 (입력)
	@Override
	public void insert(MemberDto memberDto) {
		// 테이블 생성시 default를 설정한 컬럼(point, grade, join, login)의 값은 입력하지 않아도 된다
		String sql = "insert into member("
										+ "member_id, "
										+ "member_pw, "
										+ "member_nick, "
										+ "member_birth, "
										+ "member_tel, "
										+ "member_email, "
										+ "member_post, "
										+ "member_base_address, "
										+ "member_detail_address) "
								+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] param = new Object[] {
										memberDto.getMemberId(), 
										memberDto.getMemberPw(), 
										memberDto.getMemberNick(), 
										memberDto.getMemberBirth(), 
										memberDto.getMemberTel(), 
										memberDto.getMemberEmail(), 
										memberDto.getMemberPost(), 
										memberDto.getMemberBaseAddress(), 
										memberDto.getMemberDetailAddress()
										// 관리자가 설정해야 할 항목
										// memberDto.getMemberPoint(),
										// memberDto.getMemberGrade(),
										// memberDto.getMemberJoin(),
										// 로그인시 설정해야 할 항목 (일단 null)
										// memberDto.getMemberLogin()
										};
		jdbcTemplate.update(sql, param);
	}
	
	// RowMapper
	private RowMapper<MemberDto> mapper = new RowMapper<>() {
		@Override
		public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberId(rs.getString("member_id"));
			memberDto.setMemberPw(rs.getString("member_pw"));
			memberDto.setMemberNick(rs.getString("member_nick"));
			memberDto.setMemberBirth(rs.getDate("member_birth"));
			memberDto.setMemberTel(rs.getString("member_tel"));
			memberDto.setMemberEmail(rs.getString("member_email"));
			memberDto.setMemberPost(rs.getString("member_post"));
			memberDto.setMemberBaseAddress(rs.getString("member_base_address"));
			memberDto.setMemberDetailAddress(rs.getString("member_detail_address"));
			memberDto.setMemberPoint(rs.getInt("member_point"));
			memberDto.setMemberGrade(rs.getString("member_grade"));
			memberDto.setMemberJoin(rs.getDate("member_join"));
			memberDto.setMemberLogin(rs.getDate("member_login"));
			return memberDto;
		}
	};
	
	// 추상 메소드 오버라이딩 (조회)
	@Override
	public List<MemberDto> selectList() {
		String sql = "select * from member order by member_id asc";
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public List<MemberDto> selectList(String type, String keyword) {
		String sql = "select * from member where instr(#1, ?) > 0 order by #1 asc";
		sql = sql.replace("#1", type);
		Object[] param = new Object[] {keyword};
		return jdbcTemplate.query(sql, mapper, param);
	}
	
	// ResultSetExtractor
	private ResultSetExtractor<MemberDto> extractor = new ResultSetExtractor<>() {
		@Override
		public MemberDto extractData(ResultSet rs) throws SQLException, DataAccessException {
			if(rs.next()) {
				MemberDto memberDto = new MemberDto();
				memberDto.setMemberId(rs.getString("member_id"));
				memberDto.setMemberPw(rs.getString("member_pw"));
				memberDto.setMemberNick(rs.getString("member_nick"));
				memberDto.setMemberBirth(rs.getDate("member_birth"));
				memberDto.setMemberTel(rs.getString("member_tel"));
				memberDto.setMemberEmail(rs.getString("member_email"));
				memberDto.setMemberPost(rs.getString("member_post"));
				memberDto.setMemberBaseAddress(rs.getString("member_base_address"));
				memberDto.setMemberDetailAddress(rs.getString("member_detail_address"));
				memberDto.setMemberPoint(rs.getInt("member_point"));
				memberDto.setMemberGrade(rs.getString("member_grade"));
				memberDto.setMemberJoin(rs.getDate("member_join"));
				memberDto.setMemberLogin(rs.getDate("member_login"));
				return memberDto;
			}
			else {
				return null;
			}
		}
	};

	// 추상 메소드 오버라이딩 (상세 조회)
	@Override
	public MemberDto selectOne(String memberId) {
		String sql = "select * from member where member_id = ? order by member_join asc";
		Object[] param = new Object[] {memberId};
		return jdbcTemplate.query(sql, extractor, param);
	}

	// 추상 메소드 오버라이딩 (수정)
	@Override
	public boolean update(MemberDto memberDto) {
		// 바꿀 정보 : pw, nick, tel, email, post, baseaddress, detailaddress, point, grade
		String sql = "update member set member_pw = ?, member_nick = ?, member_tel = ?, member_email = ?, member_post = ?, member_base_address = ?, member_detail_address = ?, member_point = ?, member_grade = ? where member_id = ?";
		Object[] param = new Object[] {
										memberDto.getMemberPw(), 
										memberDto.getMemberNick(), 
										memberDto.getMemberTel(), 
										memberDto.getMemberEmail(), 
										memberDto.getMemberPost(), 
										memberDto.getMemberBaseAddress(), 
										memberDto.getMemberDetailAddress(), 
										memberDto.getMemberPoint(), 
										memberDto.getMemberGrade(), 
										memberDto.getMemberId()
										};
		return jdbcTemplate.update(sql, param) > 0;
	}

	// 추상 메소드 오버라이딩 (삭제)
	@Override
	public boolean delete(String memberId) {
		String sql = "delete member where member_id = ?";
		return jdbcTemplate.update(sql, memberId) > 0;
	}
	
	// 추상 메소드 오버라이딩 (비밀번호 변경)
	@Override
	public boolean changePassword(String memberId, String memberPw) {
		String sql = "update member set member_pw = ? where member_id = ?";
		Object[] param = {memberPw, memberId};
		return jdbcTemplate.update(sql, param) > 0;
	}
	
	// 추상 메소드 오버라이딩 (개인정보 변경)
	@Override
	public boolean changeInformation(MemberDto memberDto) {
		String sql = "update member set member_nick = ?, member_tel = ?, member_email = ?, member_post = ?, member_base_address = ?, member_detail_address = ? where member_id = ?";
		Object[] param = {memberDto.getMemberNick(), memberDto.getMemberTel(), memberDto.getMemberEmail(), memberDto.getMemberPost(), memberDto.getMemberBaseAddress(), memberDto.getMemberDetailAddress(), memberDto.getMemberId()};
		return jdbcTemplate.update(sql, param) > 0;
	}
	
	// 추상 메소드 재정의 (로그인 시간 갱신)
	@Override
	public boolean updateLoginTime(String memberId) {
		String sql = "update member set member_login = sysdate where member_id = ?";
		Object[] param = {memberId};
		return jdbcTemplate.update(sql, param) > 0;
	}

	// MemberWriteCountVO를 위한 RowMapper
	private RowMapper<MemberWriteCountVO> countMapper = new RowMapper<>() {
		@Override
		public MemberWriteCountVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			return MemberWriteCountVO.builder()
										.memberId(rs.getString("member_id"))
										.boardCount(rs.getInt("board_count"))
										.boardRank(rs.getInt("board_rank"))
										.build();
		}
	};
	
	// 추상 메소드 오버라이딩 - 글을 가장 많이 쓴 회원
	@Override
	public List<MemberWriteCountVO> writeCount() {
		String sql = "select * from (select TMP.*, rownum board_rank from (select distinct M.member_id, count(B.board_no) over(partition by M.member_id) board_count from member M left outer join board B on M.member_id = B.board_writer order by board_count desc)TMP) where board_rank between 1 and 5";
		return jdbcTemplate.query(sql, countMapper);
	}

	@Override
	public List<MemberWriteCountVO> writeCount(Integer memberEnd) {
		String sql = "select * from (select TMP.*, rownum board_rank from (select distinct M.member_id, count(B.board_no) over(partition by M.member_id) board_count from member M left outer join board B on M.member_id = B.board_writer order by board_count desc)TMP) where board_rank between 1 and ?";
		Object[] param = {memberEnd};
		return jdbcTemplate.query(sql, countMapper, param);
	}

	// MemberMyBoardVO를 위한 RowMapper
	private RowMapper<MemberMyBoardVO> myBoardMapper = new RowMapper<>() {
		@Override
		public MemberMyBoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			return MemberMyBoardVO.builder()
										.boardNo(rs.getInt("board_no"))
										.memberId(rs.getString("member_id"))
										.boardTitle(rs.getString("board_title"))
										.boardWritetime(rs.getDate("board_writetime"))
										.boardRead(rs.getInt("board_read"))
										.boardLike(rs.getInt("board_like"))
										.build();
		}
	};
	
	@Override
	public List<MemberMyBoardVO> myBoard(String memberId) {
		String sql = "select * from (select TMP.*, rownum rn from (select M.member_id, B.board_no, B.board_writer, B.board_title, B.board_writetime, B.board_read, B.board_like from member M left outer join board B on M.member_id = B.board_writer where M.member_id = ? order by B.board_no desc)TMP) where rn between 1 and 5";
		Object[] param = new Object[] {memberId};
		return jdbcTemplate.query(sql,myBoardMapper, param);
	}
	
	// MemberMyLikeVO를 위한 RowMapper
	private RowMapper<MemberMyLikeVO> myLikeMapper = new RowMapper<>() {
		@Override
		public MemberMyLikeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			return MemberMyLikeVO.builder()
										.boardNo(rs.getInt("board_no"))
										.boardHead(rs.getString("board_head"))
										.boardTitle(rs.getString("board_title"))
										.boardWritetime(rs.getDate("board_writetime"))
										.boardRead(rs.getInt("board_read"))
										.boardLike(rs.getInt("board_like"))
										.boardGroup(rs.getInt("board_group"))
										.boardParent(rs.getInt("board_parent"))
										.boardDepth(rs.getInt("board_depth"))
										.build();
		}
	};

	// 추상 메소드 오버라이딩 - 내가 좋아요한 작성글
	@Override
	public List<MemberMyLikeVO> myLike(String memberId) {
		String sql = "select * from (select TMP.*, rownum rank from (select B.board_no, B.board_head, B.board_title, B.board_writetime, B.board_read, B.board_like, B.board_group, B.board_parent, B.board_depth from member_board_like ML left outer join board B on ML.board_no = B.board_no where ML.member_id = ?)TMP) where rank between 1 and 5";
		Object[] param = new Object[] {memberId};
		return jdbcTemplate.query(sql, myLikeMapper, param);
	}

	// MemberMyLikeVO를 위한 RowMapper
	private RowMapper<MemberMyReplyVO> myReplyMapper = new RowMapper<>() {
		@Override
		public MemberMyReplyVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return MemberMyReplyVO.builder()
									.boardNo(rs.getInt("board_no"))
									.boardHead(rs.getString("board_head"))
									.boardTitle(rs.getString("board_title"))
									.boardWriter(rs.getString("board_writer"))
									.boardWritetime(rs.getDate("board_writetime"))
									.boardGroup(rs.getInt("board_group"))
									.boardParent(rs.getInt("board_parent"))
									.boardDepth(rs.getInt("board_depth"))
									.replyContent(rs.getString("reply_content"))
									.replyWritetime(rs.getDate("reply_writetime"))
								.build();
		}
	};
	
	// 추상 메소드 오버라이딩 - 내가 작성한 댓글
	@Override
	public List<MemberMyReplyVO> myReply(String memberId) {
		String sql = "select * from (select TMP.*, rownum rn from (select B.board_no, B.board_head, B.board_title, B.board_writer, B.board_writetime, B.board_group, B.board_parent, B.board_depth, R1.reply_content, R1.reply_writetime from (select * from reply R left outer join member M on R.reply_writer = M.member_id where reply_writer = ? order by R.reply_writetime desc) R1 left outer join board B on R1.reply_origin = B.board_no)TMP) where rn between 1 and 5";
		Object[] param = new Object[] {memberId};
		return jdbcTemplate.query(sql, myReplyMapper, param);
	}

	// 추상 메소드 오버라이딩 - 닉네임을 이용한 단일 조회 (닉네임 검사용)
	@Override
	public MemberDto findByNickname(String memberNick) {
		String sql = "select * from member where member_nick = ?";
		Object[] param = {memberNick};
		return jdbcTemplate.query(sql, extractor, param);
	}
}
