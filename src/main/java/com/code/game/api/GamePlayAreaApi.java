package com.code.game.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.game.entity.PlayArea;
import com.code.game.enums.GameType;
import com.code.game.service.PlayAreaService;

/**
 *  Rest Controller class to create, update and list  Play Area.
 */
@RestController
@RequestMapping(value="/play-area")
public class GamePlayAreaApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(GamePlayAreaApi.class);
	
	/** The play area service. */
	@Autowired
	private PlayAreaService playAreaService;
	
	/**
	 * API to create the new Play Area the.
	 *
	 * @param playArea the game
	 * @return the game map
	 * @throws Exception the exception
	 */
	@PostMapping(value="/",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private PlayArea create(@RequestBody PlayArea playArea) throws Exception{
		LOGGER.debug("creating new game Play area ");
		return playAreaService.create(playArea);
		
	}
	
	/**
	 * API to Update play area.
	 *
	 * @param gameMapId the game map id
	 * @param gameMap the game map
	 * @return the game map
	 * @throws Exception the exception
	 */
	@PutMapping(value="/{playAreaId}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private PlayArea update(
				@PathVariable(value="playAreaId") int playAreaId, 
				@RequestBody PlayArea playArea) throws Exception{
		
		return playAreaService.update(playAreaId,playArea);
		
	}
	 
	/**
	 * Find by play area for given game type
	 *
	 * @param gameType the game type
	 * @return the list
	 * @throws Exception the exception
	 */
	@GetMapping(value="/type/{gameType}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private List<PlayArea> findByGameTYpe(@PathVariable("gameType") GameType gameType) throws Exception{
		
		return playAreaService.findByGameType(gameType);
		
	}
	
	/**
	 * Find by play area for given game type
	 *
	 * @param gameType the game type
	 * @return the list
	 * @throws Exception the exception
	 */
	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private PlayArea findById(@PathVariable("id") int id) throws Exception{
		
		return playAreaService.findById(id);
		
	}
	
	/**
	 * Find by play area for given game type
	 *
	 * @param gameType the game type
	 * @return the list
	 * @throws Exception the exception
	 */
	@DeleteMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private void deleteById(@PathVariable("id") int id) throws Exception{
		
		 playAreaService.delete(id);
		
	}
	
	/**
	 * API to list all play area.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	@GetMapping(value="/",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private List<PlayArea> findAll() throws Exception{
		
		return playAreaService.findAll();
		
	}
}
