package com.sun.scrapper;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.model.News;

public class MainNewsScrapper {
	
	public static ArrayList getNewsList() throws IOException {
		
		ArrayList<News> mainNewsList = new ArrayList<News>();
		
		String url = "https://finance.naver.com/news/mainnews.nhn";
		
		Document doc = Jsoup.connect(url).get();
		
		Elements elements = doc.select(".block1");
		
		for(Element element : elements) {
			News news = new News(element.select("a").text(), "https://finance.naver.com/"+element.select("a").attr("href"), element.select(".press").text(), element.select(".wdate").text());
			mainNewsList.add(news);
		}
		return mainNewsList;
	}

}
