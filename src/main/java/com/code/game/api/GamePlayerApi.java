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

import com.code.game.entity.GamePlayer;
import com.code.game.service.GamePlayerService;


/**
 * The Class GamePlayerApi.
 */
@RestController
@RequestMapping(value="/game-player")
public class GamePlayerApi {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(GamePlayerApi.class);
	
	/** The game player service. */
	@Autowired
	private GamePlayerService gamePlayerService;
	
	/**
	 * API to Create the game player.
	 *
	 * @param gamePlayer the game player
	 * @return the game player
	 * @throws Exception the exception
	 */
	@PostMapping(value="/",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private GamePlayer create(@RequestBody GamePlayer gamePlayer) throws Exception{
		LOGGER.debug("creating new Game player ");
		return gamePlayerService.create(gamePlayer);
	}
	

	/**
	 * Find all.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	@GetMapping(value="/",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private List<GamePlayer> findAll() throws Exception{
		
		return gamePlayerService.findAll();
	}
}
