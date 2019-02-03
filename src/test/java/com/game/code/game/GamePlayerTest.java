package com.game.code.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.code.game.GameApplication;
import com.code.game.entity.Avatar;
import com.code.game.entity.Game;
import com.code.game.entity.GamePlayer;
import com.code.game.entity.PlayArea;
import com.code.game.entity.Player;
import com.code.game.enums.GameStatus;
import com.code.game.enums.GameType;
import com.code.game.enums.HairColor;
import com.code.game.enums.SkinColor;
import com.code.game.service.AvatarService;
import com.code.game.service.GameInstanceService;
import com.code.game.service.GamePlayerService;
import com.code.game.service.GameService;
import com.code.game.service.PlayAreaService;
import com.code.game.service.PlayerService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GameApplication.class)
@WebAppConfiguration

// @IntegrationTest("server.port:0")
// @FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GamePlayerTest {

	@Autowired
	private GamePlayerService gamePlayerService;
	   @Autowired
	    private GameService gameService;
	   @Autowired
	   private PlayerService playerService;
	   @Autowired
	   private PlayAreaService playAreaService;
	   @Autowired
	   private AvatarService avatarService;
	   
	   @Autowired
	   private GameInstanceService gameInstanceService;
	   
	   Player player=null;
	   PlayArea playArea=null;
	   //Game game=null;
	   Avatar avatar=null;
	   
	   @Before
	   public void setUp() throws Exception{
			player=playerService.create(new Player("Tom", "Harris", "tharris"));
			avatar=	avatarService.create(new Avatar("Asif", HairColor.BLACK, SkinColor.ASIAN, "MALE"));
			avatar.setPlayer(player);
			PlayArea area=new PlayArea("Counter Strike", GameType.ROLE_PLAYING, 1,10);
			area.setGameLength(10);
			area.setMaxScore(20);
			area.setMinScore(10);
		  	playArea = playAreaService.create(area);
		  	
		  	//game=gameService.create(new Game("CounterStrike",GameType.ROLE_PLAYING,Arrays.asList(playArea)));
		    
	   }
	   
	@Test
	public void createTest() throws Exception {

		GamePlayer gamePlayer = new GamePlayer();
		gamePlayer.setAvatar(avatar);
		gamePlayer.setInitiator(true);
		gamePlayer.setStatus(GameStatus.NEW);

		gamePlayer = gamePlayerService.create(gamePlayer);
		GamePlayer p = gamePlayerService.findById(gamePlayer.getId());
		assertNotNull(p);
		gameInstanceService.deleteAll();
		gamePlayerService.deleteAll();
		GamePlayer del = gamePlayerService.findById(gamePlayer.getId());
		assertNull(del);
	}

	@Test
	public void updateTest() throws Exception {

		GamePlayer gamePlayer = new GamePlayer();
		gamePlayer.setAvatar(avatar);
		gamePlayer.setInitiator(true);
		gamePlayer.setStatus(GameStatus.NEW);

		gamePlayer = gamePlayerService.create(gamePlayer);

		GamePlayer p = gamePlayerService.findById(gamePlayer.getId());
		Player player2=playerService.create(new Player("Asif", "U", "ausman"));
		Avatar avatar2=	avatarService.create(new Avatar("Asif", HairColor.BLACK, SkinColor.ASIAN, "MALE"));
		avatar2.setPlayer(player2);
		p.setAvatar(avatar2);

		gamePlayerService.update(p);

		GamePlayer updatedGame = gamePlayerService.findById(p.getId());
		assertEquals(avatar2.getId(), updatedGame.getAvatar().getId());
		gameInstanceService.deleteAll();
		gamePlayerService.deleteAll();

	}

	@Test
	public void fetchTest() throws Exception {
		gameInstanceService.deleteAll();
		gamePlayerService.deleteAll();
		

		GamePlayer gamePlayer = new GamePlayer();
		gamePlayer.setAvatar(avatar);
		gamePlayer.setInitiator(true);
		gamePlayer.setStatus(GameStatus.NEW);
		gamePlayer = gamePlayerService.create(gamePlayer);
		Player player2=playerService.create(new Player("Asif", "U", "ausman"));
		Avatar avatar2=	avatarService.create(new Avatar("Asif", HairColor.BLACK, SkinColor.ASIAN, "MALE"));
		avatar2.setPlayer(player2);
		
		GamePlayer gamePlayer2 = new GamePlayer();
		gamePlayer2.setAvatar(avatar2);
		gamePlayer2.setInitiator(true);
		gamePlayer2.setStatus(GameStatus.RUNNING);
		gamePlayer2 = gamePlayerService.create(gamePlayer2);

		
		assertNotNull(gamePlayer2);
		List<GamePlayer>  list=gamePlayerService.findAll();
		assertEquals(2, list.size());
		gameInstanceService.deleteAll();
		gamePlayerService.deleteAll();

	}

}
