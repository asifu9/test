package com.code.game.domain.experience;

import com.code.game.domain.GameEngine;
import com.code.game.entity.GamePlayer;

/**
 * The Class CounterStrikeScore.
 */
public class CounterStrikeExperience extends DefaultExperience{

	/** The game engine. */
	private GameEngine gameEngine;
	
	/**
	 * Instantiates a new counter strike score.
	 *
	 * @param gameEngine the game engine
	 */
	public CounterStrikeExperience(GameEngine gameEngine) {
		super(gameEngine);
		this.gameEngine = gameEngine;
	}

	/* (non-Javadoc)
	 * @see com.code.game.domain.DefaultExperience#calculateExperience(com.code.game.entity.GamePlayer)
	 */
	@Override
	public void calculateExperience(GamePlayer player) throws Exception{
		this.gameEngine.getGameInstanceService().updateExperience(player.getAvatar().getId(), 0.3f);
	}

	
}
