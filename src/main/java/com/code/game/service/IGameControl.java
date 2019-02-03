package com.code.game.service;

import com.code.game.enums.MoveAction;
import com.code.game.enums.UserAction;

/**
 * The Interface IGame.
 * This interface represent games basic actions
 * 
 */
public interface IGameControl {


	/**
	 * User Move Action.
	 *
	 * @param playerId the player id
	 * @param moveAction the move action
	 * @throws Exception the exception
	 */
	void move(int playerId,MoveAction moveAction) throws Exception;
	
	/**
	 * User action .
	 *
	 * @param playerId the player id
	 * @param userAction the user action
	 * @throws Exception the exception
	 */
	void action(int playerId,UserAction userAction) throws Exception;
}
