package com.mtcm.sample.service.vo;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class ReportLog {

	private int r_idx;
	private String opt_cd;
	private Timestamp log_time;

	public int getR_idx() {
		return r_idx;
	}

	public void setR_idx(int r_idx) {
		this.r_idx = r_idx;
	}

	public String getOpt_cd() {
		return opt_cd;
	}

	public void setOpt_cd(String opt_cd) {
		this.opt_cd = opt_cd;
	}

	public Timestamp getLog_time() {
		return log_time;
	}

	public void setLog_time(Timestamp log_time) {
		this.log_time = log_time;
	}

}
