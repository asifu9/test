package com.code.game.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.game.entity.GameInstance;
import com.code.game.service.GameInstanceService;


/**
 *  Rest Controller class to create, update and list  Game Instance API.
 */
@RestController
@RequestMapping(value="/game-instance")
public class GameInstanceApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(GameInstanceApi.class);
	
	/** The game instance service. */
	@Autowired
	private GameInstanceService gameInstanceService;
	
	/**
	 * API to create new game instance before he start to play
	 *
	 * @param gameInstance the game instance
	 * @return the game instance
	 * @throws Exception the exception
	 */
	@PostMapping(value="/",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private GameInstance create(@RequestBody GameInstance gameInstance) throws Exception{
		LOGGER.debug("creating new game instance ");
		return gameInstanceService.create(gameInstance);
	}
	
	/**
	 * Gets the all the game instances
	 *
	 * @return list of all game instances
	 * @throws Exception the exception
	 */
	@GetMapping(value="/",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private List<GameInstance> getALl() throws Exception{
		
		return gameInstanceService.findAll();
	}
}
