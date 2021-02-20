package com.sun.scrapper;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.model.Stock;

public class PopularScrapper {
	
	public static ArrayList getPopStocks() throws IOException {
				
		ArrayList pop30 = new ArrayList();
		
		String url = "https://finance.naver.com/sise/lastsearch2.nhn";
		
		Document doc = Jsoup.connect(url).get();
		
		Elements elements = doc.select("tbody a");
		
		for(Element element : elements) {
			Stock stock = new Stock(element.html(), element.attr("href").substring(20), "");
			pop30.add(stock);
		}
		
		return pop30;
	}

}
