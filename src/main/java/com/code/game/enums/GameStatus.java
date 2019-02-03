package com.code.game.enums;

/**
 * The Enum to represent Game status
 */
public enum GameStatus {
	
	/** The new. */
	NEW,
	
	/** The running. */
	RUNNING,
	
	/** The canceled. */
	CANCELED,
	
	/** The paused. */
	PAUSED,
	
	/** The end. */
	END;
	
	
	/**
	 * Gets the value.
	 *
	 * @param type the type
	 * @return the value
	 */
	public static GameStatus getValue(String type){
		GameStatus status=null;
		switch (type){
			case "NEW":
				status= GameStatus.NEW;
			case "RUNNING":
				status= GameStatus.RUNNING;
			case "CANCELED":
				status= GameStatus.CANCELED;
			case "PAUSED":
				status= GameStatus.PAUSED;
			case "END":
				status= GameStatus.END;
				
		}
		return status;
	}

	
	
}
