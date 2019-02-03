package com.code.game.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.game.domain.GameEngine;
import com.code.game.entity.GameInstance;
import com.code.game.service.GameService;

/**
 * A factory for creating GameEngine objects.
 */
@Service
public class GameEngineFactory {

	
	/** The Role Playing Game factory. */
	@Autowired
	private RolePlayingGameFactory rolePlayingGameFactory;
	
	/**
	 * Gets the game engine.
	 *
	 * @param gameInstance the game instance
	 * @return the game engine
	 * @throws Exception the exception
	 */
	public  GameEngine getGameEngine(GameInstance gameInstance) throws Exception{
		switch(gameInstance.getGame().getGameType()){
		
			case ROLE_PLAYING:
				return rolePlayingGameFactory.getGameEngine(gameInstance);
				
			default:
				throw new Exception ("Game Map not found");
		}
	}
}
