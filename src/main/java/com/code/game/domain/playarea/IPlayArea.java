package com.code.game.domain.playarea;

/**
 * The Interface IMapExplorer.
 * 
 */
public interface IPlayArea {

	/**
	 * Inits the method with default values
	 */
	public default void  init(){
	}
	
	/**
	 * This method can be overriden by all the maps,
	 * as name indicates, this method will help
	 * in exploring/traveling inside the map. 
	 *
	 * @param pausedAt the paused at
	 * @param thread the thread
	 */
	public void explore(int pausedAt);
	
	
	
}
