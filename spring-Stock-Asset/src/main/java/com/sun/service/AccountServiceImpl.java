package com.sun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.dao.AccountDao;
import com.sun.model.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao ad;

	@Override
	public int create(Account account) {
		return ad.create(account);
	}

	@Override
	public List<Account> getAllAccount(int m_idx) {
		return ad.getAllAccount(m_idx);
	}

	@Override
	public Account getOneAccount(int m_idx) {
		return ad.getOneAccount(m_idx);
	}

	@Override
	public void update(Account oneAccount) {
		ad.update(oneAccount);
		
	}

}
