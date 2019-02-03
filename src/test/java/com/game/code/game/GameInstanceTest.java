package com.game.code.game;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.boot.jaxb.hbm.spi.PluralAttributeInfoPrimitiveArrayAdapter;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.code.game.GameApplication;
import com.code.game.entity.GameInstance;
import com.code.game.entity.PlayArea;
import com.code.game.entity.Game;
import com.code.game.entity.Player;
import com.code.game.enums.GameStatus;
import com.code.game.enums.GameType;
import com.code.game.enums.HairColor;
import com.code.game.enums.SkinColor;
import com.code.game.service.AvatarService;
import com.code.game.service.GameInstanceService;
import com.code.game.service.GameService;
import com.code.game.service.PlayAreaService;
import com.code.game.service.PlayerService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GameApplication.class)
@WebAppConfiguration

//@IntegrationTest("server.port:0")
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GameInstanceTest {

	   @Autowired
	    private GameInstanceService gameInstanceService;
	   @Autowired
	    private GameService gameService;
	   @Autowired
	   private PlayerService playerService;
	   @Autowired
	   private PlayAreaService playAreaService;
	   
	   Player player=null;
	   PlayArea playArea=null;
	   Game game=null;
	   
	   @Before
	   public void setUp() throws Exception{
			player=playerService.create(new Player("Tom", "Harris", "tharris"));
		  	playArea = new PlayArea("Counter Strike", GameType.ROLE_PLAYING, 1,10);
		  	playArea.setMaxScore(20);
		  	playArea.setMinScore(10);
		  	playArea.setGameLength(10);
		  	game=gameService.create(new Game("CounterStrike",GameType.ROLE_PLAYING,Arrays.asList(playArea)));
	   }
	
	  @Test
	    public void testCreate() throws Exception
	    {
		  	
		  
	        GameInstance gameInstance = new GameInstance();
		    gameInstance.setGame(game);
		    gameInstance.setPlayArea(playArea);
		    gameInstance.setStatus(GameStatus.RUNNING);

		    
	        gameInstance=gameInstanceService.create(gameInstance);
	        GameInstance p = gameInstanceService.findById(gameInstance.getId());
	        assertNotNull(p);
	        gameInstanceService.deleteAll();
	        GameInstance del = gameInstanceService.findById(gameInstance.getId());
	        assertNull(del);
	    }
	  
	  @Test
	    public void updateTest() throws Exception
	    {
		  
	        GameInstance gameInstance = new GameInstance();
		    gameInstance.setGame(game);
		    gameInstance.setPlayArea(playArea);
		    gameInstance.setStatus(GameStatus.RUNNING);
	        gameInstance=gameInstanceService.create(gameInstance);
	        
	        GameInstance intance = gameInstanceService.findById(gameInstance.getId());
	        PlayArea playAreaNew = playAreaService.create(new PlayArea("Counter Strike", GameType.ROLE_PLAYING, 1,10));
		  	Game gameNew=gameService.create(new Game("CounterStrike",GameType.ROLE_PLAYING));
	        intance.setGame(gameNew);	
	        intance.setPlayArea(playAreaNew);
	        intance.setStatus(GameStatus.END);
	        gameInstanceService.update(intance.getId(), intance);
	        
	        GameInstance fetchedData = gameInstanceService.findById(gameInstance.getId());
	        assertEquals(playAreaNew.getId(), fetchedData.getPlayArea().getId());
	        assertEquals(gameNew.getId(), fetchedData.getGame().getId());
	        assertEquals(GameStatus.END, fetchedData.getStatus());
	        		
	        gameInstanceService.deleteAll();
	    }
	  
	  @Test
	    public void fetchTest() throws Exception
	    {
		  	gameInstanceService.deleteAll();
	        
		  	GameInstance gameInstance = new GameInstance();
		    gameInstance.setGame(game);
		    gameInstance.setPlayArea(playArea);
		    gameInstance.setStatus(GameStatus.RUNNING);
	        gameInstance=gameInstanceService.create(gameInstance);
	        
	     	GameInstance gameInstance1 = new GameInstance();
		    gameInstance1.setGame(game);
		    gameInstance1.setPlayArea(playArea);
		    gameInstance1.setStatus(GameStatus.RUNNING);
	        gameInstance1=gameInstanceService.create(gameInstance1);
	        
	        List<GameInstance> list = gameInstanceService.findAll();
	        assertEquals(2, list.size());
	        		
	        gameInstanceService.deleteAll();
	    }

}
