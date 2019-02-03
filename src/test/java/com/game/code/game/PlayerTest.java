package com.game.code.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.code.game.GameApplication;
import com.code.game.entity.Player;
import com.code.game.service.GameInstanceService;
import com.code.game.service.PlayerService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GameApplication.class)
@WebAppConfiguration
//@IntegrationTest("server.port:0")
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PlayerTest {

	   @Autowired
	    private PlayerService playerService;
	   
	   @Autowired
	   private GameInstanceService gameInstanceService;

	
	  @Test
	    public void createTest() throws Exception
	    {
	        Player player = new Player();
	        player.setFirstName("Max");
	        player.setLastName("Well");
	        player.setUserName("mwell");
	        player=playerService.create(player);
	        Player p = playerService.findById(player.getId());
	        assertNotNull(p);
	        gameInstanceService.deleteAll();
	        playerService.deleteAll();
	        Player del = playerService.findById(player.getId());
	        assertNull(del);
	    }
	  
	  @Test
	    public void updateTest() throws Exception
	    {
	        Player player = new Player();
	        player.setFirstName("Max");
	        player.setLastName("Well");
	        player.setUserName("mwell");
	        player=playerService.create(player);
	        Player p = playerService.findById(player.getId());
	       
	        p.setLastName("Life");
	        playerService.update(p);
	        
	        
	        Player pla = playerService.findById(p.getId());
	        assertEquals("Max", pla.getFirstName());
	        assertEquals("Life", pla.getLastName());
	        gameInstanceService.deleteAll();
	        playerService.deleteAll();
	    }

}
