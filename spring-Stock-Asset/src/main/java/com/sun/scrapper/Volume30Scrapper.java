package com.sun.scrapper;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.model.Stock;

public class Volume30Scrapper {

	public static ArrayList get30() throws IOException {

		ArrayList data = new ArrayList();

		String url = "https://finance.naver.com/sise/sise_quant.nhn";

		Document doc = Jsoup.connect(url).get();

		Elements elements = doc.select(".type_2 a");

		int idx = 0;

		for (Element element : elements) {
			idx++;
			if (idx > 30) {
				break;
			}
			Stock stock = new Stock(element.html(), element.attr("href").substring(20), "");
			data.add(stock);

		}

		return data;
	}

}
