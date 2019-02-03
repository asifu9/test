package com.code.game.factory;

import org.springframework.stereotype.Service;

import com.code.game.domain.playarea.CounterStrikePlayArea;
import com.code.game.domain.playarea.IPlayArea;
import com.code.game.entity.GameInstance;

/**
 * The Class MapFactoryService.
 */
@Service
public class PlayAreaFactoryService {
	
	/**
	 * Gets the map object.
	 *
	 * @param mapName the map name
	 * @param instance the instance
	 * @return the map object
	 * @throws Exception the exception
	 */
	public IPlayArea getPlayAreaInstance(String mapName,GameInstance instance) throws Exception{
		switch(mapName){
		
			case "CounterStrike": 
				return new  CounterStrikePlayArea(instance);
				
			default :
				throw new Exception("Play area not found for type " + mapName);
		}
		
	}
}
