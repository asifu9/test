package com.code.game.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.game.entity.Avatar;
import com.code.game.entity.GameInstance;
import com.code.game.entity.GamePlayer;
import com.code.game.enums.GameStatus;
import com.code.game.repository.GameInstancerRepository;
import com.code.game.service.AvatarService;
import com.code.game.service.GameInstanceService;
import com.code.game.service.GamePlayerService;

import javassist.NotFoundException;

/**
 * The Class GameInstanceServiceImpl.
 */
@Service
@Transactional
public class GameInstanceServiceImpl implements GameInstanceService{

	/** The game instance repo. */
	@Autowired
	private GameInstancerRepository gameInstanceRepo;
	
	/** The avatar service. */
	@Autowired
	private AvatarService avatarService;
	
	/** The game player service. */
	@Autowired
	private GamePlayerService gamePlayerService;
	

	/* (non-Javadoc)
	 * @see com.code.game.service.GameInstanceService#create(com.code.game.entity.GameInstance)
	 */
	@Override
	public GameInstance create(GameInstance gameInstance) throws Exception {
		return gameInstanceRepo.save(gameInstance);
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.GameInstanceService#update(int, com.code.game.entity.GameInstance)
	 */
	@Override
	public GameInstance update(int id,GameInstance gameInstance) throws Exception {
		GameInstance updateGameInstance=gameInstanceRepo.findById(id).get();
		GameInstance temp=null;
		if(gameInstance.getId()==0){
			temp=gameInstanceRepo.findById(id).get();
			if(null==temp){
				throw new NotFoundException("Game Instance not found for id " + id);
			}
			temp.setGame(gameInstance.getGame());
			temp.setPlayArea(gameInstance.getPlayArea());
			temp.setGamePlayers(gameInstance.getGamePlayers());
			temp.setStatus(gameInstance.getStatus());
			temp.setGame(gameInstance.getGame());
		}else{
			temp=gameInstance;
		}
		boolean isAllPlayerFinished=true;
		for(GamePlayer p:updateGameInstance.getGamePlayers()){
			if(!(p.getStatus()==GameStatus.END||p.getStatus()==GameStatus.CANCELED)){
				isAllPlayerFinished=false;
			}
		}
		if(isAllPlayerFinished){
			temp.setStatus(GameStatus.END);
		}
		
		return gameInstanceRepo.save(temp);
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.GameInstanceService#findById(int)
	 */
	@Override
	public GameInstance findById(int id) throws Exception {
		Optional<GameInstance> gameInstance= gameInstanceRepo.findById(id);
		if(gameInstance.isPresent()){
			return gameInstance.get();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.GameInstanceService#findAll()
	 */
	@Override
	public List<GameInstance> findAll() throws Exception {
		return gameInstanceRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.GameInstanceService#delete(int)
	 */
	@Override
	public void delete(int id) throws Exception {
		gameInstanceRepo.deleteById(id);
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.GameInstanceService#updateStatus(int, com.code.game.enums.GameStatus)
	 */
	@Override
	public boolean updateStatus(int id, GameStatus status) throws Exception{
		// TODO Auto-generated method stub
		GameInstance instance= gameInstanceRepo.findById(id).get();
		instance.setStatus(status);
		
		gameInstanceRepo.save(instance);
		return true;
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.GameInstanceService#updateAvatar(int, float)
	 */
	@Override
	public void updateAvatar(int avatarId, float score) throws Exception{
		Avatar avatar = avatarService.findById(avatarId);
		avatar.setScore(avatar.getScore()+score);

		avatar.setTotalPlayedGames(avatar.getTotalPlayedGames()+1);
		avatarService.update(avatar);
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.GameInstanceService#updateStatusOnEnd(int)
	 */
	@Override
	public synchronized void  updateStatusOnEnd(int id) throws Exception {
		GameInstance instance= gameInstanceRepo.findById(id).get();
		boolean isAllPlayerFinished=true;
		for(GamePlayer p:instance.getGamePlayers()){
			if(!(p.getStatus()==GameStatus.END||p.getStatus()==GameStatus.CANCELED)){
				isAllPlayerFinished=false;
				
			}
		}
		if(isAllPlayerFinished){
			instance.setStatus(GameStatus.END);
			gameInstanceRepo.save(instance);
		}
		
		
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.GameInstanceService#updatePlayerStatus(int, com.code.game.enums.GameStatus)
	 */
	@Override
	public void updatePlayerStatus(int id, GameStatus status) throws Exception{
		GamePlayer player= gamePlayerService.findById(id);
		player.setStatus(status);
		gamePlayerService.update(player);
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.GameInstanceService#deleteAll()
	 */
	@Override
	public void deleteAll() throws Exception {
		gameInstanceRepo.deleteAll();
	}

	@Override
	public void updateExperience(int id, float incrementValue) throws Exception{
		Avatar avatar = avatarService.findById(id);
		float result=avatar.getExperience()+incrementValue;
		avatar.setExperience(result);
		avatarService.update(avatar);
	}





}
