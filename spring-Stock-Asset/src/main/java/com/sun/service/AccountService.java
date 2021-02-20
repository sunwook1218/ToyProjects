package com.sun.service;

import java.util.List;

import com.sun.model.Account;

public interface AccountService {

	int create(Account account);

	Account getOneAccount(int m_idx);

	List<Account> getAllAccount(int idx);

	void update(Account oneAccount);

}
