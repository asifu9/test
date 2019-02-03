package com.code.game.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.game.entity.Game;
import com.code.game.enums.GameType;
import com.code.game.repository.GameRepository;
import com.code.game.service.GameService;
import com.google.gson.Gson;

/**
 * The Class GameServiceImpl.
 */
@Service
@Transactional
public class GameServiceImpl implements GameService{

	/** The game repository. */
	@Autowired
	private GameRepository gameRepository;

	/* (non-Javadoc)
	 * @see com.code.game.service.GameService#create(com.code.game.entity.Game)
	 */
	@Override
	public Game create(Game game) throws Exception {
		return gameRepository.save(game);
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.GameService#findByGameType(com.code.game.enums.GameType)
	 */
	@Override
	public List<Game> findByGameType(GameType gameType) {
		return gameRepository.findByGameType(gameType);
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.GameService#findAll()
	 */
	@Override
	public List<Game> findAll() {
		return gameRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.GameService#delete(int)
	 */
	@Override
	public void delete(int id) throws Exception {
		gameRepository.deleteById(id);
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.GameService#findById(int)
	 */
	@Override
	public Game findById(int gameId) throws Exception{
		Optional<Game> game= gameRepository.findById(gameId);
		if(game.isPresent()){
			return game.get();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.GameService#update(int, com.code.game.entity.Game)
	 */
	@Override
	public Game update(int gameId,Game game) throws Exception {
		Game updatedGame=null;
		if(game.getId()==0){
			//fetch game object
			updatedGame= gameRepository.findById(gameId).get();
			updatedGame.setName(game.getName());
			updatedGame.setPlayArea(game.getPlayArea());
			updatedGame.setGameType(game.getGameType());
		}else{
			updatedGame=game;
		}
		updatedGame=gameRepository.save(updatedGame);
		return updatedGame;
	}
	
	/* (non-Javadoc)
	 * @see com.code.game.service.GameService#deleteAll()
	 */
	@Override
	public void deleteAll() throws Exception {
		gameRepository.deleteAll();
		
	}
	
	

}
