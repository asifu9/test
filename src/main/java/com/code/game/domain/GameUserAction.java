package com.code.game.domain;

import com.code.game.domain.thread.GameThread;
import com.code.game.entity.GamePlayer;

/**
 * The Class GameUserAction.
 */
public class GameUserAction extends GameAction{

	/**
	 * Instantiates a new game user action.
	 *
	 * @param gameEngine the game engine
	 * @param player the player
	 * @param gameThread the game thread
	 */
	public GameUserAction(GameEngine gameEngine,GamePlayer player,GameThread gameThread) {
		super(gameEngine,player,gameThread);
	}

}
