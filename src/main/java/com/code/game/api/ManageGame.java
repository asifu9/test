package com.code.game.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.game.domain.GameAction;
import com.code.game.domain.GameEngine;
import com.code.game.domain.GameUserAction;
import com.code.game.domain.IUserAction;
import com.code.game.entity.Game;
import com.code.game.entity.GameInstance;
import com.code.game.entity.GamePlayer;
import com.code.game.enums.GameSessions;
import com.code.game.enums.GameStatus;
import com.code.game.enums.MoveAction;
import com.code.game.enums.UserAction;
import com.code.game.factory.GameEngineFactory;
import com.code.game.factory.GameThreadFactory;
import com.code.game.service.GameInstanceService;
import com.code.game.service.GameService;
import com.google.gson.Gson;


/**
 * The Class ManageGame.
 */
@RestController
@RequestMapping(value="/manage-game")
public class ManageGame {

	private static final Logger LOGGER = LoggerFactory.getLogger(ManageGame.class);
	
	/** The game instance service. */
	@Autowired
	private GameInstanceService gameInstanceService;
	
	/** The game engine factory. */
	@Autowired
	private GameEngineFactory gameEngineFactory;
	
	@Autowired
	private GameThreadFactory gameThreadFactory;
	
	@Autowired
	private GameService gameService;
	
	
	/**
	 * Initiate the game for given status
	 *
	 * @param gameInstanceId the game instance id
	 * @param status the status
	 * @return the game instance
	 * @throws Exception the exception
	 */
	@PostMapping(value="/{gameInstanceId}/{action}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private GameInstance initiateGameByStatus(@PathVariable("gameInstanceId") int gameInstanceId,
			@PathVariable("action") com.code.game.enums.GameAction action) throws Exception{
		LOGGER.info("initiating the game for game instance id {} with status {} ",gameInstanceId,action);
		GameInstance gameInstance= gameInstanceService.findById(gameInstanceId);
		GameEngine gameEngine=  GameSessions.INSTANCE.getGameSession(gameInstanceId);
		List<GameAction> users=null;
		if(gameEngine==null){
			users=new ArrayList<>();
			gameEngine=gameEngineFactory.getGameEngine(gameInstance);
			for(GamePlayer player:gameEngine.getGameInstance().getGamePlayers()){
				GameAction user=new GameUserAction(gameEngine,player,
						gameThreadFactory.getGameThreadInstance(gameInstance.getGame().getName(),
						player,
						gameEngine));
				users.add(user);
			}
			gameEngine.setUsers(users);
			GameSessions.INSTANCE.setSession(gameInstanceId, gameEngine);
		}else{
			users=gameEngine.getUsers();
		}

		
		switch(action){
			case START:
				users.forEach(u->{
					u.startGame();
				});
				break;
			case PAUSE:
				users.forEach(u->{
					
					u.pauseGame();
				});
				break;
			case RESUME:
				users.forEach(u->{
					u.resumeGame();
				});
				break;
			case STOP:
				users.forEach(u->{
					u.stopGame();
				});
				break;
			default:
				throw new Exception("unknown status for game");
				
		}
		return gameInstance;
	}
	
	@PostMapping(value="/{gameInstanceId}/user/{userId}/action/{type}/{value}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private void userActionController(@PathVariable("gameInstanceId") int gameInstanceId,
			@PathVariable("userId") int userId,
			@PathVariable("type") String type,
			@PathVariable("value") String value) throws Exception{
		LOGGER.info("initiating the game for game instance id {} with status {} ",gameInstanceId);
		GameEngine gameEngine=  GameSessions.INSTANCE.getGameSession(gameInstanceId);
		List<IUserAction> users=null;
		if(gameEngine==null){
			throw new Exception("Game is not available in session");
		}
		if(gameEngine.getGameInstance().getStatus()==GameStatus.END){
			throw new Exception("Game is over...");
		}
		GameAction user=null;
		for(GameAction u: gameEngine.getUsers()){
			if(u.getPlayer().getAvatar().getPlayer().getId()==userId){
				user=u;
			}
		}
		if(user==null){
			throw new Exception("Give user not found in game/system");
		}
		
		switch(type){
		case "move":
				MoveAction action=MoveAction.getValue(value);
				gameEngine.move(user.getPlayer().getAvatar().getId(),action);
			break;
		case "action":
				UserAction userAction=UserAction.getValue(value);
				gameEngine.action(user.getPlayer().getAvatar().getId(),userAction);
			break;
		default :
			throw new Exception("Action type having wrong value");
		}
	}
	
	
	/**
	 * API to get all the session
	 *
	 * @return the a list of active sessions
	 * @throws Exception the exception
	 */
	@GetMapping(value="/",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private List<GameInstance> getAllSessions() throws Exception{
		return gameInstanceService.findAll();
	}
}
