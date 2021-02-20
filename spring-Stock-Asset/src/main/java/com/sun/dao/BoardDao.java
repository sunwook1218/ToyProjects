package com.sun.dao;

import java.util.List;

import com.sun.model.Board;
import com.sun.model.Member;

public interface BoardDao {

	int write(Board board);

	List<Board> getBoardListByCode(String code);

	Board getBoard(Board board);

	int update(Board board);

	List<Board> getBoardListByMember(Member member);

}
