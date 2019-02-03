package com.code.game.domain.thread;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.code.game.domain.GameEngine;
import com.code.game.domain.experience.IExperience;
import com.code.game.entity.GamePlayer;
import com.code.game.enums.EmitStatusType;
import com.code.game.enums.GameStatus;
import com.code.game.enums.MoveAction;
import com.code.game.enums.UserAction;

/**
 * The Class GameThread.
 */
public class RolePlayingGameThread extends GameThread {

	/** The t. */
	public Thread t;

	/** The thread name. */
	private String threadName;

	/** The suspended. */
	boolean suspended = false;

	/** The game length. */
	private int gameLength = 20;

	/** The game engine. */
	private GameEngine gameEngine;
	
	private GamePlayer player;
	
	private double experience=1;
	
	//protected IExperience scoreCalculator;

	/** The start. */
	private int start = 0;

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(RolePlayingGameThread.class);

	/**
	 * Instantiates a new game thread.
	 *
	 * @param name
	 *            the name
	 * @param gamePlayer
	 *            the game player
	 * @param gameEngine
	 *            the game engine
	 */
	public RolePlayingGameThread(String name, GamePlayer gamePlayer, GameEngine gameEngine) {
		threadName = name;
		start = gamePlayer.getSavedState();
		this.gameEngine = gameEngine;
		this.player = gamePlayer;
		this.gameLength = gameEngine.getGameInstance().getPlayArea().getGameLength();
		this.experience  = gamePlayer.getAvatar().getExperience();
		//this.scoreCalculator = score;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		try {
			double i=start;
			while ( i  <= gameLength) {
				LOGGER.info("Thread: " + threadName + ", exploring at position " + i + " of which length " + gameLength);
				gameEngine.getPlayArea().explore((int)i);

				// just invoke some actions
				UserAction action = UserAction.values()[new Random().nextInt(UserAction.values().length)];
				gameEngine.action(player.getAvatar().getId(),action);

				MoveAction moveAction = MoveAction.values()[new Random().nextInt(MoveAction.values().length)];
				gameEngine.move(player.getAvatar().getId(),moveAction);

				// lets save each position state in DB
				setChanged();
				notifyObservers(new GameStatusData(EmitStatusType.POSITION, (int)i));

				// Let the thread sleep for a while.
				Thread.sleep(3000);
				synchronized (this) {
					while (suspended) {
						wait();
					}
				}
				i=i+(1*experience);
			}
			setChanged();
			notifyObservers(new GameStatusData(EmitStatusType.SCORE, gameEngine.getGameInstance().getPlayArea().getMaxScore()));
			setChanged();
			notifyObservers(new GameStatusData(EmitStatusType.STATUS, "END"));
			gameEngine.getGameInstance().setStatus(GameStatus.END);
			LOGGER.info("Game is finished... thanks");
		} catch (Exception e) {
			LOGGER.error("Error occurred while exploring for Thread {} interrupted: error {}", threadName, e);
		}
	}

	/**
	 * Start.
	 */
	@Override
	public void start() {
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

	/**
	 * Suspend.
	 */
	@Override
	public void suspend() {
		suspended = true;
	}

	/**
	 * Resume.
	 */
	@Override
	public synchronized void resume() {
		suspended = false;
		notify();
	}

	/**
	 * Gets the game length.
	 *
	 * @return the game length
	 */
	public int getGameLength() {
		return gameLength;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.code.game.thread.GameThread#setGameLength(int)
	 */
	@Override
	public void setGameLength(int gameLength) {
		this.gameLength = gameLength;
	}

}