package com.code.game.domain;

/**
 * The Interface IUserAction.
 */
public interface IUserAction {


	/**
	 * Start game.
	 *
	 * @throws Exception the exception
	 */
	void startGame();
	
	/**
	 * Pause game.
	 *
	 * @throws Exception the exception
	 */
	void pauseGame();
	
	/**
	 * Resume game.
	 *
	 * @throws Exception the exception
	 */
	void resumeGame();
	
	/**
	 * Stop game.
	 *
	 * @throws Exception the exception
	 */
	void stopGame();
}
