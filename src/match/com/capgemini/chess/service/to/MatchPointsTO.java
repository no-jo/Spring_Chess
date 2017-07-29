package com.capgemini.chess.service.to;

import com.capgemini.chess.enums.MatchResult;

public class MatchPointsTO {

	private Long userID;
	private long scoreIncrement;
	private MatchResult result;

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public long getScoreIncrement() {
		return scoreIncrement;
	}

	public void setScoreIncrement(long scoreIncrement) {
		this.scoreIncrement = scoreIncrement;
	}

	public MatchResult getResult() {
		return result;
	}

	public void setResult(MatchResult result) {
		this.result = result;
	}

}
