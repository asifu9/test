package com.code.game.cli;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.code.game.GameApplication;
import com.code.game.entity.GameInstance;
import com.code.game.entity.GamePlayer;
import com.code.game.enums.GameStatus;
import com.code.game.service.AvatarService;
import com.code.game.service.GameInstanceService;
import com.code.game.service.GamePlayerService;
import com.code.game.service.GameService;
import com.code.game.service.PlayAreaService;
import com.code.game.service.PlayerService;

/**
 * The Class GameInstance CLI.
 */
@Component
@Order(value=6)
public class GameInstanceCLI implements CommandLineRunner{

	/** The game instance service. */
	@Autowired
	private GameInstanceService gameInstanceService;
	

	/** The game player service. */
	@Autowired
	private GamePlayerService gamePlayerService;
	
	@Autowired
	private GameService gameService;
	
	@Autowired
	private PlayAreaService playAreaService;
	
	@Autowired
	private AvatarService avatarService;
	
	@Autowired
	private PlayerService playerService;
	
	@Value("${game.populate.default.data}")
	public  boolean INITIALIZE_DEFAULT_DATA;
	
	
	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		if(!INITIALIZE_DEFAULT_DATA){
			return;
		}
		GameInstance p=new GameInstance();
		p.setGame(gameService.findById(1));
		p.setPlayArea(playAreaService.findById(1));
		
		List<GamePlayer> players=new ArrayList<>();
		GamePlayer gp=new GamePlayer();
		gp.setAvatar(avatarService.findById(1));
		gp.setGameInstance(p);
		gp.setInitiator(true);
		gp.setScore(0);
		players.add(gp);
		
//		GamePlayer gp1=new GamePlayer();
//		gp1.setAvatarId(2);
//		gp1.setGameInstance(p);
//		gp1.setInitiator(false);
//		gp1.setPlayerId(2);
//		gp1.setScore(0);
//		players.add(gp1);
		
		p.setGamePlayers(players);
		p.setStatus(GameStatus.NEW);
		
		gameInstanceService.create(p);
		gamePlayerService.create(gp);
		
		
	}

}
