package com.code.game.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.code.game.domain.experience.CounterStrikeExperience;
import com.code.game.domain.experience.DefaultExperience;
import com.code.game.domain.playarea.IPlayArea;
import com.code.game.entity.GameInstance;
import com.code.game.enums.MoveAction;
import com.code.game.enums.UserAction;
import com.code.game.service.GameInstanceService;

/**
 * Class represent Counter Strick game implementation.
 * If you need to changes the behaviour, then override the methods here
 * or extend this class and override the same.
 *
 */
public class CounterStrike extends RolePlayingGame {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(CounterStrike.class);

	
	
	/**
	 * Instantiates a new counter strike.
	 *
	 * @param gameInstance the game instance
	 * @param playArea the play area
	 * @param gameInstanceService the game instance service
	 */
	public CounterStrike(GameInstance gameInstance,IPlayArea playArea,GameInstanceService gameInstanceService) {
		super(gameInstance,playArea,gameInstanceService);
		this.setScoreCalculator(new CounterStrikeExperience(this));
		logger.info("Initializing counter strike game....");
	}
	
	/* (non-Javadoc)
	 * @see com.code.game.domain.RolePlayingGame#move(com.code.game.enums.MoveAction)
	 */
	@Override
	public void move(int playerId,MoveAction action) throws Exception {
		
		logger.info("Move: {} Action invoked for user {} command ",action,playerId);
	}

	/* (non-Javadoc)
	 * @see com.code.game.domain.RolePlayingGame#action(com.code.game.enums.UserAction)
	 */
	@Override
	public void action(int playerId,UserAction userAction) throws Exception {
		
		logger.info("Action: {} Action invoked for user {} command ",userAction,playerId);
		
	}
}
