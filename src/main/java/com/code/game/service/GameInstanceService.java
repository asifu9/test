package com.code.game.service;

import java.util.List;

import com.code.game.entity.GameInstance;
import com.code.game.enums.GameStatus;

// TODO: Auto-generated Javadoc
/**
 * The Interface GameInstanceService.
 */
public interface GameInstanceService {

	/**
	 * Creates the.
	 *
	 * @param gameInstance
	 *            the game instance
	 * @return the game instance
	 * @throws Exception
	 *             the exception
	 */
	public GameInstance create(GameInstance gameInstance) throws Exception;

	/**
	 * Update.
	 *
	 * @param id
	 *            the id
	 * @param gameInstance
	 *            the game instance
	 * @return the game instance
	 * @throws Exception
	 *             the exception
	 */
	public GameInstance update(int id, GameInstance gameInstance) throws Exception;

	/**
	 * Find by id.
	 *
	 * @param id
	 *            the id
	 * @return the game instance
	 * @throws Exception
	 *             the exception
	 */
	public GameInstance findById(int id) throws Exception;

	/**
	 * Find all.
	 *
	 * @return the list
	 * @throws Exception
	 *             the exception
	 */
	public List<GameInstance> findAll() throws Exception;

	/**
	 * Delete.
	 *
	 * @param id
	 *            the id
	 * @throws Exception
	 *             the exception
	 */
	public void delete(int id) throws Exception;

	/**
	 * Update status.
	 *
	 * @param id
	 *            the id
	 * @param running
	 *            the running
	 * @return true, if successful
	 * @throws Exception
	 *             the exception
	 */
	public boolean updateStatus(int id, GameStatus running) throws Exception;

	/**
	 * Update avatar.
	 *
	 * @param avatarId
	 *            the avatar id
	 * @param score
	 *            the score
	 * @throws Exception
	 *             the exception
	 */
	public void updateAvatar(int avatarId, float score) throws Exception;
	

	/**
	 * Update status on end.
	 *
	 * @param id
	 *            the id
	 * @throws Exception
	 *             the exception
	 */
	public void updateStatusOnEnd(int id) throws Exception;

	/**
	 * Update player status.
	 *
	 * @param id            the id
	 * @param status            the status
	 * @throws Exception the exception
	 */
	public void updatePlayerStatus(int id, GameStatus status) throws Exception;

	/**
	 * Delete all.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public void deleteAll() throws Exception;

	/**
	 * Update experience.
	 *
	 * @param id the id
	 * @param d the d
	 */
	public void updateExperience(int id, float incrementValue) throws Exception;
}
