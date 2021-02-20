package com.mtcm.sample.service.vo;

import org.springframework.stereotype.Component;

@Component
public class AuthMap {

	private String m_id;
	private String dept_cd;

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

}
