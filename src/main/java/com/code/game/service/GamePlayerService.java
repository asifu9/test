package com.code.game.service;

import java.util.List;

import com.code.game.entity.GamePlayer;
import com.code.game.entity.Player;

// TODO: Auto-generated Javadoc
/**
 * The Interface GamePlayerService.
 */
public interface GamePlayerService {

	/**
	 * Method to Create new Game player.
	 *
	 * @param gamePlayer the game player
	 * @return the game player
	 * @throws Exception the exception
	 */
	public GamePlayer create(GamePlayer gamePlayer) throws Exception; 
	
	/**
	 * Method to update the game player.
	 *
	 * @param gamePlayer the game player
	 * @return the game player
	 * @throws Exception the exception
	 */
	public GamePlayer update(GamePlayer gamePlayer) throws Exception; 
	
	/**
	 * Method to Find the game player by ID.
	 *
	 * @param id the id
	 * @return the game player
	 * @throws Exception the exception
	 */
	public GamePlayer findById(int id) throws Exception;
	
	/**
	 * Method to find the game players by game details id.
	 *
	 * @param gameDetailsId the game details id
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<GamePlayer> findByGameInstanceId(int gameDetailsId) throws Exception;
 	
	
	/**
	 * Method to delete the given game player by ID.
	 *
	 * @param id the id
	 * @throws Exception the exception
	 */
	public void delete(int id) throws Exception;

	/**
	 * Delete all.
	 *
	 * @throws Exception the exception
	 */
	public void deleteAll() throws Exception;

	/**
	 * Find all.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<GamePlayer>  findAll() throws Exception;
}
