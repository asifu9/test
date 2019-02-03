package com.game.code.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.code.game.GameApplication;
import com.code.game.entity.Game;
import com.code.game.enums.GameType;
import com.code.game.service.GameInstanceService;
import com.code.game.service.GameService;
//
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GameApplication.class)

//@WebAppConfiguration
// @IntegrationTest("server.port:0")
// @FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GameTest {

	@Autowired
	private GameService gameService;
	
	@Autowired
	private GameInstanceService gameInstanceService;

	@Test
	public void createTest() throws Exception {
		Game game = new Game();
		game.setGameType(GameType.ROLE_PLAYING);
		game.setName("CounterStrike");

		game = gameService.create(game);
		Game p = gameService.findById(game.getId());
		assertNotNull(p);
		gameInstanceService.deleteAll();
		gameService.deleteAll();
		Game del = gameService.findById(game.getId());
		assertNull(del);
	}

	@Test
	public void updateTest() throws Exception {
		Game game = new Game();
		game.setGameType(GameType.ROLE_PLAYING);
		game.setName("CounterStrike");
		game = gameService.create(game);
		Game p = gameService.findById(game.getId());
		assertNotNull(p);

		p.setName("IPL");
		p.setGameType(GameType.CRICKET);

		gameService.update(p.getId(), p);
		Game updateGame = gameService.findById(game.getId());
		assertEquals("IPL", updateGame.getName());
		assertEquals(GameType.CRICKET, updateGame.getGameType());
		gameInstanceService.deleteAll();
		gameService.deleteAll();

	}

	@Test
	public void fetchTest() throws Exception {
		gameInstanceService.deleteAll();
		gameService.deleteAll();
		Game game = new Game();
		game.setGameType(GameType.ROLE_PLAYING);
		game.setName("CounterStrike");
		game = gameService.create(game);

		Game game1 = new Game();
		game1.setGameType(GameType.CRICKET);
		game1.setName("IPL");
		game1 = gameService.create(game1);

		List<Game> list = gameService.findAll();
		assertEquals(2, list.size());

		List<Game> list2 = gameService.findByGameType(GameType.CRICKET);
		assertEquals(1, list2.size());
		gameInstanceService.deleteAll();
		gameService.deleteAll();

	}

}
