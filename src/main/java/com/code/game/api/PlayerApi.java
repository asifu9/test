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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.game.entity.Player;
import com.code.game.service.PlayerService;


/**
 * The Class PlayerApi.
 */
@RestController
@RequestMapping(value="/player")
public class PlayerApi {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(PlayerApi.class);
	
	/** The player service. */
	@Autowired
	private PlayerService playerService;
	
	/**
	 * Creates the.
	 *
	 * @param player the player
	 * @return the player
	 * @throws Exception the exception
	 */
	@PostMapping(value="/",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private Player create(@RequestBody Player player) throws Exception{
		LOGGER.debug("creating new player ");
		return playerService.create(player);
	}
	
	/**
	 * Gets the a ll.
	 *
	 * @return the a ll
	 * @throws Exception the exception
	 */
	@GetMapping(value="/",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private List<Player> getALl() throws Exception{
		
		return playerService.fetchAll();
	}
	
	/**
	 * Gets the a ll.
	 *
	 * @return the a ll
	 * @throws Exception the exception
	 */
	@DeleteMapping(value="/{playerId}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private void delete(@PathVariable("playerId") int playerId) throws Exception{
		
		 playerService.delete(playerId);
	}
}
