package com.sun.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.model.Board;
import com.sun.model.Comment;
import com.sun.model.Member;
import com.sun.service.BoardService;
import com.sun.service.MemberService;
import com.sun.service.StockService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService bs;

	@Autowired
	private MemberService ms;

	@Autowired
	private StockService ss;

	@RequestMapping("/writeForm")
	public String writeForm(HttpSession session, Model model, String code) {

		if (session.getAttribute("authUser") == null) {
			return "member/loginForm";
		}

		model.addAttribute("boardcode", code);

		return "board/writeForm";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Model model, Board board, String code) {

		int result = bs.write(board);

		model.addAttribute("result", result);

		return "board/write";
	}

	@RequestMapping("/list")
	public String list(Model model, String code, String query ) {

		List<Board> boardListByCode = bs.getBoardListByCode(code);

		model.addAttribute("boardList", boardListByCode);

		String name = ss.getStockName(code);

		model.addAttribute("stockName", name);

		return "board/list";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String search(Model model, String code, String query, String category) {
		
		List<Board> boardListByCode = bs.getBoardListByCode(code);

		model.addAttribute("boardList", boardListByCode);

		String name = ss.getStockName(code);

		model.addAttribute("stockName", name);
		
		return "board/list";
	}

	@RequestMapping("/read")
	public String read(Model model, String code, int idx) {

		List<Board> boardList = bs.getBoardListByCode(code);

		Board temp = new Board();
		temp.setS_code(code);
		temp.setIdx(idx);

		Board board = bs.getBoard(temp);
		board.setReadcount(board.getReadcount() + 1); // readcount++
		bs.update(board);

		model.addAttribute("board", board);
		model.addAttribute("boardList", boardList);

		return "board/read";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.POST)
	public String comment(Model model, String code, Integer idx, Comment comment) {
		
		List<Board> boardList = bs.getBoardListByCode(code);
		
		Board temp = new Board();
		temp.setS_code(code);
		temp.setIdx(idx);

		Board board = bs.getBoard(temp);
		// comment update

		model.addAttribute("board", board);
		model.addAttribute("boardList", boardList);
		
		return "board/read";
	}

	@RequestMapping("/modifyForm")
	public String modifyForm(Model model, String code, int idx, HttpSession session) {
		
		Member member = (Member) session.getAttribute("authUser");
		
		Board temp = new Board();
		temp.setS_code(code);
		temp.setIdx(idx);
		
		Board board = bs.getBoard(temp);
		
		if(member != null) {
			if(member.getIdx() == board.getM_idx()) {
				model.addAttribute("board", board);
			} else {
				int result = -1;
				model.addAttribute("result", result);
			}
		}

		return "board/modifyForm";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(String code, int idx, Board board, Model model) {
		
		Board temp = new Board();
		temp.setS_code(code);
		temp.setIdx(idx);
		
		Board modified = bs.getBoard(temp);
		modified.setTitle(board.getTitle());
		modified.setContent(board.getContent());
		
		int result = bs.update(modified);
		
		model.addAttribute("result", result);
		
		return "board/modify";
	}

	@RequestMapping("/delete")
	public String delete(Model model, String code, int idx, HttpSession session) {

		Member member = (Member) session.getAttribute("authUser");

		Board temp = new Board();
		temp.setS_code(code);
		temp.setIdx(idx);

		int result = 0;

		if (member != null) {

			Board board = bs.getBoard(temp);

			if (board.getM_idx() == member.getIdx()) {

				board.setDel("y");
				result = bs.update(board);

				model.addAttribute("result", result);
				model.addAttribute("board", board);
			} else {
				result = -1;
			}
		}

		model.addAttribute("result", result);

		return "board/delete";
	}

}
