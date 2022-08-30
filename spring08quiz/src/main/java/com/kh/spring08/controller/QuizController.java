package com.kh.spring08.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		String sql = "insert into music(music_no, music_title, music_artist, music_album, music_play, release_title) values(music_seq.nextval, ?, ?, ?, ?, sysdate)";
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
	@RequestMapping("/search")
	@ResponseBody
	public String search(@RequestParam String type, @RequestParam String keyword) {
		
		String sql = "select * from music where instr(#!, ?) > 0";
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
	
	// 4. 상세(/detail)
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
}
