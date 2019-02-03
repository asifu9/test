package com.code.game.enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum represent User move action/direction
 */
public enum MoveAction {

	/** The right. */
	RIGHT,
	
	/** The left. */
	LEFT,
	
	/** The farward. */
	FARWARD,
	
	/** The backward. */
	BACKWARD,
	
	/** The jump. */
	JUMP,
	
	/** The walk. */
	WALK,
	
	/** The run. */
	RUN;
	
	/**
	 * Gets the value.
	 *
	 * @param type the type
	 * @return the value
	 */
	public static MoveAction getValue(String type){
		MoveAction status=null;
		switch (type.toLowerCase()){
			case "right":
				status= MoveAction.RIGHT;
				break;
			case "left":
				status= MoveAction.LEFT;
				break;
			case "backward":
				status= MoveAction.BACKWARD;
				break;
			case "farward":
				status= MoveAction.FARWARD;
				break;
			case "jump":
				status= MoveAction.JUMP;
				break;
			case "walk":
				status= MoveAction.WALK;
				break;
			case "run":
				status= MoveAction.RUN;
				break;
				
		}
		return status;
	}
}
