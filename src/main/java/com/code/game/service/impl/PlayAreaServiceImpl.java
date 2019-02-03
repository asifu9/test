package com.code.game.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.game.entity.PlayArea;
import com.code.game.enums.GameType;
import com.code.game.repository.PlayAreaRepository;
import com.code.game.service.PlayAreaService;

/**
 * The Class GameMapServiceImpl.
 */
@Service
@Transactional
public class PlayAreaServiceImpl implements PlayAreaService{

	/** The game map repository. */
	@Autowired
	private PlayAreaRepository playAreaRepository;

	/* (non-Javadoc)
	 * @see com.code.game.service.PlayAreaService#create(com.code.game.entity.PlayArea)
	 */
	@Override
	public PlayArea create(PlayArea playArea) throws Exception {
		return playAreaRepository.save(playArea);
	}
	
	/* (non-Javadoc)
	 * @see com.code.game.service.PlayAreaService#update(int, com.code.game.entity.PlayArea)
	 */
	@Override
	public PlayArea update(int playAreaId,PlayArea playArea) throws Exception {
		PlayArea updatePlayArea=null;
		if(playArea.getId()==0){
			updatePlayArea = playAreaRepository.findById(playAreaId).get();
			updatePlayArea.setGameType(playArea.getGameType());
			updatePlayArea.setName(playArea.getName());
			updatePlayArea.setNumberOfPlayer(playArea.getNumberOfPlayer());
		}else{
			updatePlayArea=playArea;
		}
		return playAreaRepository.save(playArea);
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.PlayAreaService#findByGameType(com.code.game.enums.GameType)
	 */
	@Override
	public List<PlayArea> findByGameType(GameType gameType) throws Exception{
		return playAreaRepository.findByGameType(gameType);
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.PlayAreaService#findAll()
	 */
	@Override
	public List<PlayArea> findAll() {
		return playAreaRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.PlayAreaService#delete(int)
	 */
	@Override
	public void delete(int id) throws Exception {
		playAreaRepository.deleteById(id);
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.PlayAreaService#findById(int)
	 */
	@Override
	public PlayArea findById(int playAreaId) throws Exception {
		Optional<PlayArea> playArea= playAreaRepository.findById(playAreaId);
		if(playArea.isPresent()){
			return playArea.get();
		}
		return null;
	
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.PlayAreaService#deleteAll()
	 */
	@Override
	public void deleteAll() throws Exception {
		playAreaRepository.deleteAll();
		
	}
	
}
