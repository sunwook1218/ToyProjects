package com.sun.model;

import java.sql.Date;

import lombok.Data;

@Data
public class AccountHistory {

	private int idx;
	private int a_idx;
	private Date date;
	private int deposit;
	private int withdraw;
	private int a_balance;

}
