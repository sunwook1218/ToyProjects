package com.sun.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Items {

	private List<Item> itemList;

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

}
