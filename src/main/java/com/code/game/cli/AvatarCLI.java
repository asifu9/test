package com.code.game.cli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.code.game.GameApplication;
import com.code.game.entity.Avatar;
import com.code.game.enums.HairColor;
import com.code.game.enums.SkinColor;
import com.code.game.service.AvatarService;
import com.code.game.service.PlayerService;

/**
 * The Class AvatarCLI.
 */
@Component
@Order(value = 3)
public class AvatarCLI implements CommandLineRunner {

	/** The avatar service. */
	@Autowired
	private AvatarService avatarService;
	
	@Autowired
	private PlayerService playerService;
	
	@Value("${game.populate.default.data}")
	public  boolean INITIALIZE_DEFAULT_DATA;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		System.out.println("value is " + INITIALIZE_DEFAULT_DATA);
		if (!INITIALIZE_DEFAULT_DATA) {
			return;
		}

		Avatar p = new Avatar();
		p.setGender("MALE");
		p.setHairColor(HairColor.BLACK);
		p.setName("Tom");
		p.setPlayer(playerService.findById(1));
		p.setScore(0);
		p.setSkinColor(SkinColor.WHITE);
		avatarService.create(p);

		Avatar avatar2 = new Avatar();
		avatar2.setGender("FEMALE");
		avatar2.setHairColor(HairColor.GREY);
		avatar2.setName("Sahera");
		avatar2.setPlayer(playerService.findById(2));
		avatar2.setScore(0);
		avatar2.setSkinColor(SkinColor.ASIAN);
		avatarService.create(avatar2);

	}

}
