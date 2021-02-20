package com.sun.model;

import org.springframework.stereotype.Component;

@Component
public class Member {

	private int idx;
	private String name;
	private int age;

	public Member() { }

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
