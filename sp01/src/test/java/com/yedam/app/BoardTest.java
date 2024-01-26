package com.yedam.app;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.aop.service.AaaService;
import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class BoardTest {
	
	@Autowired
	BoardMapper boardMapper;	
	
	//전체조회
	//@Test
	public void selectList() {
		List<BoardVO> list = boardMapper.selectBoardList();
		assertTrue(!list.isEmpty());
	}
	
	//@Test
	public void insert() {
		BoardVO vo = new BoardVO();
		vo.setBno(100);
		vo.setTitle("타ㅁㄴㅇㄹ");
		vo.setContents("내용");
		vo.setWriter("글쓴이");
		vo.setImage("이미쥐");
		
		int result = boardMapper.insertBoard(vo);
		assertNotEquals(result, 0);
	}
	
	@Autowired
	AaaService aaaService;
	
	@Test
	public void aopTest() {
		aaaService.insert();
	}
	
}
