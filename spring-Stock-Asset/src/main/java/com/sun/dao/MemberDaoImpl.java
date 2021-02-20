package com.sun.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.model.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public int join(Member member) {
		return sst.insert("memberns.join", member);
	}

	@Override
	public Member getMember(Member tempM) {
		return sst.selectOne("memberns.getMember", tempM);
	}

	@Override
	public Member getMemberById(String id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		return sst.selectOne("memberns.getMemberById", map);
	}

}
