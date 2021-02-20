package com.sun.exam.prgm;

import java.io.IOException;

import com.sun.exam.bean.Match;
import com.sun.exam.bean.Matches;
import com.sun.exam.bean.Summoner;

public class MyProgram {

	private static ApiKit apiKit = ApiKit.getInstance();

	public void run(String user) throws IOException {

		Summoner smnr = apiKit.getSummonerByName(user);

		Matches matches = apiKit.getMachesBySummonerAccountId(smnr.getAccountId());

		Match match = matches.getMatches().get(0);

		String game = apiKit.getGameByGameId(match.getGameId());
		
		System.out.println(game);

	}

}
