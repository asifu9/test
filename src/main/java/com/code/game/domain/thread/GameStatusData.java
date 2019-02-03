package com.code.game.domain.thread;

import com.code.game.enums.EmitStatusType;

/**
 * The Class GameStatusData.
 */
public class GameStatusData {
	
	/** The status type. */
	EmitStatusType statusType;
	
	/** The data. */
	Object data;
	
	/**
	 * Gets the status type.
	 *
	 * @return the status type
	 */
	public EmitStatusType getStatusType() {
		return statusType;
	}
	
	/**
	 * Sets the status type.
	 *
	 * @param statusType the new status type
	 */
	public void setStatusType(EmitStatusType statusType) {
		this.statusType = statusType;
	}
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public Object getData() {
		return data;
	}
	
	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * Instantiates a new game status data.
	 *
	 * @param statusType the status type
	 * @param data the data
	 */
	public GameStatusData(EmitStatusType statusType, Object data) {
		super();
		this.statusType = statusType;
		this.data = data;
	}
	
	
}
