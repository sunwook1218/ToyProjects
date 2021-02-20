package com.sun.exam.bean;

public class Temp {

	public static void main(String[] args) {
		
		String data = "\"participantId\":1,\r\n"
				+ "\"win\":false,\r\n"
				+ "\"item0\":3006,\r\n"
				+ "\"item1\":6671,\r\n"
				+ "\"item2\":3508,\r\n"
				+ "\"item3\":6676,\r\n"
				+ "\"item4\":3086,\r\n"
				+ "\"item5\":1042,\r\n"
				+ "\"item6\":2052,\r\n"
				+ "\"kills\":6,\r\n"
				+ "\"deaths\":9,\r\n"
				+ "\"assists\":19,\r\n"
				+ "\"largestKillingSpree\":3,\r\n"
				+ "\"largestMultiKill\":2,\r\n"
				+ "\"killingSprees\":2,\r\n"
				+ "\"longestTimeSpentLiving\":256,\r\n"
				+ "\"doubleKills\":1,\r\n"
				+ "\"tripleKills\":0,\r\n"
				+ "\"quadraKills\":0,\r\n"
				+ "\"pentaKills\":0,\r\n"
				+ "\"unrealKills\":0,\r\n"
				+ "\"totalDamageDealt\":95921,\r\n"
				+ "\"magicDamageDealt\":2453,\r\n"
				+ "\"physicalDamageDealt\":90447,\r\n"
				+ "\"trueDamageDealt\":3020,\r\n"
				+ "\"largestCriticalStrike\":996,\r\n"
				+ "\"totalDamageDealtToChampions\":17874,\r\n"
				+ "\"magicDamageDealtToChampions\":2093,\r\n"
				+ "\"physicalDamageDealtToChampions\":15335,\r\n"
				+ "\"trueDamageDealtToChampions\":445,\r\n"
				+ "\"totalHeal\":3919,\r\n"
				+ "\"totalUnitsHealed\":4,\r\n"
				+ "\"damageSelfMitigated\":9695,\r\n"
				+ "\"damageDealtToObjectives\":1271,\r\n"
				+ "\"damageDealtToTurrets\":1271,\r\n"
				+ "\"visionScore\":0,\r\n"
				+ "\"timeCCingOthers\":21,\r\n"
				+ "\"totalDamageTaken\":18264,\r\n"
				+ "\"magicalDamageTaken\":9828,\r\n"
				+ "\"physicalDamageTaken\":8076,\r\n"
				+ "\"trueDamageTaken\":358,\r\n"
				+ "\"goldEarned\":13813,\r\n"
				+ "\"goldSpent\":11850,\r\n"
				+ "\"turretKills\":1,\r\n"
				+ "\"inhibitorKills\":0,\r\n"
				+ "\"totalMinionsKilled\":106,\r\n"
				+ "\"neutralMinionsKilled\":0,\r\n"
				+ "\"totalTimeCrowdControlDealt\":47,\r\n"
				+ "\"champLevel\":17,\r\n"
				+ "\"visionWardsBoughtInGame\":0,\r\n"
				+ "\"sightWardsBoughtInGame\":0,\r\n"
				+ "\"firstBloodKill\":false,\r\n"
				+ "\"firstBloodAssist\":false,\r\n"
				+ "\"firstTowerKill\":true,\r\n"
				+ "\"firstTowerAssist\":false,\r\n"
				+ "\"firstInhibitorKill\":false,\r\n"
				+ "\"firstInhibitorAssist\":false,\r\n"
				+ "\"combatPlayerScore\":0,\r\n"
				+ "\"objectivePlayerScore\":0,\r\n"
				+ "\"totalPlayerScore\":0,\r\n"
				+ "\"totalScoreRank\":0,\r\n"
				+ "\"playerScore0\":0,\r\n"
				+ "\"playerScore1\":0,\r\n"
				+ "\"playerScore2\":0,\r\n"
				+ "\"playerScore3\":0,\r\n"
				+ "\"playerScore4\":0,\r\n"
				+ "\"playerScore5\":0,\r\n"
				+ "\"playerScore6\":0,\r\n"
				+ "\"playerScore7\":0,\r\n"
				+ "\"playerScore8\":0,\r\n"
				+ "\"playerScore9\":0,\r\n"
				+ "\"perk0\":8021,\r\n"
				+ "\"perk0Var1\":1503,\r\n"
				+ "\"perk0Var2\":0,\r\n"
				+ "\"perk0Var3\":0,\r\n"
				+ "\"perk1\":9111,\r\n"
				+ "\"perk1Var1\":348,\r\n"
				+ "\"perk1Var2\":250,\r\n"
				+ "\"perk1Var3\":0,\r\n"
				+ "\"perk2\":9104,\r\n"
				+ "\"perk2Var1\":2,\r\n"
				+ "\"perk2Var2\":50,\r\n"
				+ "\"perk2Var3\":0,\r\n"
				+ "\"perk3\":8014,\r\n"
				+ "\"perk3Var1\":588,\r\n"
				+ "\"perk3Var2\":0,\r\n"
				+ "\"perk3Var3\":0,\r\n"
				+ "\"perk4\":8106,\r\n"
				+ "\"perk4Var1\":5,\r\n"
				+ "\"perk4Var2\":0,\r\n"
				+ "\"perk4Var3\":0,\r\n"
				+ "\"perk5\":8139,\r\n"
				+ "\"perk5Var1\":1269,\r\n"
				+ "\"perk5Var2\":0,\r\n"
				+ "\"perk5Var3\":0,\r\n"
				+ "\"perkPrimaryStyle\":8000,\r\n"
				+ "\"perkSubStyle\":8100,\r\n"
				+ "\"statPerk0\":5005,\r\n"
				+ "\"statPerk1\":5008,\r\n"
				+ "\"statPerk2\":5002";
		
		String[] split = data.split("\"");
		
		for(String s : split) {
			if(!s.equals("")  && !s.contains(":")) {
				s = "private String " + s + ";";
				System.out.println(s);
			}
		}

		


		
	}

}
