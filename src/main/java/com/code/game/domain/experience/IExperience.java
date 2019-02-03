package com.code.game.domain.experience;

import com.code.game.entity.GamePlayer;

/**
 * The Interface IExperience.
 */
public interface IExperience {

	/**
	 * Calculate experience.
	 *
	 * @param player the player
	 * @throws Exception the exception
	 */
	public void calculateExperience(GamePlayer player) throws Exception;
}
