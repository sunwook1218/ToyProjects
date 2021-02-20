package com.sun.scrapper;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.model.News;

public class NewsScrapper {
	
	public static ArrayList getNewsList(String code) throws IOException {
		
		ArrayList currentNewsList = new ArrayList();
		
		String url = "https://finance.naver.com/item/news_news.nhn?code=" + code;
		
		Document doc = Jsoup.connect(url).get();
		
		Elements elements = doc.select("table tr");
		
		int idx = 0;
		
		for(Element element : elements ) {
			if(!element.select("a").text().contains("관련뉴스")) {
				News news = new News(element.select("a").text(), "https://finance.naver.com" + element.select("a").attr("href"), element.select(".info").text(), element.select(".date").text());
				currentNewsList.add(news);
				idx++;
				if(idx >= 10) {
					break;
				}
			}
		}
		
		currentNewsList.remove(0);
		
		return currentNewsList;
	}

}
