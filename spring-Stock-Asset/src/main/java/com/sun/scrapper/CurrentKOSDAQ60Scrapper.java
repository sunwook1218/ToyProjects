package com.sun.scrapper;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CurrentKOSDAQ60Scrapper {

	public static ArrayList<String> get60() throws IOException {
		
		ArrayList current60 = new ArrayList();
		
		for(int page = 1; page <= 10; page++) {
			
			int idx = 0;
			String url = "https://finance.naver.com/sise/sise_index_day.nhn?code=KOSDAQ&page=";
			url = url + page;
			
			Document doc = Jsoup.connect(url).get();
			
			Elements elements = doc.select("tbody tr");
			
			for(Element element : elements) {
				if(idx == 2 || idx == 3 || idx == 4 || idx == 9 || idx == 10 || idx == 11) {
					String price = element.getElementsByClass("number_1").text().substring(0, 3);
					price = removeComma(price);
					current60.add(price);
				}
				idx++;
			}
		}
		return current60;
	}
	
	private static String removeComma(String data) {
		return data.replaceAll("\\,", "");
	}
}
