package com.game.code.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.code.game.GameApplication;
import com.code.game.entity.PlayArea;
import com.code.game.entity.Player;
import com.code.game.enums.GameType;
import com.code.game.service.GameInstanceService;
import com.code.game.service.GameService;
import com.code.game.service.PlayAreaService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GameApplication.class)
@WebAppConfiguration

//@IntegrationTest("server.port:0")
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PlayAreaTest {

	   @Autowired
	    private PlayAreaService playAreaService;

	   @Autowired
	   private GameInstanceService gameInstanceService;
	   
	   @Autowired
	   private GameService gameService;
	

	   @Before
	   public void setUp() throws Exception{
		   gameInstanceService.deleteAll(); 
		   gameService.deleteAll();
		  playAreaService.deleteAll();
	   }
	   
	   
	   
	   @After
	   public void tearDown() throws Exception {
		   gameInstanceService.deleteAll();
		   gameService.deleteAll();
		  playAreaService.deleteAll();
	   }
	   
	  @Test
	    public void createTest() throws Exception
	    {
	        PlayArea playArea = new PlayArea();
		    playArea.setGameType(GameType.ROLE_PLAYING);
		    playArea.setMaxScore(100);
		    playArea.setMinScore(10);
		    playArea.setName("CounterStrike");
		    playArea.setNumberOfPlayer(1);
		    
	        playArea=playAreaService.create(playArea);
	        
	        PlayArea p = playAreaService.findById(playArea.getId());
	        assertNotNull(p);
	        gameInstanceService.deleteAll();
	        gameService.deleteAll();
	        playAreaService.deleteAll();
	        PlayArea del = playAreaService.findById(playArea.getId());
	        assertNull(del);
	    }
	  

	  @Test
	    public void updateTest() throws Exception
	    {
	        PlayArea playArea = new PlayArea();
		    playArea.setGameType(GameType.ROLE_PLAYING);
		    playArea.setMaxScore(100);
		    playArea.setMinScore(10);
		    playArea.setName("Counter Strike");
		    playArea.setNumberOfPlayer(1);
		    
	        playArea=playAreaService.create(playArea);
	        PlayArea p = playAreaService.findById(playArea.getId());
	        p.setGameType(GameType.CRICKET);
	        p.setName("IPL");
	        
	        playAreaService.update(p.getId(), p);
	        
	        PlayArea obj = playAreaService.findById(p.getId());
	        assertEquals("IPL", obj.getName());
	        assertEquals(GameType.CRICKET, obj.getGameType());
	        gameInstanceService.deleteAll();
	        gameService.deleteAll();
	        playAreaService.deleteAll();
	    }
	  
	  @Test
	    public void fetchAllTest() throws Exception
	    {
	        PlayArea playArea = new PlayArea();
		    playArea.setGameType(GameType.ROLE_PLAYING);
		    playArea.setMaxScore(100);
		    playArea.setMinScore(10);
		    playArea.setGameLength(10);
		    playArea.setName("Counter Strike");
		    playArea.setNumberOfPlayer(1);
	        playArea=playAreaService.create(playArea);
	        
	        PlayArea playArea1 = new PlayArea();
		    playArea1.setGameType(GameType.CRICKET);
		    playArea1.setMaxScore(150);
		    playArea.setGameLength(10);
		    playArea1.setMinScore(10);
		    playArea1.setName("IPL");
		    playArea1.setNumberOfPlayer(11);
	        playArea1=playAreaService.create(playArea1);
	        
	        List<PlayArea> plays= playAreaService.findAll();
	        assertEquals(2, plays.size());
	        
	        List<PlayArea> cricketPlays= playAreaService.findByGameType(GameType.CRICKET);
	        assertEquals(1, cricketPlays.size());
	        gameInstanceService.deleteAll();
	        gameService.deleteAll();
	        playAreaService.deleteAll();
	    }

}
