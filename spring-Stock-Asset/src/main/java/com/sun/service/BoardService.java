package com.sun.service;

import java.util.List;

import com.sun.model.Board;
import com.sun.model.Member;

public interface BoardService {

	int write(Board board);

	List<Board> getBoardListByCode(String code);

	Board getBoard(Board temp);

	int update(Board board);

	List<Board> getBoardListByMember(Member member);

}
