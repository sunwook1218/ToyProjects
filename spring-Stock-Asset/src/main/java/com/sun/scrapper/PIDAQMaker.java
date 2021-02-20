package com.sun.scrapper;

import java.io.IOException;
import java.util.ArrayList;

import com.sun.model.PIDAQ;

public class PIDAQMaker {

	public static ArrayList<PIDAQ> get60() throws IOException {

		ArrayList<String> kosdaq = CurrentKOSDAQ60Scrapper.get60();

		ArrayList<String> kospi = CurrentKOSPI60Scrapper.get60();

		ArrayList<PIDAQ> result = new ArrayList();

		for (int i = 0; i < kospi.size(); i++) {
			PIDAQ pidaq = new PIDAQ(kospi.get(i), kosdaq.get(i));
			result.add(pidaq);
		}
		return result;
	}

}
