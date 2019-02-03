package com.code.game.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code.game.entity.Player;



/**
 * The Interface PlayerRepository.
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> { 

}