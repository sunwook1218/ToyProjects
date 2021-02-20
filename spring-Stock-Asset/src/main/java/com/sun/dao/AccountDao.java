package com.sun.dao;

import java.util.List;

import com.sun.model.Account;

public interface AccountDao {

	int create(Account account);

	List<Account> getAllAccount(int m_idx);

	Account getOneAccount(int m_idx);

	void update(Account oneAccount);

}
