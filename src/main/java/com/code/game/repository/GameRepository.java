package com.code.game.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code.game.entity.Game;
import com.code.game.enums.GameType;


/**
 * The Interface GameRepository.
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Integer> { 
	
	/**
	 * Find by game types.
	 *
	 * @param gameTypes the game types
	 * @return the list
	 */
	List<Game> findByGameType(GameType gameType);
}