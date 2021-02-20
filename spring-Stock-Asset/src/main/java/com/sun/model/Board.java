package com.sun.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Board {
	
	private int idx;
	private int m_idx;
	private String m_id;
	private String s_code;
	private String title;
	private String content;
	private int readcount;
	private Date reg_date;
	private String del; // 삭제여부 y or n
	private int likecount;
	private String file_name;
	
	// 페이징용
	private int startPage;
	private int endPage;
	
	// 검색용
	private String search;
	private String keyword;

}
