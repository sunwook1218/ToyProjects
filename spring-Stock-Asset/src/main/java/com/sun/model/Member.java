package com.sun.model;

import lombok.Data;

@Data
public class Member {
	
	private int idx;
	private String id;
	private String name;
	private String password;
	private String email;
	private String address;
	private String isAdmin;
	private String gender;

}
