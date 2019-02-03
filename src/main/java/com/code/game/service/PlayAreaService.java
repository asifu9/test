package com.code.game.service;

import java.util.List;

import com.code.game.entity.PlayArea;
import com.code.game.enums.GameType;

/**
 * The Interface PlayAreaService.
 */
public interface PlayAreaService {

	/**
	 * Method to Create the play area.
	 *
	 * @param gameMap the game map
	 * @return the play area
	 * @throws Exception the exception
	 */
	public PlayArea create(PlayArea playArea) throws Exception; 
	
	/**
	 * Method to Update the play area
	 *
	 * @param playAreaId the game map id
	 * @param playArea the play area
	 * @return the play area
	 * @throws Exception the exception
	 */
	public PlayArea update(int playAreaId,PlayArea playArea) throws Exception; 
	
	/**
	 * Method to Find play area by game type.
	 *
	 * @param gameType the game type
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<PlayArea> findByGameType(GameType gameType)  throws Exception; 
	
	/**
	 * Find all.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<PlayArea> findAll()  throws Exception; 
	
	/**
	 * Method to Delete play area for given id
	 *
	 * @param id the id
	 * @throws Exception the exception
	 */
	public void delete(int id) throws Exception;

	/**
	 * Method to Find Play area by id.
	 *
	 * @param gameMapId the game map id
	 * @return the play area
	 * @throws Exception the exception
	 */
	public PlayArea findById(int gameMapId) throws Exception;
	
	/**
	 * Delete all.
	 *
	 * @throws Exception the exception
	 */
	public void deleteAll() throws Exception;
}
