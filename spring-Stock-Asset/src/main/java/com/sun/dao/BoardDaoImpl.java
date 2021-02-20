package com.sun.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.model.Board;
import com.sun.model.Member;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public int write(Board board) {
		return sst.insert("boardns.write", board);
	}

	@Override
	public List<Board> getBoardListByCode(String code) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("code", code);
		return sst.selectList("boardns.getBoardListByCode", map);
	}

	@Override
	public Board getBoard(Board board) {
		return sst.selectOne("boardns.getBoard", board);
	}

	@Override
	public int update(Board board) {
		return sst.update("boardns.update", board);
	}

	@Override
	public List<Board> getBoardListByMember(Member member) {
		return sst.selectList("boardns.getBoardListByMember", member);
	}
	
}
