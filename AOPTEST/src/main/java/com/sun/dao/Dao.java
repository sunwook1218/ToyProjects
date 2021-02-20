package com.sun.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.model.Member;

@Repository
public class Dao {

	@Autowired
	private SqlSessionTemplate sst;

	public int insert(Member member) {
		return sst.insert("memberns.insert", member);
	}

	public void delete() {
		sst.delete("memberns.deleteAll");
	}

	public List<Member> selectAll() {
		return sst.selectList("memberns.selectAll");
	}

}
