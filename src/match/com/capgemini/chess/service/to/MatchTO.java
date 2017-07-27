package com.capgemini.chess.service.to;

import java.time.LocalDate;

import com.capgemini.chess.enums.MatchStatus;

public class MatchTO {
	
	LocalDate date;
	Long playerID;
	Long opponentID;
	int playerScore;
	int opponentScore;
	Long matchID;
	MatchStatus status;
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Long getPlayerID() {
		return playerID;
	}
	public void setPlayerID(Long playerID) {
		this.playerID = playerID;
	}
	public Long getOpponentID() {
		return opponentID;
	}
	public void setOpponentID(Long opponentID) {
		this.opponentID = opponentID;
	}
	public int getPlayerScore() {
		return playerScore;
	}
	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}
	public int getOpponentScore() {
		return opponentScore;
	}
	public void setOpponentScore(int opponentScore) {
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
	
}
