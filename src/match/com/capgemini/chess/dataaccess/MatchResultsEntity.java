package com.capgemini.chess.dataaccess;

import java.time.LocalDate;

import com.capgemini.chess.enums.MatchResult;
import com.capgemini.chess.enums.MatchStatus;

public class MatchResultsEntity {
	private LocalDate date;
	private Long challengerID;
	private Long opponentID;
	private long challengerScore;
	private long opponentScore;
	private Long matchID;
	private MatchStatus status;
	private MatchResult challengerResult;
	private MatchResult opponentResult;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Long getChallengerID() {
		return challengerID;
	}

	public void setChallengerID(Long challengerID) {
		this.challengerID = challengerID;
	}

	public Long getOpponentID() {
		return opponentID;
	}

	public void setOpponentID(Long opponentID) {
		this.opponentID = opponentID;
	}

	public long getChallengerScore() {
		return challengerScore;
	}

	public void setChallengerScore(long challengerScore) {
		this.challengerScore = challengerScore;
	}

	public long getOpponentScore() {
		return opponentScore;
	}

	public void setOpponentScore(long opponentScore) {
		this.opponentScore = opponentScore;
	}

	public Long getMatchID() {
		return matchID;
	}

	public void setMatchID(Long matchID) {
		this.matchID = matchID;
	}

	public MatchStatus getStatus() {
		return status;
	}

	public void setStatus(MatchStatus status) {
		this.status = status;
	}

	public MatchResult getChallengerResult() {
		return challengerResult;
	}

	public void setChallengerResult(MatchResult challengerResult) {
		this.challengerResult = challengerResult;
	}

	public MatchResult getOpponentResult() {
		return opponentResult;
	}

	public void setOpponentResult(MatchResult opponentResult) {
		this.opponentResult = opponentResult;
	}
}
