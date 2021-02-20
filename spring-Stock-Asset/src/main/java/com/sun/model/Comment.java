package com.sun.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Comment {

	private int idx;
	private int b_idx;
	private String m_id;
	private String content;
	private Date date;
	private String del;

}
