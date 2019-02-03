package com.code.game.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code.game.entity.GameInstance;



/**
 * The Interface GameInstancerRepository.
 */
@Repository
public interface GameInstancerRepository extends JpaRepository<GameInstance, Integer> {

}