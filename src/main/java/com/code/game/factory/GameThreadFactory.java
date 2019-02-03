package com.code.game.factory;

import org.springframework.stereotype.Service;

import com.code.game.domain.GameEngine;
import com.code.game.domain.experience.CounterStrikeExperience;
import com.code.game.domain.thread.CounterStrikeGameThread;
import com.code.game.domain.thread.GameThread;
import com.code.game.entity.GamePlayer;

/**
 * The Class MapFactoryService.
 */
@Service
public class GameThreadFactory {
	
	/**
	 * Gets the map object.
	 *
	 * @param mapName the map name
	 * @param instance the instance
	 * @return the map object
	 * @throws Exception the exception
	 */
	public GameThread getGameThreadInstance(String gameName,GamePlayer gamePlayer,GameEngine gameEngine) throws Exception{
		switch(gameName){
		
			case "CounterStrike": 
				return new  CounterStrikeGameThread("Counter strike game for user "+ gamePlayer.getAvatar().getId(),
							gamePlayer,
							gameEngine);//,new CounterStrikeExperience(gameEngine)
				
			default :
				throw new Exception("Play area not found for type " + gamePlayer);
		}
		
	}
}
