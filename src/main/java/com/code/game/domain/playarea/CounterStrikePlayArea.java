package com.code.game.domain.playarea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.code.game.entity.GameInstance;

/**
 * The Class MapCounterStrike.
 * This class represent to map for Counter strike game
 */
public class CounterStrikePlayArea implements IPlayArea {

	/** The game instance. */
	@SuppressWarnings("unused")
	private GameInstance gameInstance;
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(CounterStrikePlayArea.class);
	
	/**
	 * Instantiates a new counter strike play area.
	 *
	 * @param gameInstance the game instance
	 */
	public CounterStrikePlayArea(GameInstance gameInstance) {
		super();
		this.gameInstance = gameInstance;
	}


	/* (non-Javadoc)
	 * @see com.code.game.domain.IMapExplorer#explore(int, java.lang.Runnable)
	 */
	@Override
	public void explore(int explorePoint) {
		//explore the map here
		LOGGER.info("Exploring at the position {} " ,explorePoint);
	}

}
