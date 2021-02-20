package com.mtcm.sample.service.vo;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class Report {

	private int r_idx;
	private String week;
	private String m_id;
	private String mod_id;
	private String dept_cd;
	private String title;
	private Timestamp regdate;
	private Timestamp moddate;
	private char del_fl;

	public int getR_idx() {
		return r_idx;
	}

	public void setR_idx(int r_idx) {
		this.r_idx = r_idx;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getMod_id() {
		return mod_id;
	}

	public void setMod_id(String mod_id) {
		this.mod_id = mod_id;
	}

	public String getDept_cd() {
		return dept_cd;
	}

	public void setDept_cd(String dept_cd) {
		this.dept_cd = dept_cd;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public Timestamp getModdate() {
		return moddate;
	}

	public void setModdate(Timestamp moddate) {
		this.moddate = moddate;
	}

	public char getDel_fl() {
		return del_fl;
	}

	public void setDel_fl(char del_fl) {
		this.del_fl = del_fl;
	}

}
