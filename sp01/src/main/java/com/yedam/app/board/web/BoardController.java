package com.yedam.app.board.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	// 전체 조회 : URI - boardList / RETURN - board/boardList
	@GetMapping("boardList")
	public String getBoardList(Model model) {
		List<BoardVO> list = boardService.getBoardALL();
		model.addAttribute("BoardList", list);
		return "board/boardList";
	}
	// 단건 조회 : URI - boardInfo / PARAMETER - BoardVO
	//			/ RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String getBoardInfo(Model model, BoardVO boardVO) {
		BoardVO vo = boardService.getBoardInfo(boardVO);
		model.addAttribute("boardInfo", vo);
		return "board/boardInfo";
	}
	
	
	// 등록 - 페이지 : URI - boardInsert / RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String InsertBoardInfoFrom() {
		return "board/boardInsert";
	}
	
	// 등록 - 처리 : URI - boardInsert / PARAMETER - BoardVO
	//				/ RETURN - 전체조회 다시 호출
	@PostMapping("boardInsert")
	public String insertBoardInfoProcess(BoardVO boardVO) {
		boardService.insertBoardInfo(boardVO);
		String path = "redirect:boardList";
		return path;
	}
	
	// 수정 - 페이지 : URI - boardUpdate / PARAMETER - BoardVO
	//				/ RETURN - board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdateInfo(Model model, BoardVO boardVO) {
		BoardVO vo = boardService.getBoardInfo(boardVO);
		model.addAttribute("boardInfo", vo);
		return "board/boardUpdate";
	}
	
	// 수정 - 처리 : URI - boardUpdate / PARAMETER - BoardVO
	//				/ RETURN - 수정결과 데이터(Map) => ajax
	@PostMapping("boardUpdate")
	@ResponseBody
	public Map<String, Object> updateBoardInfoProcess(@RequestBody BoardVO boardVO, Model model) {
		return boardService.updateBoardInfo(boardVO);
	}
	
	@GetMapping("boardDelete")
	public String boardDelete(@RequestParam Integer bno) {
		boardService.deleteBoardInfo(bno);
		return "redirect:boardList";
		
	}
}
