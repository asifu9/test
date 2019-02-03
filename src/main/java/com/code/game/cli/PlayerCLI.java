package com.code.game.cli;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.code.game.GameApplication;
import com.code.game.entity.Player;
import com.code.game.service.PlayerService;

/**
 * The Class Player CLI.
 */
@Component
@Order(value=2)
public class PlayerCLI implements CommandLineRunner{

	/** The player service. */
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
		Player p=new Player();
		p.setFirstName("Max1");
		p.setLastName("Well");
		p.setUserName("MaxWell");
		p.setDateOfBirth(LocalDate.now().toEpochDay());
		playerService.create(p);
		
		Player p2=new Player();
		p2.setFirstName("Brain");
		p2.setLastName("Lara");
		p2.setUserName("brainLara");
		p2.setDateOfBirth(LocalDate.now().toEpochDay());
		playerService.create(p2);
	}

}
