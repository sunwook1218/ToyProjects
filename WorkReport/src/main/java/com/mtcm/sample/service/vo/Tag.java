package com.mtcm.sample.service.vo;

import org.springframework.stereotype.Component;

@Component
public class Tag {

	private int tag_idx;
	private String tag_nm;

	public int getTag_idx() {
		return tag_idx;
	}

	public void setTag_idx(int tag_idx) {
		this.tag_idx = tag_idx;
	}

	public String getTag_nm() {
		return tag_nm;
	}

	public void setTag_nm(String tag_nm) {
		this.tag_nm = tag_nm;
	}

}
