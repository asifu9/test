package com.code.game.enums;

import java.util.HashMap;
import java.util.Map;

import com.code.game.domain.GameEngine;

/**
 * The Enum GameSessions.
 */
public enum GameSessions {

	/** The instance. */
	INSTANCE;
	
	/** The sessions. */
	private Map<Integer, GameEngine> sessions=new HashMap<>();
	
	/**
	 * Gets the game session.
	 *
	 * @param id the id
	 * @return the game session
	 */
	public GameEngine getGameSession(int id){
		return sessions.get(id);
	}
	
	/**
	 * Sets the session.
	 *
	 * @param id the id
	 * @param session the session
	 */
	public void setSession(int id,GameEngine session){
		 sessions.put(id,session);
	}
}
