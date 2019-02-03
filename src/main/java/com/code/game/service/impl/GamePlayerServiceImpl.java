package com.code.game.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.game.entity.GamePlayer;
import com.code.game.repository.GamePlayerRepository;
import com.code.game.service.GameInstanceService;
import com.code.game.service.GamePlayerService;

/**
 * The Class GamePlayerServiceImpl.
 */
@Service
@Transactional
public class GamePlayerServiceImpl implements GamePlayerService{

	/** The game player repository. */
	@Autowired
	private GamePlayerRepository gamePlayerRepository;
	
	/** The game instance service. */
	@Autowired
	private GameInstanceService gameInstanceService;

	/* (non-Javadoc)
	 * @see com.code.game.service.GamePlayerService#create(com.code.game.entity.GamePlayer)
	 */
	@Override
	public GamePlayer create(GamePlayer gamePlayer) throws Exception {
		
		return gamePlayerRepository.save(gamePlayer);
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.GamePlayerService#update(com.code.game.entity.GamePlayer)
	 */
	@Override
	public GamePlayer update(GamePlayer gamePlayer) throws Exception {
		// TODO Auto-generated method stub
		return gamePlayerRepository.save(gamePlayer);
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.GamePlayerService#delete(int)
	 */
	@Override
	public void delete(int id) throws Exception {
		gamePlayerRepository.deleteById(id);
		
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.GamePlayerService#findById(int)
	 */
	@Override
	public GamePlayer findById(int id) throws Exception {
		// TODO Auto-generated method stub
		Optional<GamePlayer> gamePlayer= gamePlayerRepository.findById(id);
		if(gamePlayer.isPresent()){
			return gamePlayer.get();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.GamePlayerService#deleteAll()
	 */
	@Override
	public void deleteAll() throws Exception {
		gamePlayerRepository.deleteAll();
		
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.GamePlayerService#findByGameInstanceId(int)
	 */
	@Override
	public List<GamePlayer> findByGameInstanceId(int gameInstanceId) throws Exception {
		// TODO Auto-generated method stub
		return gamePlayerRepository.findByGameInstance(gameInstanceService.findById(gameInstanceId));
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.GamePlayerService#findAll()
	 */
	@Override
	public List<GamePlayer> findAll() throws Exception {
		
		return gamePlayerRepository.findAll();
	}
	
	

}
