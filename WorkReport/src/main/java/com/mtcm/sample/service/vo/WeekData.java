package com.mtcm.sample.service.vo;

import org.springframework.stereotype.Component;

@Component
public class WeekData {

	private String week;
	private String week_start;
	private String week_end;

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getWeek_start() {
		return week_start;
	}

	public void setWeek_start(String week_start) {
		this.week_start = week_start;
	}

	public String getWeek_end() {
		return week_end;
	}

	public void setWeek_end(String week_end) {
		this.week_end = week_end;
	}

}
