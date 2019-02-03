package com.code.game.domain;

import java.util.List;

import com.code.game.domain.experience.IExperience;
import com.code.game.domain.playarea.IPlayArea;
import com.code.game.entity.GameInstance;
import com.code.game.service.GameInstanceService;
import com.code.game.service.IGameControl;

// TODO: Auto-generated Javadoc
/**
 * The Class GameEngine.
 * Abstract class to build a game object
 * which contains all the required data.
 */
public abstract class GameEngine implements IGameControl {
	
	/** The game instace. */
	private GameInstance gameInstance;
	
	/** The map. */
	IPlayArea playArea;
	
	/** The game instance service. */
	private GameInstanceService gameInstanceService;
	
	/** The users. */
	protected List<GameAction> users;
	
	/** The score calculator. */
	private IExperience scoreCalculator;

	/**
	 * Instantiates a new game engine.
	 *
	 * @param gameInstance the game instance
	 * @param playArea the play area
	 * @param gameInstanceService the game instance service
	 */
	public GameEngine(GameInstance gameInstance,IPlayArea playArea,GameInstanceService gameInstanceService) {
		this.gameInstance=gameInstance;
		this.playArea=playArea;
		this.gameInstanceService=gameInstanceService;
		
	}


	/**
	 * Gets the game instance.
	 *
	 * @return the game instance
	 */
	public GameInstance getGameInstance() {
		return gameInstance;
	}

	/**
	 * Gets the game instance service.
	 *
	 * @return the game instance service
	 */
	public GameInstanceService getGameInstanceService() {
		return gameInstanceService;
	}


	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	public List<GameAction> getUsers() {
		return users;
	}


	/**
	 * Sets the users.
	 *
	 * @param users the new users
	 */
	public void setUsers(List<GameAction> users) {
		this.users = users;
	}


	/**
	 * Gets the play area.
	 *
	 * @return the play area
	 */
	public IPlayArea getPlayArea() {
		return playArea;
	}


	/**
	 * Sets the play area.
	 *
	 * @param playArea the new play area
	 */
	public void setPlayArea(IPlayArea playArea) {
		this.playArea = playArea;
	}


	/**
	 * Sets the game instance.
	 *
	 * @param gameInstance the new game instance
	 */
	public void setGameInstance(GameInstance gameInstance) {
		this.gameInstance = gameInstance;
	}


	/**
	 * Sets the game instance service.
	 *
	 * @param gameInstanceService the new game instance service
	 */
	public void setGameInstanceService(GameInstanceService gameInstanceService) {
		this.gameInstanceService = gameInstanceService;
	}


	/**
	 * Gets the score calculator.
	 *
	 * @return the score calculator
	 */
	public IExperience getScoreCalculator() {
		return scoreCalculator;
	}


	/**
	 * Sets the score calculator.
	 *
	 * @param scoreCalculator the new score calculator
	 */
	public void setScoreCalculator(IExperience scoreCalculator) {
		this.scoreCalculator = scoreCalculator;
	}
	
}
