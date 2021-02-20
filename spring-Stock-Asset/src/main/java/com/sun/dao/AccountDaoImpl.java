package com.sun.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.model.Account;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public int create(Account account) {
		return sst.insert("accountns.create", account);
	}

	@Override
	public List<Account> getAllAccount(int m_idx) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("m_idx", m_idx);
		return sst.selectList("accountns.getAllAccount", map);
	}

	@Override
	public Account getOneAccount(int m_idx) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("m_idx", m_idx);
		return sst.selectOne("accountns.getOneAccount", map);
	}

	@Override
	public void update(Account oneAccount) {
		sst.update("accountns.update", oneAccount);
	}

}
