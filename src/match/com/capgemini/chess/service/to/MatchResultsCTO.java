package com.capgemini.chess.service.to;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.chess.enums.MatchStatus;

public class MatchResultsCTO {
	
	private LocalDate date;
	private Long challengerID;
	private Long opponentID;
	private Long matchID;
	private MatchStatus status;
	private List<MatchPointsTO> matchPoints;

	public MatchResultsCTO(MatchTO match, List<MatchPointsTO> results) {
		date = match.getDate();
		challengerID = match.getChallengerID();
		opponentID = match.getOpponentID();
		matchID = match.getMatchID();
		status = match.getStatus();
		matchPoints = results;
	}
	
	public MatchResultsCTO() {

	}

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

	public List<MatchPointsTO> getMatchPoints() {
		return matchPoints;
	}

	public void setMatchPoints(List<MatchPointsTO> match_points) {
		this.matchPoints = match_points;
	}
}
