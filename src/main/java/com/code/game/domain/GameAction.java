package com.code.game.domain;

import java.util.Observable;
import java.util.Observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.code.game.domain.thread.GameStatusData;
import com.code.game.domain.thread.GameThread;
import com.code.game.entity.GamePlayer;
import com.code.game.enums.GameStatus;

// TODO: Auto-generated Javadoc
/**
 * The Class GameAction.
 */
public abstract class GameAction implements IUserAction, Observer {

	/** The game engine. */
	private GameEngine gameEngine;

	/** The player. */
	private GamePlayer player;

	/** The game thread. */
	private GameThread gameThread;

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(GameAction.class);

	/**
	 * Instantiates a new user action.
	 *
	 * @param gameEngine
	 *            the game engine
	 * @param player
	 *            the player
	 * @param gameThread
	 *            the game thread
	 */
	public GameAction(GameEngine gameEngine, GamePlayer player, GameThread gameThread) {
		this.gameEngine = gameEngine;
		this.player = player;
		this.gameThread = gameThread;
		this.gameThread.addObserver(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.code.game.domain.IUserAction#startGame()
	 */
	@Override
	public void startGame() {
		try {
			gameEngine.getGameInstanceService().updateStatus(gameEngine.getGameInstance().getId(), GameStatus.RUNNING);
			gameEngine.getGameInstanceService().updatePlayerStatus(player.getId(), GameStatus.RUNNING);
			this.gameThread.start();
		} catch (Exception ex) {
			LOGGER.error("Error while starting the game id {} error: {}", gameEngine.getGameInstance().getGame().getId(), ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.code.game.domain.IUserAction#pauseGame()
	 */
	@Override
	public void pauseGame() {
		try {
			gameEngine.getGameInstanceService().updateStatus(gameEngine.getGameInstance().getId(), GameStatus.PAUSED);
			gameEngine.getGameInstanceService().updatePlayerStatus(player.getId(), GameStatus.PAUSED);
			this.gameThread.suspend();
		} catch (Exception ex) {
			LOGGER.error("Error while pausing the game id {} error: {}", gameEngine.getGameInstance().getGame().getId(), ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.code.game.domain.IUserAction#resumeGame()
	 */
	@Override
	public void resumeGame() {
		try {
			gameEngine.getGameInstanceService().updateStatus(gameEngine.getGameInstance().getId(), GameStatus.RUNNING);
			gameEngine.getGameInstanceService().updatePlayerStatus(player.getId(), GameStatus.RUNNING);
			this.gameThread.resume();
		} catch (Exception ex) {
			LOGGER.error("Error while resuming the game id {} error {} ", gameEngine.getGameInstance().getGame().getId(), ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.code.game.domain.IUserAction#stopGame()
	 */
	@Override
	public void stopGame() {
		try {
			gameEngine.getGameInstanceService().updateStatus(gameEngine.getGameInstance().getId(), GameStatus.CANCELED);
			gameEngine.getGameInstanceService().updatePlayerStatus(player.getId(), GameStatus.CANCELED);
			this.gameThread.deleteObservers();
			this.gameThread = null;
		} catch (Exception ex) {
			LOGGER.error("Error while stopping the game id {} error: {} ", gameEngine.getGameInstance().getGame().getId(),
					ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object d) {

		GameStatusData data = (GameStatusData) d;
		switch (data.getStatusType()) {
		case POSITION:
			player.setSavedState(Integer.parseInt(data.getData().toString()));
			break;
		case SCORE:
			player.setScore(Integer.parseInt(data.getData().toString()));
			break;
		case STATUS:
			player.setStatus(GameStatus.getValue(data.getData().toString()));
			break;

		}
		try {
			gameEngine.getGameInstanceService().update(gameEngine.getGameInstance().getId(),
					gameEngine.getGameInstance());

			if (player.getStatus() == GameStatus.END) {
				// update the avatar with the latest score and number of games
				// played
				gameEngine.getGameInstanceService().updateAvatar(player.getAvatar().getId(), player.getScore());
				//update the experience
				gameEngine.getScoreCalculator().calculateExperience(player);
				// gameInstance status to END
				gameEngine.getGameInstanceService().updateStatusOnEnd(gameEngine.getGameInstance().getId());

			}
		} catch (Exception e) {
			LOGGER.error("Error while updating the updated game status/data {}", e.getMessage());
		}
	}

	/**
	 * Gets the game engine.
	 *
	 * @return the game engine
	 */
	public GameEngine getGameEngine() {
		return gameEngine;
	}

	/**
	 * Sets the game engine.
	 *
	 * @param gameEngine the new game engine
	 */
	public void setGameEngine(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
	}

	/**
	 * Gets the player.
	 *
	 * @return the player
	 */
	public GamePlayer getPlayer() {
		return player;
	}

	/**
	 * Sets the player.
	 *
	 * @param player the new player
	 */
	public void setPlayer(GamePlayer player) {
		this.player = player;
	}

	/**
	 * Gets the game thread.
	 *
	 * @return the game thread
	 */
	public GameThread getGameThread() {
		return gameThread;
	}

	/**
	 * Sets the game thread.
	 *
	 * @param gameThread the new game thread
	 */
	public void setGameThread(GameThread gameThread) {
		this.gameThread = gameThread;
	}
	
}
