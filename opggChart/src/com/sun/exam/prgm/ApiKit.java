package com.sun.exam.prgm;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.sun.exam.bean.Game;
import com.sun.exam.bean.Matches;
import com.sun.exam.bean.Summoner;

public class ApiKit {

	private static ApiKit apiKit;

	public static ApiKit getInstance() {
		if (apiKit == null) {
			return new ApiKit();
		}
		return apiKit;
	}

	private static final String api_key = "?api_key="; // KEY 삭제

	private static final String summoner_info_url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"; // need
																														// {summonerNameStr}
	private static final String match_list_info_url = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/"; // need
																															// {encryptedSummonerId}
	private static final String game_info_url = "https://kr.api.riotgames.com/lol/match/v4/matches/"; // need {gameId}

	private static Gson gson = new Gson();

	public Summoner getSummonerByName(String name) {

		String q_url = summoner_info_url + name + api_key;

		try {
			Document doc = Jsoup.connect(q_url).ignoreContentType(true).get();
			Elements elements = doc.select("body");

			return gson.fromJson(elements.text(), Summoner.class);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

	public Matches getMachesBySummonerAccountId(String accountId) {

		String q_url = match_list_info_url + accountId + api_key;

		try {
			Document doc = Jsoup.connect(q_url).ignoreContentType(true).get();
			Elements elements = doc.select("body");

			return gson.fromJson(elements.text(), Matches.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String getGameByGameId(String gameId) {

		String q_url = game_info_url + gameId + api_key;
		try {
			Document doc = Jsoup.connect(q_url).ignoreContentType(true).get();
			Elements elements = doc.select("body");

			return elements.text();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
