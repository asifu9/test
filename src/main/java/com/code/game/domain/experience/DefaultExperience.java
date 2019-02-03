package com.code.game.domain.experience;

import com.code.game.domain.GameEngine;
import com.code.game.entity.GamePlayer;

/**
 * The Class DefaultExperience.
 */
public class DefaultExperience implements IExperience {

	/** The game engine. */
	private GameEngine gameEngine;
	
	/**
	 * Instantiates a new default experience.
	 *
	 * @param gameEngine the game engine
	 */
	public DefaultExperience(GameEngine gameEngine) {
		super();
		this.gameEngine = gameEngine;
	}

	/* (non-Javadoc)
	 * @see com.code.game.domain.score.IExperience#calculateExperience(com.code.game.entity.GamePlayer)
	 */
	@Override
	public void calculateExperience(GamePlayer gamePlayer) throws Exception {
		gameEngine.getGameInstanceService().updateExperience(gamePlayer.getAvatar().getId(),0.2f);
		
	}

	
}
