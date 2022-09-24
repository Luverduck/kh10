package com.kh.springhome.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MusicLatestListVO {

	// 필드
	int musicNo;
	String musicTitle;
	String musicArtist;
	Date releaseTitle;
}
