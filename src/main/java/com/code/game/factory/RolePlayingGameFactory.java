package com.code.game.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.game.domain.CounterStrike;
import com.code.game.domain.RolePlayingGame;
import com.code.game.domain.experience.CounterStrikeExperience;
import com.code.game.entity.Game;
import com.code.game.entity.GameInstance;
import com.code.game.service.GameInstanceService;
import com.code.game.service.GameService;
import com.code.game.service.PlayAreaService;

/**
 * A factory for creating Role Playing Game Factory objects.
 */
@Service
public class RolePlayingGameFactory {

	/** The game service. */
	@Autowired
	private GameService gameService;
	
	/** The game map service. */
	@Autowired
	private PlayAreaService gameMapService;
	
	/** The game factory service. */
	@Autowired
	private PlayAreaFactoryService gameFactoryService;

	/** The game instance service. */
	@Autowired
	private GameInstanceService gameInstanceService;
	
	/**
	 * Gets the game engine for given game instance.
	 *
	 * @param gameInstance the game instance
	 * @return the game engine
	 * @throws Exception the exception
	 */
	public  RolePlayingGame getGameEngine(GameInstance gameInstance) throws Exception{
		RolePlayingGame gameEngine=null;

		switch(gameInstance.getGame().getName()){
		
			case "CounterStrike":
				gameEngine = new CounterStrike(gameInstance,
									gameFactoryService.getPlayAreaInstance(gameInstance.getPlayArea().getName(),gameInstance),
									gameInstanceService);
				gameEngine.setScoreCalculator(new CounterStrikeExperience(gameEngine));
				return gameEngine;
				
			default:
				throw new Exception ("Game not found");
		}
	}
}
