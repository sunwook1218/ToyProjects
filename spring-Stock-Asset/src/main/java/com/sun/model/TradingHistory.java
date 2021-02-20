package com.sun.model;

import java.sql.Date;

import lombok.Data;

@Data
public class TradingHistory {

	private int idx;
	private int m_idx;
	private Date t_date;
	private String s_code; // stock code
	private String s_name;
	private int amount;
	private int price; //
	private String action; // purchase or sell (p or s)

}
