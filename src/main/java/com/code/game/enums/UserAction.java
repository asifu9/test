package com.code.game.enums;


/**
 * The Enum represent User Actions.
 */
public enum UserAction {


	/** The punch. */
	PUNCH,

	/** The kick. */
	KICK,
	
	/** The shoot. */
	SHOOT,
	
	/** The aim. */
	AIM,
	
	/** The pick. */
	PICK,
	
	/** The throw. */
	THROW;
	
	/**
	 * Gets the value.
	 *
	 * @param type the type
	 * @return the value
	 */
	public static UserAction getValue(String type){
		UserAction status=null;
		switch (type.toLowerCase()){
			case "punch":
				status= UserAction.PUNCH;
				break;
			case "kick":
				status= UserAction.KICK;
				break;
			case "shoot":
				status= UserAction.SHOOT;
				break;
			case "aim":
				status= UserAction.AIM;
				break;
			case "PICK":
				status= UserAction.PICK;
				break;
			case "THROW":
				status= UserAction.THROW;
				break;
				
		}
		return status;
	}
	
}
