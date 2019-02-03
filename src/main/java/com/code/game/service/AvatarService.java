package com.code.game.service;

import java.util.List;

import com.code.game.entity.Avatar;
import com.code.game.entity.Player;

/**
 * The Interface AvatarService.
 */
public interface AvatarService {

	/**
	 * Creates the.
	 *
	 * @param player the player
	 * @return the avatar
	 * @throws Exception the exception
	 */
	public Avatar create(Avatar player) throws Exception; 
	
	/**
	 * Update.
	 *
	 * @param player the player
	 * @return the avatar
	 * @throws Exception the exception
	 */
	public Avatar update(Avatar player) throws Exception; 
	
	/**
	 * Find by player id.
	 *
	 * @param playerId the player id
	 * @return the java.util. list
	 * @throws Exception the exception
	 */
	public java.util.List<Avatar> findByPlayerId(Player playerId) throws Exception; 
	
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the avatar
	 * @throws Exception the exception
	 */
	public Avatar findById(int id) throws Exception;
	
	
	/**
	 * Find all.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Avatar> findAll() throws Exception;
	
	/**
	 * Delete all.
	 *
	 * @throws Exception the exception
	 */
	public void deleteAll() throws Exception;
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 * @throws Exception the exception
	 */
	public void delete(int id) throws Exception;
	
}
