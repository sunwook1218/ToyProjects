package com.sun.scrapper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PriceScrapper {

	public static String getPrice(String code) throws IOException {

		String url = "https://finance.naver.com/item/main.nhn?code=" + code;

		Document doc = Jsoup.connect(url).get();

		Elements elements = doc.select(".today .blind");
		
		return elements.get(0).text();

	}
	
	public static String removeComma(String data) {
		return data.replaceAll("\\,", "");
	}

}
