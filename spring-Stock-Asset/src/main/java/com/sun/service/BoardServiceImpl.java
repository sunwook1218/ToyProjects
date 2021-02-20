package com.sun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.dao.BoardDao;
import com.sun.model.Board;
import com.sun.model.Member;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao bd;

	@Override
	public int write(Board board) {
		return bd.write(board);
	}

	@Override
	public List<Board> getBoardListByCode(String code) {
		return bd.getBoardListByCode(code);
	}

	@Override
	public Board getBoard(Board board) {
		return bd.getBoard(board);
	}

	@Override
	public int update(Board board) {
		return bd.update(board);
	}

	@Override
	public List<Board> getBoardListByMember(Member member) {
		return bd.getBoardListByMember(member);
	}

}
