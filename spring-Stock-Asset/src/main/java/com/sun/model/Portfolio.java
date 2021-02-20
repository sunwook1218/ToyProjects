package com.sun.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Portfolio {
	
	private int idx;
	private int m_idx;
	private String title;
	private String content;
	private int readcount;
	private int ref;
	private int re_step;
	private int re_level;
	private Date reg_date;
	private Date update_date;
	private String del;

	// 페이징용
	private int startRow;
	private int endRow;

	// 검색용
	private String search;
	private String keyword;

}
