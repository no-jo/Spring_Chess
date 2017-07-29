package com.capgemini.chess.service.to;

import java.time.LocalDate;

import com.capgemini.chess.enums.MatchResult;
import com.capgemini.chess.enums.MatchStatus;

public class MatchTO {
	
	LocalDate date;
	Long challengerID;
	Long opponentID;
	MatchResult challengerResult;
	MatchResult opponentResult;
	Long matchID;
	MatchStatus status;
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Long getChallengerID() {
		return challengerID;
	}
	public void setChallengerID(Long playerID) {
		this.challengerID = playerID;
	}
	public Long getOpponentID() {
		return opponentID;
	}
	public void setOpponentID(Long opponentID) {
		this.opponentID = opponentID;
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
	public void setChallengerResult(MatchResult player) {
		this.challengerResult = player;
	}
	public MatchResult getOpponentResult() {
		return opponentResult;
	}
	public void setOpponentResult(MatchResult opponent) {
		this.opponentResult = opponent;
	}
	
}
