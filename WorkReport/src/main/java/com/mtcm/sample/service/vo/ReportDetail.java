package com.mtcm.sample.service.vo;

import org.springframework.stereotype.Component;

@Component
public class ReportDetail {

	private int d_idx;
	private int r_idx;
	private String opt_cd;
	private String content;
	private int d_ord;

	public int getD_idx() {
		return d_idx;
	}

	public void setD_idx(int d_idx) {
		this.d_idx = d_idx;
	}

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getD_ord() {
		return d_ord;
	}

	public void setD_ord(int d_ord) {
		this.d_ord = d_ord;
	}

}
