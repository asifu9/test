package com.code.game.domain.thread;

import com.code.game.domain.GameEngine;
import com.code.game.domain.experience.IExperience;
import com.code.game.entity.GamePlayer;

/**
 * The Class represent implementation of role playing game for Counter Strike.
 */
public class CounterStrikeGameThread extends RolePlayingGameThread{

	/**
	 * Instantiates a new counter strike game thread.
	 *
	 * @param name the name
	 * @param gamePlayer the game player
	 * @param gameEngine the game engine
	 */
	public CounterStrikeGameThread(String name,GamePlayer gamePlayer,GameEngine gameEngine) {
		super(name,gamePlayer,gameEngine);
	}
	
}
