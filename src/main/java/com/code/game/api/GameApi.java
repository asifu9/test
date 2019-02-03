package com.code.game.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import javax.websocket.server.PathParam;

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

import com.code.game.entity.Game;
import com.code.game.entity.PlayArea;
import com.code.game.enums.GameType;
import com.code.game.service.GameService;
import com.code.game.service.PlayAreaService;


// TODO: Auto-generated Javadoc
/**
 *  Rest Controller class to create, update and list  Game API.
 */
@RestController
@RequestMapping(value="/game")
public class GameApi {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(GameApi.class);
	
	/** The game service. */
	@Autowired
	private GameService gameService;
	
	@Autowired
	private PlayAreaService playAreaService;
	
	/**
	 * API to create new game.
	 *
	 * @param game the game
	 * @return the game
	 * @throws Exception the exception
	 */
	@PostMapping(value="/",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private Game create(@RequestBody Game game) throws Exception{
		LOGGER.debug("creating new game  ");
		if(game.getPlayArea()!=null){
			for(PlayArea g: game.getPlayArea()){
				if(g.getId()!=0){
					g=playAreaService.findById(g.getId());
				}
			}
		}
		return gameService.create(game);
		
	}
	
	/**
	 * API to update game.
	 *
	 * @param gameId the game id
	 * @param game the game
	 * @return the game
	 * @throws Exception the exception
	 */
	@PutMapping(value="/{gameId}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private Game update(
				@PathVariable(value="gameId") int gameId, 
				@RequestBody Game game) throws Exception{

		return gameService.update(gameId,game);
		
	}
	
	/**
	 * API to find the games by game Type.
	 *
	 * @param gameType the game type
	 * @return the list
	 * @throws Exception the exception
	 */
	@GetMapping(value="/type/{gameType}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private List<Game> findByGameTYpe(@PathVariable("gameType") GameType gameType) throws Exception{
		
		return gameService.findByGameType(gameType);
		
	}
	
	/**
	 * API to find all the games.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	@GetMapping(value="/",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private List<Game> findAll() throws Exception{
		
		return gameService.findAll();
		
		
	}
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the game
	 * @throws Exception the exception
	 */
	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private Game findById(@PathVariable("id") int id) throws Exception{
		
		return gameService.findById(id);
		
	}
	
	/**
	 * Delete by id.
	 *
	 * @param id the id
	 * @throws Exception the exception
	 */
	@DeleteMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private void deleteById(@PathVariable("id") int id) throws Exception{
		
		 gameService.delete(id);
		
	}
}
