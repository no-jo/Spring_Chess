package com.capgemini.chess.service.to;

public class UserRankingTO {

	private Long id;
	private long scoreSum;
	private int level;
	private long position;
	private int wins;
	private int loses;
	private int draws;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCurrentScoreSum() {
		return scoreSum;
	}
	public void setCurrentScoreSum(long currentScoreSum) {
		this.scoreSum = currentScoreSum;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public long getPosition() {
		return position;
	}
	public void setPosition(long position) {
		this.position = position;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getLoses() {
		return loses;
	}
	public void setLoses(int loses) {
		this.loses = loses;
	}
	public int getDraws() {
		return draws;
	}
	public void setDraws(int draws) {
		this.draws = draws;
	}
	
}
