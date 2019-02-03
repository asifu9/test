package com.code.game.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code.game.entity.PlayArea;
import com.code.game.enums.GameType;


/**
 * The Interface GameMapRepository.
 */
@Repository
public interface PlayAreaRepository extends JpaRepository<PlayArea, Integer> { 
	
	/**
	 * Find by game type.
	 *
	 * @param gameType the game type
	 * @return the list
	 * @throws Exception the exception
	 */
	List<PlayArea> findByGameType(GameType gameType) throws Exception;
}