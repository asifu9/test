package com.game.code.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.code.game.GameApplication;
import com.code.game.entity.Avatar;
import com.code.game.entity.Game;
import com.code.game.entity.GameInstance;
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


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManageGameApiTest {

	@Autowired
	private AvatarService avatarService;

	@Autowired
	private GameService gameService;

	@Autowired
	private PlayerService playerService;

	@Autowired
	private PlayAreaService playAreaService;

	@Autowired
	private GamePlayerService gamePlayerService;

	@Autowired
	private GameInstanceService gameInstanceService;


	
	GameInstance instance=null;
	Game game=null;
	Player player=null;
	GamePlayer gamePlayer=null;
	Avatar avatar=null;
	PlayArea playArea=null;
	protected MockMvc mockMvc;
	  @Autowired
	    protected WebApplicationContext webApplicationContext;
	@Before
	public  void  setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
	            .build();
		 player = createPlayer();
		 avatar = createAvatar(player);
		 playArea = createPlayArea();
		game = createGame();
		instance= createGameInstance();
	}

	@Test
	@Order(value = 5)
	public void createTest() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/manage-game/"+instance.getId()+"/START").accept(
				MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		boolean looping=true;
		Thread.sleep(40000);
		GameInstance inst= gameInstanceService.findById(instance.getId());
		
		assertEquals(GameStatus.END, inst.getStatus());
	}


	public GameInstance createGameInstance() throws Exception {
		GamePlayer gamePlayer = new GamePlayer();
		gamePlayer.setAvatar(avatar);
		gamePlayer.setInitiator(true);
		gamePlayer.setStatus(GameStatus.NEW);

		GameInstance gameInstance = new GameInstance();
		List<GamePlayer> players=new ArrayList<>();
		players.add(gamePlayer);
		gameInstance.setGame(game);
		gameInstance.setPlayArea(playArea);
		gameInstance.setStatus(GameStatus.NEW);
		gameInstance.setGamePlayers(players);
		
		gamePlayer.setGameInstance(gameInstance);
		
		gameInstance=gameInstanceService.create(gameInstance);
		gamePlayer= gamePlayerService.create(gamePlayer);
		return gameInstance;
	}


	public PlayArea createPlayArea() throws Exception {
		PlayArea playArea = new PlayArea();
		playArea.setGameType(GameType.ROLE_PLAYING);
		playArea.setMaxScore(100);
		playArea.setMinScore(10);
		playArea.setGameLength(10);
		playArea.setName("CounterStrike");
		playArea.setNumberOfPlayer(1);
		return playAreaService.create(playArea);
	}


	public Game createGame() throws Exception {
		Game game = new Game();
		game.setGameType(GameType.ROLE_PLAYING);
		game.setName("CounterStrike");
		return gameService.create(game);
	}


	public Avatar createAvatar(Player player) throws Exception {
		Avatar avatar = new Avatar();
		avatar.setGender("MALE");
		avatar.setHairColor(HairColor.GREY);
		avatar.setName("TOM");
		avatar.setPlayer(player);
		avatar.setScore(0);
		avatar.setExperience(1);
		avatar.setSkinColor(SkinColor.BLACK);
		return avatarService.create(avatar);
	}


	public Player createPlayer() throws Exception {
		Player p1 = new Player();
		p1.setFirstName("Asif");
		p1.setLastName("Usman");
		p1.setUserName("asifu");
		return playerService.create(p1);
	}

}
