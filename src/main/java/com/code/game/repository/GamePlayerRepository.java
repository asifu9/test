package com.code.game.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code.game.entity.GameInstance;
import com.code.game.entity.GamePlayer;
import com.code.game.entity.Player;


/**
 * The Interface GamePlayerRepository.
 */
@Repository
public interface GamePlayerRepository extends JpaRepository<GamePlayer, Integer> { 
	
	/**
	 * Find by game instance.
	 *
	 * @param gameInstanceId the game instance id
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<GamePlayer> findByGameInstance(GameInstance gameInstanceId) throws Exception;
	
	
}