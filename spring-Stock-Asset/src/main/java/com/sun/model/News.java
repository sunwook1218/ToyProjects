package com.sun.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class News {
	
	private String title;
	private String link;
	private String info;
	private String date;

}
