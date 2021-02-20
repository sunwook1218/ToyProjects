package com.mtcm.sample.service.vo;

import org.springframework.stereotype.Component;

@Component
public class Member {

	private String m_id;
	private String dept_cd;
	private String pw;
	private String m_nm;
	private String rank_nm;
	private char del_fl;

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getDept_cd() {
		return dept_cd;
	}

	public void setDept_cd(String dept_cd) {
		this.dept_cd = dept_cd;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getM_nm() {
		return m_nm;
	}

	public void setM_nm(String m_nm) {
		this.m_nm = m_nm;
	}

	public String getRank_nm() {
		return rank_nm;
	}

	public void setRank_nm(String rank_nm) {
		this.rank_nm = rank_nm;
	}

	public char getDel_fl() {
		return del_fl;
	}

	public void setDel_fl(char del_fl) {
		this.del_fl = del_fl;
	}

}
