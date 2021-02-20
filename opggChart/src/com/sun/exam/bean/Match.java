package com.sun.exam.bean;

public class Match {

	private String platformId;
	private String gameId;
	private String champion;
	private String queue;
	private String season;
	private String timestamp;
	private String role;
	private String lane;

	@Override
	public String toString() {
		return "Match [platformId=" + platformId + ", gameId=" + gameId + ", champion=" + champion + ", queue=" + queue
				+ ", season=" + season + ", timestamp=" + timestamp + ", role=" + role + ", lane=" + lane + "]";
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getChampion() {
		return champion;
	}

	public void setChampion(String champion) {
		this.champion = champion;
	}

	public String getQueue() {
		return queue;
	}

	public void setQueue(String queue) {
		this.queue = queue;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

}
