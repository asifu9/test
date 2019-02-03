package com.code.game.service;

import com.code.game.entity.Player;

/**
 * The Interface PlayerService.
 */
public interface PlayerService {

	/**
	 * Method to Creates the Player
	 *
	 * @param player the player
	 * @return the player
	 * @throws Exception the exception
	 */
	public Player create(Player player) throws Exception; 
	
	/**
	 * Method to Update the given Player 
	 *
	 * @param player the player
	 * @return the player
	 * @throws Exception the exception
	 */
	public Player update(Player player) throws Exception; 
	
	/**
	 * Method to Fetch all Players
	 *
	 * @return the java.util. list
	 * @throws Exception the exception
	 */
	public java.util.List<Player> fetchAll() throws Exception; 
	
	/**
	 * Method to Find Player by Id
	 *
	 * @param id the id
	 * @return the player
	 * @throws Exception the exception
	 */
	public Player findById(int id) throws Exception;
	
	/**
	 * Method to Delete by player Id
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
}
