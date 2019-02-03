package com.game.code.game;

import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.code.game.GameApplication;
import com.code.game.entity.Avatar;
import com.code.game.entity.Player;
import com.code.game.enums.HairColor;
import com.code.game.enums.SkinColor;
import com.code.game.service.AvatarService;
import com.code.game.service.GameInstanceService;
import com.code.game.service.PlayerService;
import com.google.gson.Gson;
	

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GameApplication.class)
@WebAppConfiguration

//@IntegrationTest("server.port:0")
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AvatarTest {

	 @Autowired
	 DataSource datasource;
	   @Autowired
	    private AvatarService avatarService;
	   
	   @Autowired
	   private PlayerService playerService;
	   
	   @Autowired
	   private GameInstanceService gameInstanceService;
	   
	   Player player=null;
	   Player player2=null;

	   @Before
	   public void setUp() throws Exception{
		   gameInstanceService.deleteAll();
		   avatarService.deleteAll();
		   playerService.deleteAll();
		    player = new Player();
	        player.setFirstName("Max");
	        player.setLastName("Well");
	        player.setUserName("mwell");
	        player=playerService.create(player);
	        
		    player2 = new Player();
	        player2.setFirstName("Chris");
	        player2.setLastName("Gyle");
	        player2.setUserName("cgyle");
	        player2=playerService.create(player2);
	   }
	   
	   
	   
	   @After
	   public void tearDown() throws Exception {
		   gameInstanceService.deleteAll();
		  playerService.deleteAll();
		  avatarService.deleteAll();
	   }
	
	  @Test
	    public void createTest() throws Exception
	    {
	        Avatar avatar = new Avatar();
		    avatar.setGender("MALE");
		    avatar.setHairColor(HairColor.GREY);
		    avatar.setName("TOM");
		    avatar.setPlayer(player);
		    avatar.setScore(0);
		    avatar.setSkinColor(SkinColor.BLACK);
	        avatar=avatarService.create(avatar);
	        Avatar p = avatarService.findById(avatar.getId());
	        assertNotNull(p);
	        gameInstanceService.deleteAll();
	        playerService.deleteAll();
	        avatarService.deleteAll();
	        Avatar del = avatarService.findById(avatar.getId());
	        assertNull(del);
	    }
	  
	  @Test
	    public void updateTest() throws Exception
	    {
	        Avatar avatar = new Avatar();
		    avatar.setGender("MALE");
		    avatar.setHairColor(HairColor.GREY);
		    avatar.setName("TOM");
		    avatar.setPlayer(player);
		    avatar.setScore(0);
		    avatar.setSkinColor(SkinColor.BLACK);
		    
	        avatar=avatarService.create(avatar);
	        Avatar p = avatarService.findById(avatar.getId());
	        p.setGender("FEMALE");
	        p.setHairColor(HairColor.BLACK);
	        p.setSkinColor(SkinColor.ASIAN);
	        
	        avatarService.update(p);
	        
	        Avatar updated = avatarService.findById(avatar.getId());
	        assertEquals("FEMALE", updated.getGender());
	        assertEquals(HairColor.BLACK, updated.getHairColor());
	        assertEquals(SkinColor.ASIAN, updated.getSkinColor());
	        
	    }
	  
	  @Test
	    public void listTest() throws Exception
	    {
		  gameInstanceService.deleteAll();
		  avatarService.deleteAll();
	        Avatar avatar = new Avatar();
		    avatar.setGender("MALE");
		    avatar.setHairColor(HairColor.GREY);
		    avatar.setName("TOM");
		    avatar.setPlayer(player);
		    avatar.setScore(0);
		    avatar.setSkinColor(SkinColor.BLACK);
	        avatar=avatarService.create(avatar);
	        Avatar avatar1 = new Avatar();
		    avatar1.setGender("MALE");
		    avatar1.setHairColor(HairColor.GREY);
		    avatar1.setName("TOM");
		    avatar1.setPlayer(player2);
		    avatar1.setScore(0);
		    avatar1.setSkinColor(SkinColor.BLACK);
	        avatar1=avatarService.create(avatar1);
	        List<Avatar> list = avatarService.findAll();
	        assertEquals(2, list.size());
	       
	       gameInstanceService.deleteAll();
	        avatarService.deleteAll();
	        
	    }


}
