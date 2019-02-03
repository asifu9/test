package com.code.game.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.game.entity.Avatar;
import com.code.game.entity.Player;
import com.code.game.service.AvatarService;
import com.code.game.service.PlayerService;


/**
 * Rest Controller class to create, update and list Avatars
 */
@RestController
@RequestMapping(value="/avatar")
public class AvatarApi {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(AvatarApi.class);
	
	/** The avatar service. */
	@Autowired
	private AvatarService avatarService;
	
	@Autowired
	private PlayerService playerService;
	
	/**
	 * Creates the.
	 *
	 * @param avatar the avatar
	 * @return the avatar
	 * @throws Exception the exception
	 */
	@PostMapping(value="/",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private Avatar create(@RequestBody Avatar avatar) throws Exception{
		LOGGER.debug("creating new avatar ");
		return avatarService.create(avatar);
		
	}
	
	/**
	 * Creates the.
	 *
	 * @param avatarId the avatar id
	 * @param avatar the avatar
	 * @return the avatar
	 * @throws Exception the exception
	 */
	@PutMapping(value="/{avatarId}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private Avatar create(
				@PathVariable(value="avatarId") int avatarId, 
				@RequestBody Avatar avatar) throws Exception{
		
		avatar=avatarService.update(avatar);

		return avatar;
		
	}
	
	 /* Gets the by player id.
	 *
	 * @param playerId the player id
	 * @return the by player id
	 * @throws Exception the exception
	 */
	@GetMapping(value="/{avatarId}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private Avatar getById(@PathVariable("avatarId") int avatarId) throws Exception{
		
		return avatarService.findById(avatarId);
	}
	
	/**
	 * Gets the by player id.
	 *
	 * @param playerId the player id
	 * @return the by player id
	 * @throws Exception the exception
	 */
	@GetMapping(value="/player/{playerId}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private List<Avatar> getByPlayerId(@PathVariable("playerId") int playerId) throws Exception{
		Player p=playerService.findById(playerId);
		return avatarService.findByPlayerId(p);
	}
	
	/**
	 * Gets the by player id.
	 *
	 * @param playerId the player id
	 * @return the by player id
	 * @throws Exception the exception
	 */
	@DeleteMapping(value="/{avatarId}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private void deleteBYId(@PathVariable("avatarId") int avatarId) throws Exception{
		
		 avatarService.delete(avatarId);
	}
	
	/**
	 * Gets the all avatars
	 *
	 * @param playerId the player id
	 * @return the by player id
	 * @throws Exception the exception
	 */
	@GetMapping(value="/",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private List<Avatar> getAll() throws Exception{
		return avatarService.findAll();
	}
}
