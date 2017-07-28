package com.capgemini.chess.dataaccess;

public class UserStatisticsEntity {

		private Long id;
		private Long userid;
		private long scoreSum;
		private int level;
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
