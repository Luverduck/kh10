package com.kh.spring08.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring08.entity.MusicDto;

@Controller
@RequestMapping("/music")
public class QuizController {
	
	// jdbcTemplate
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 1. 등록(/insert)
	@RequestMapping("/insert")
	@ResponseBody
	public String inser(@ModelAttribute MusicDto musicDto) {
		String sql = "insert into music(music_no, music_title, music_artist, music_album, music_play, release_title) values(music_seq.nextval, ?, ?, ?, 0, sysdate)";
		// 파라미터로 전달 가능한 데이터는 String 뿐이다
		// 하지만 원시형과 배열(리스트)까지는 자동 변환을 해준다
		// Date는 전달 불가능
		Object[] param = new Object[] {musicDto.getMusicTitle(), musicDto.getMusicArtist(), musicDto.getMusicAlbum(), musicDto.getMusicPlay()};
		int result = jdbcTemplate.update(sql, param);
		if(result > 0) {
			return "등록 성공";
		}
		else {
			return "등록 실패";
		}
	}
	
	/*
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(
						@RequestParam String musicTitle,
						@RequestParam String musicArtist,
						@RequestParam String musicAlbum,
						@RequestParam int musicPlay
						) {
		String sql = "insert into music(music_no, music_title, music_artist, music_album, music_play, release_title) values(music_seq.nextval, ?, ?, ?, ?, sysdate)";
		Object[] param = new Object[] {musicTitle, musicArtist, musicAlbum, musicPlay};
		int result = jdbcTemplate.update(sql, param);
		if(result > 0) {
			return "등록 성공";
		}
		else {
			return "올바른 정보를 입력해주세요";
		}
	}
	*/
	
	// 2. 조회(/list)
	@RequestMapping("/list")
	@ResponseBody
	public String list() {
		String sql = "select * from music order by music_no asc";
		List<MusicDto> list = jdbcTemplate.query(sql, MusicDto.getMapper());
		StringBuffer buffer = new StringBuffer();
		for(MusicDto musicDto : list) {
			buffer.append(musicDto);
			buffer.append("<br>");
		}
		return buffer.toString();
	}
	
	// 3. 검색(/search)
	// 1) 제목, 가수, 앨범 중 검색
	@RequestMapping("/search1")
	@ResponseBody
	public String search1(@RequestParam String keyword) {
		String sql = "select * from music where instr(music_title, ?) > 0 or instr(music_artist, ?) > 0 or instr(music_album, ?) > 0 order by music_no asc";
		Object[] param = {keyword, keyword, keyword};
		
		List<MusicDto> list = jdbcTemplate.query(sql, MusicDto.getMapper());
		
		StringBuffer buffer = new StringBuffer();
		for(MusicDto musicDto : list) {
			buffer.append(musicDto);
			buffer.append("<br>");
		}
		return buffer.toString();
	}
	
	// 2) 특정 항목에서만 검색
	@RequestMapping("/search2")
	@ResponseBody
	public String search2(@RequestParam String type, @RequestParam String keyword) {
		
		String sql = "select * from music where instr(#!, ?) > 0 order by #1 asc";
		sql = sql.replace("#1", type);
		
		Object[] param = new Object[] {keyword};
		
		List<MusicDto> list = jdbcTemplate.query(sql, MusicDto.getMapper(), param);
		
		StringBuffer buffer = new StringBuffer();
		for(MusicDto musicDto : list) {
			buffer.append(musicDto);
			buffer.append("<br>");
		}
		return buffer.toString();
	}
	
	// 추가 : 목록과 검색을 한번에
	// - @RequestParam이라고 적으면 반드시 해당 파라미터가 존재해야 한다
	// - 옵션을 부여하면 여러가지 추가 처리가 가능, @RequestParam(옵션)
	@RequestMapping("/search3")
	@ResponseBody
	public String search3(@RequestParam(required = false) String type, @RequestParam(required = false) String keyword) {
		// type과 keyword가 반드시 필요하지는 않음
		// 없는 경우 null로 입력, 있는 경우 해당 값으로 입력
		/*
		if(type, keyword 둘 다 있으면) {
			검색
			data = 검색 결과;
		}
		else {
			목록
			data = 목록 결과;
		}
		
		출력
		*/
		
		List<MusicDto> list;
		// http://localhost:8888/music/search3?type=music_name&keyword=아 로 들어가면 이름에 '아'가 포함된 항목만 조회
		if(type != null && keyword != null) {	
			String sql = "select * from music where instr(#1, ?) > 0 order by #1 asc";
			sql = sql.replace("#1", type);
			Object[] param = new Object[] {keyword};
			list = jdbcTemplate.query(sql, MusicDto.getMapper(), param);
		}
		
		// http://localhost:8888/music/search3 로 들어가면 전체 항목을 조회
		else {	
			String sql = "select * from music order by music_no asc";
			list = jdbcTemplate.query(sql, MusicDto.getMapper());
		}
		
		return "type = " + type + ", keyword = " + keyword;
	}
	
	// 4. 상세(/detail)
	@RequestMapping("/detail/{musicNo}")
	@ResponseBody
	public String detail(@PathVariable int musicNo) {
		String sql = "select * from music where music_no = ?";
		Object[] param = new Object[] {musicNo};
		MusicDto musicDto = jdbcTemplate.query(sql, MusicDto.getExtractor(), param);
		if(musicDto != null) {
			return musicDto.toString();
		}
		else {
			return "없는 번호";
		}
	}
	/*
	@RequestMapping("/detail")
	@ResponseBody
	public String detail(@RequestParam int musicNo) {
		String sql = "select * from music where music_no = ?";
		Object[] param = new Object[] {musicNo};
		MusicDto musicDto = jdbcTemplate.query(sql, MusicDto.getExtractor(), param);
		if(musicDto != null) {
			return musicDto.toString();
		}
		else {
			return "없는 번호";
		}
	}
	*/
	
	// 5. 수정(/update)
	@RequestMapping("/update")
	@ResponseBody
	public String update(@RequestParam int musicNo, 
						@RequestParam String musicTitle, 
						@RequestParam String musicArtist, 
						@RequestParam String musicAlbum,
						@RequestParam int musicPlay) {
		String sql = "update music set music_title = ?, music_artist = ?, music_album = ?, music_play = ? where musicPlay = ?";
		Object[] param = new Object[] {musicNo, musicTitle, musicArtist, musicAlbum, musicPlay};
		int result = jdbcTemplate.update(sql, param);
		if(result > 0) {
			return "수정 성공";
		}
		else {
			return "없는 번호";
		}
	}
	
	// 6. 삭제(/delete)
	// 경로 변수(상세보기, 삭제)를 이용해서 http://localhost:8888/music/delete/21 로 주소 변경
	// @RequestParam, @ModelAttribute
	// @PathVariable, @ModelAttribute
	@RequestMapping("/delete/{musicNo}")
	@ResponseBody
	public String delete(@PathVariable int musicNo) {
		String sql = "delete music where music_no = ?";
		Object[] param = new Object[] {musicNo};
		int result = jdbcTemplate.update(sql, param);
		if(result > 0) {
			return "삭제 성공";
		}
		else {
			return "없는 번호";
		}
	}
	
	// 둘의 차이점 ??
	// http://localhost:8888/music/delete?musicNo=21
	// http://localhost:8888/music/delete/21
	// - 마지막 /의 위치(엔드포인트)가 다르다
	
	/*
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam int musicNo) {
		String sql = "delete music where music_no = ?";
		Object[] param = new Object[] {musicNo};
		int result = jdbcTemplate.update(sql, param);
		if(result > 0) {
			return "삭제 성공";
		}
		else {
			return "없는 번호";
		}
	}
	*/
}
