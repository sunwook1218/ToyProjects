package com.sun.scrapper;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CompanyInfoTableScrapper {

	public static ArrayList<String> getTable(String code) throws IOException {

		String url = "https://navercomp.wisereport.co.kr/v2/company/c1010001.aspx?cmp_cd=";

		Document doc = Jsoup.connect(url).get();

		Elements elements1 = doc.select(".fund");
		Elements elements2 = doc.select(".body");

		int idx = 0;
		ArrayList<String> tableList = new ArrayList<String>();

		for (Element element : elements1) {
			idx++;
			if (idx >= 2) {
				break;
			}
			tableList.add(element.html());
		}

		for (Element element : elements2) {
			tableList.add(element.html());
		}

		return tableList;
	}

}
