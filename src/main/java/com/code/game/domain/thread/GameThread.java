package com.code.game.domain.thread;

import java.util.Observable;

/**
 * The Interface IGameThread.
 */
public abstract class GameThread extends Observable implements Runnable{


	/**
	 * Start.
	 */
	public abstract void start();
	
	/**
	 * Suspend.
	 */
	public abstract void suspend();
	
	/**
	 * Resume.
	 */
	public abstract void resume();
	
	/**
	 * Sets the game length.
	 *
	 * @param length the new game length
	 */
	public abstract void setGameLength(int length);

}
