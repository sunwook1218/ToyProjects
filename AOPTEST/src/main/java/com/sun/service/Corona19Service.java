package com.sun.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.api.datagokr.ApiExplorer;
import com.sun.model.Item;

@Service
public class Corona19Service {

	@Autowired
	private ApiExplorer apiExplorer;

	public List<Item> getitemList(String startDate, String endDate) throws UnsupportedEncodingException, IOException {

		List<Item> itemList = new ArrayList<Item>();

		Document doc = Jsoup.connect(apiExplorer.getUrl(startDate, endDate)).get();
		Elements elements = doc.select("item");

		for (Element element : elements) {

			Item item = new Item();
			item.setAccDefRate(Float.parseFloat(element.select("accDefRate").text()));
			item.setAccExamCnt(Integer.parseInt(element.select("accExamCnt").text()));
			item.setAccExamCompCnt(Integer.parseInt(element.select("accExamCompCnt").text()));
			item.setCareCnt(Integer.parseInt(element.select("careCnt").text()));
			item.setClearCnt(Integer.parseInt(element.select("clearCnt").text()));
			item.setCreateDt(element.select("createDt").text());
			item.setDeathCnt(Integer.parseInt(element.select("deathCnt").text()));
			item.setDecideCnt(Integer.parseInt(element.select("decideCnt").text()));
			item.setExamCnt(Integer.parseInt(element.select("examCnt").text()));
			item.setResutlNegCnt(Integer.parseInt(element.select("resutlNegCnt").text()));
			item.setSeq(Integer.parseInt(element.select("seq").text()));
			item.setStateDt(element.select("stateDt").text());
			item.setStateTime(element.select("stateTime").text());
			item.setUpdateDt(element.select("updateDt").text());

			itemList.add(item);
		}

		// 날짜 오름차순 정렬
		Collections.reverse(itemList);

		return itemList;
	}

}
