package com.code.game.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.game.entity.Avatar;
import com.code.game.entity.Player;
import com.code.game.repository.AvatarRepository;
import com.code.game.service.AvatarService;

/**
 * The Class AvatarServiceImpl.
 */
@Service
@Transactional
public class AvatarServiceImpl implements AvatarService{

	/** The avatar repository. */
	@Autowired
	private AvatarRepository avatarRepository;
	
	/* (non-Javadoc)
	 * @see com.code.game.service.AvatarService#create(com.code.game.entity.Avatar)
	 */
	@Override
	@Transactional
	public Avatar create(Avatar avatar) throws Exception {
		return avatarRepository.save(avatar);
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.AvatarService#update(com.code.game.entity.Avatar)
	 */
	@Override
	public Avatar update(Avatar avatar) throws Exception {
		return avatarRepository.save(avatar);
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.AvatarService#findByPlayerId(int)
	 */
	@Override
	public List<Avatar> findByPlayerId(Player playerId) throws Exception {
		return avatarRepository.findByPlayer(playerId);
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.AvatarService#delete(int)
	 */
	@Override
	public void delete(int id) throws Exception {
		avatarRepository.deleteById(id);
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.AvatarService#findById(int)
	 */
	@Override
	public Avatar findById(int id) throws Exception {
		Optional<Avatar> avatar= avatarRepository.findById(id);
		if(avatar.isPresent()){
			return avatar.get();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.AvatarService#findAll()
	 */
	@Override
	public List<Avatar> findAll() throws Exception {
		// TODO Auto-generated method stub
		return avatarRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.code.game.service.AvatarService#deleteAll()
	 */
	@Override
	public void deleteAll() throws Exception {
		avatarRepository.deleteAll();
		
	}

}
