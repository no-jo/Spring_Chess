package com.capgemini.chess.to;

public class UserStatisticsTO {

	private Long id;
	private Long userid;
	private long scoreSum;
	private int level;
	private int wins;
	private int loses;
	private int draws;

	public UserStatisticsTO(Long ID, Long user, long score, int level, int w, int l, int d) {
		id = ID;
		userid = user;
		scoreSum = score;
		this.level = level;
		wins = w;
		loses = l;
		draws = d;
	}

	public UserStatisticsTO() {
	};

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

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}
}
