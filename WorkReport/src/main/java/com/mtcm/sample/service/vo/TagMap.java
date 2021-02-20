package com.mtcm.sample.service.vo;

import org.springframework.stereotype.Component;

@Component
public class TagMap {

	private int d_idx;
	private int tag_idx;

	public int getD_idx() {
		return d_idx;
	}

	public void setD_idx(int d_idx) {
		this.d_idx = d_idx;
	}

	public int getTag_idx() {
		return tag_idx;
	}

	public void setTag_idx(int tag_idx) {
		this.tag_idx = tag_idx;
	}

}
