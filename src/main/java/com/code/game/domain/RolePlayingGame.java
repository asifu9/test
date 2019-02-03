package com.code.game.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.code.game.api.GameInstanceApi;
import com.code.game.domain.playarea.IPlayArea;
import com.code.game.entity.GameInstance;
import com.code.game.enums.MoveAction;
import com.code.game.enums.UserAction;
import com.code.game.service.GameInstanceService;

/**
 * The Class FirstPersonShoot. This is an abstract class 
 * which represents base for All Role Based Games
 */
public class RolePlayingGame extends GameEngine {

	
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(GameInstanceApi.class);
	

	/**
	 * Instantiates a new role playing game.
	 *
	 * @param gameInstance the game instance
	 * @param playArea the play area
	 * @param gameInstanceService the game instance service
	 */
	public RolePlayingGame(GameInstance gameInstance,IPlayArea playArea,GameInstanceService gameInstanceService) {
		super(gameInstance,playArea,gameInstanceService);
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.IGame#move(com.code.game.enums.MoveAction)
	 */
	@Override
	public void move(int playerId,MoveAction action) throws Exception {
		LOGGER.info("default implementation of move method for role playing games");
		
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.IGame#action(com.code.game.enums.UserAction)
	 */
	@Override
	public void action(int userId,UserAction userAction) throws Exception {
		LOGGER.info("default implementation of action method for role playing games");
		
	}


}
