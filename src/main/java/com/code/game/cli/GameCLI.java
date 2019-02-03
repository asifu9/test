package com.code.game.cli;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.code.game.GameApplication;
import com.code.game.entity.Game;
import com.code.game.entity.PlayArea;
import com.code.game.enums.GameType;
import com.code.game.service.GameService;
import com.code.game.service.PlayAreaService;
import com.google.gson.Gson;

/**
 * The Class GameCLI.
 */
@Component
@Order(value=5)
public class GameCLI implements CommandLineRunner{

	/** The game service. */
	@Autowired
	private GameService gameService;
	
	@Autowired
	private PlayAreaService playAreaService;
	
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
		Game game=new Game();
		game.setGameType(GameType.ROLE_PLAYING);
		game.setName("CounterStrike");
		List<PlayArea> list=new ArrayList<>();
		PlayArea a=new PlayArea("CounterStrike", GameType.ROLE_PLAYING, 1,15);
		a.setMaxScore(20);
		a.setMinScore(10);
		
		game.setPlayArea(list);
		list.add(a);
		Game g=gameService.create(game);
		playAreaService.create(a);
		
		
		
	
	}

}
