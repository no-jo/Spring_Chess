package com.capgemini.chess.to;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.dataaccess.UserStatisticsEntity;

public class UserStatisticsMapper {

	public static UserStatisticsTO map(UserStatisticsEntity statEntity) {
		if (statEntity != null) {
			UserStatisticsTO statsTO = new UserStatisticsTO();
			statsTO.setId(statEntity.getId());
			statsTO.setUserid(statEntity.getUserid());
			statsTO.setCurrentScoreSum(statEntity.getCurrentScoreSum());
			statsTO.setLevel(statEntity.getLevel());
			statsTO.setWins(statEntity.getWins());
			statsTO.setLoses(statEntity.getLoses());
			statsTO.setDraws(statEntity.getLoses());
			return statsTO;
		}
		return null;
	}
	
	public static UserStatisticsEntity map(UserStatisticsTO statTO) {
		if (statTO != null) {
			UserStatisticsEntity statEntity = new UserStatisticsEntity();
			statEntity.setId(statTO.getId());
			statEntity.setUserid(statTO.getUserid());
			statEntity.setCurrentScoreSum(statTO.getCurrentScoreSum());
			statEntity.setLevel(statTO.getLevel());
			statEntity.setWins(statTO.getWins());
			statEntity.setLoses(statTO.getLoses());
			statEntity.setDraws(statTO.getLoses());
			return statEntity;
		}
		return null;
	}
	
	public static List<UserStatisticsTO> map2TOs(List<UserStatisticsEntity> userEntities) {
		return userEntities.stream().map(UserStatisticsMapper::map).collect(Collectors.toList());
	}

	public static List<UserStatisticsEntity> map2Entities(List<UserStatisticsTO> userTOs) {
		return userTOs.stream().map(UserStatisticsMapper::map).collect(Collectors.toList());
	}
	
}
