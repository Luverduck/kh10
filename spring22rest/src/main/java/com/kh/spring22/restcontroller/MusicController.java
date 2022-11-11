package com.kh.spring22.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring22.entity.MusicDto;
import com.kh.spring22.repository.MusicDao;

@RestController
@RequestMapping("/rest")
public class MusicController {

	// 의존성 주입
	@Autowired
	private MusicDao musicDao;
	
	// 조회 Mapping
	@GetMapping("/music")
	public List<MusicDto> list(){
		return musicDao.list();
	}
	
	// 단일 조회 Mapping
	@GetMapping("/music/{musicNo}")
	public MusicDto find(@PathVariable int musicNo) {
		return musicDao.find(musicNo);
	}
	
	// 등록 Mapping
	@PostMapping("/music")
	public void insert(@RequestBody MusicDto musicDto) {
		musicDao.insert(musicDto);
	}
	
	// 수정 Mapping
	@PutMapping("/music")
	public boolean edit(@RequestBody MusicDto musicDto) {
		return musicDao.edit(musicDto);
	}
	
	// 삭제 Mapping
	@DeleteMapping("/music/{musicNo}")
	public boolean delete(@PathVariable int musicNo) {
		return musicDao.delete(musicNo);
	}
}
