package com.code.game.service;

import java.util.List;

import com.code.game.entity.Game;
import com.code.game.enums.GameType;

/**
 * The Interface GameService.
 */
public interface GameService {

	/**
	 * Method to Creates new Game Service
	 *
	 * @param player
	 *            the player
	 * @return the game
	 * @throws Exception
	 *             the exception
	 */
	public Game create(Game player) throws Exception;

	/**
	 * Method to Update the given Game
	 *
	 * @param gameId
	 *            the game id
	 * @param player
	 *            the player
	 * @return the game
	 * @throws Exception
	 *             the exception
	 */
	public Game update(int gameId, Game player) throws Exception;

	/**
	 * Method to Find games by game type.
	 *
	 * @param gameType
	 *            the game type
	 * @return the list
	 * @throws Exception
	 *             the exception
	 */
	public List<Game> findByGameType(GameType gameType) throws Exception;

	/**
	 * Method to Find game by id
	 *
	 * @param gameId
	 *            the game id
	 * @return the game
	 * @throws Exception
	 *             the exception
	 */
	public Game findById(int gameId) throws Exception;

	/**
	 * Method to Find all games
	 *
	 * @return the list
	 */
	public List<Game> findAll();

	/**
	 * Method to Delete game by game id.
	 *
	 * @param id
	 *            the id
	 * @throws Exception
	 *             the exception
	 */
	public void delete(int id) throws Exception;

	/**
	 * Delete all.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public void deleteAll() throws Exception;
}
