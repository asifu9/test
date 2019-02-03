package com.code.game.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code.game.entity.Avatar;
import com.code.game.entity.Player;




/**
 * The Interface AvatarRepository.
 */
@Repository
public interface AvatarRepository extends JpaRepository<Avatar, Integer> { 
	
	/**
	 * Find by player id.
	 *
	 * @param playerId the player id
	 * @return the list
	 * @throws Exception the exception
	 */
	List<Avatar> findByPlayer(Player playerId) throws Exception;
}