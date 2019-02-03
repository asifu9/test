package com.code.game;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The Class GameApplication.
 */
@SpringBootApplication
@ComponentScan("com.code")
public class GameApplication {

	
	/** The initialize default data. */
	@Value("${game.populate.default.data}")
	public  boolean INITIALIZE_DEFAULT_DATA;
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(GameApplication.class, args);
		
	}
}

