package com.code.game.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.game.entity.Player;
import com.code.game.repository.PlayerRepository;
import com.code.game.service.PlayerService;

/**
 * The Class PlayerServiceImpl.
 */
@Service
@Transactional
public class PlayerServiceImpl implements PlayerService{

	/** The player repository. */
	@Autowired
	private PlayerRepository playerRepository;
	
	/* (non-Javadoc)
	 * @see com.code.game.service.PlayerService#create(com.code.game.entity.Player)
	 */
	@Override
	public Player create(Player player) throws Exception {
		return playerRepository.save(player);
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.PlayerService#update(com.code.game.entity.Player)
	 */
	@Override
	public Player update(Player player) throws Exception {
		// TODO Auto-generated method stub
		return playerRepository.save(player);
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.PlayerService#fetchAll()
	 */
	@Override
	public List<Player> fetchAll() throws Exception {
		return playerRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.PlayerService#delete(int)
	 */
	@Override
	public void delete(int id) throws Exception {
		playerRepository.deleteById(id);
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.PlayerService#findById(int)
	 */
	@Override
	public Player findById(int id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Player> player= playerRepository.findById(id);
		if(player.isPresent()){
			return player.get();
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.code.game.service.PlayerService#deleteAll()
	 */
	@Override
	public void deleteAll() throws Exception {
		playerRepository.deleteAll();
		
	}
	

}
