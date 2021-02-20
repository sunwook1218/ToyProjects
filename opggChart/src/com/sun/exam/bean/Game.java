package com.sun.exam.bean;

public class Game {

	private String gameId;
	private String platformId;
	private String gameCreation;
	private String gameDuration;
	private String queueId;
	private String mapId;
	private String seasonId;
	private String gameVersion;
	private String gameMode;
	private String gameType;
	private String teams;
	private String participants;
	private String participantIdentities;

	@Override
	public String toString() {
		return "Game [gameId=" + gameId + ", platformId=" + platformId + ", gameCreation=" + gameCreation
				+ ", gameDuration=" + gameDuration + ", queueId=" + queueId + ", mapId=" + mapId + ", seasonId="
				+ seasonId + ", gameVersion=" + gameVersion + ", gameMode=" + gameMode + ", gameType=" + gameType
				+ ", teams=" + teams + ", participants=" + participants + ", participantIdentities="
				+ participantIdentities + "]";
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public String getGameCreation() {
		return gameCreation;
	}

	public void setGameCreation(String gameCreation) {
		this.gameCreation = gameCreation;
	}

	public String getGameDuration() {
		return gameDuration;
	}

	public void setGameDuration(String gameDuration) {
		this.gameDuration = gameDuration;
	}

	public String getQueueId() {
		return queueId;
	}

	public void setQueueId(String queueId) {
		this.queueId = queueId;
	}

	public String getMapId() {
		return mapId;
	}

	public void setMapId(String mapId) {
		this.mapId = mapId;
	}

	public String getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(String seasonId) {
		this.seasonId = seasonId;
	}

	public String getGameVersion() {
		return gameVersion;
	}

	public void setGameVersion(String gameVersion) {
		this.gameVersion = gameVersion;
	}

	public String getGameMode() {
		return gameMode;
	}

	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public String getTeams() {
		return teams;
	}

	public void setTeams(String teams) {
		this.teams = teams;
	}

	public String getParticipants() {
		return participants;
	}

	public void setParticipants(String participants) {
		this.participants = participants;
	}

	public String getParticipantIdentities() {
		return participantIdentities;
	}

	public void setParticipantIdentities(String participantIdentities) {
		this.participantIdentities = participantIdentities;
	}

}
