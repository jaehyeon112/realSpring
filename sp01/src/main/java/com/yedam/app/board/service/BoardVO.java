package com.yedam.app.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	private int bno;
	private String title;
	private String contents;
	private String writer;
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 서버쪽으로 들어오는 값이 이런 포맷이어야함.
	private Date regdate;
	private Date updateDate; // yyyy/MM/dd 화면단에서 데이터를 받아오지 않을것이므로 
	private String image;
}
