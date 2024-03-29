package com.yedam.app.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;
import com.yedam.app.emp.mapper.EmpMapper;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardMapper boardMapper;
	
	@Autowired
	EmpMapper empMapper;
	
	@Override
	public List<BoardVO> getBoardALL() {
		return boardMapper.selectBoardList(); 
	}

	@Override
	public BoardVO getBoardInfo(BoardVO boardVO) {
		return boardMapper.selectBoard(boardVO);
	}

	@Override
	public int insertBoardInfo(BoardVO boardVO) {
		int result = boardMapper.insertBoard(boardVO);
		if(result == 1) {
			return boardVO.getBno();
		}
		return -1; 
	}

	@Override
	public Map<String, Object> updateBoardInfo(BoardVO boardVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuc = false;
		
		int result = boardMapper.updateBoard(boardVO);
		if(result == 1) {
			isSuc = true;
		}
		map.put("result", isSuc);
		map.put("target", boardVO);
		return map;
	}

	@Override
	public boolean deleteBoardInfo(int boardNo) {
		int result = boardMapper.deleteBoard(boardNo);
		
		return result == 1 ? true : false;
	}
	
}
