package com.code.game.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.code.game.enums.GameStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * Entity Class to represent Game Player table.
 */
@Entity
@Table(name="GAME_PLAYER")
public class GamePlayer implements Serializable{


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6206012906416907040L;

	/** The id. */
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	/** The avatar id. */
	@ManyToOne
	@JoinColumn(name = "AVATAR_ID")
	private Avatar avatar;
	
	
	/** The is initiator. */
	@Column(name="IS_INITIATOR")
	private boolean isInitiator;
	
	/** The created on. */
	@Column(name="CREATED_ON")
	private long createdOn;
	
	/** The score. */
	@Column(name="SCORE")
	private float score;
	
	/** The pause at. */
	@Column(name="SAVED_STATE")
	private int savedState;
	
	/** The status. */
	@Column(name="STATUS")
	@Enumerated(EnumType.STRING)
	private GameStatus status;
	
	/** The game instance. */
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "gameInstanceId")
	private GameInstance gameInstance;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	

	/**
	 * Gets the avatar.
	 *
	 * @return the avatar
	 */
	public Avatar getAvatar() {
		return avatar;
	}

	public GamePlayer() {
		super();
	}

	/**
	 * Instantiates a new game player.
	 *
	 * @param player the player
	 * @param avatar the avatar
	 * @param status the status
	 * @param gameInstance the game instance
	 */
	public GamePlayer(Avatar avatar, GameStatus status, GameInstance gameInstance) {
		super();
		this.avatar = avatar;
		this.status = status;
		this.gameInstance = gameInstance;
	}

	/**
	 * Sets the avatar.
	 *
	 * @param avatar the new avatar
	 */
	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	/**
	 * Checks if is initiator.
	 *
	 * @return true, if is initiator
	 */
	public boolean isInitiator() {
		return isInitiator;
	}

	/**
	 * Sets the initiator.
	 *
	 * @param isInitiator the new initiator
	 */
	public void setInitiator(boolean isInitiator) {
		this.isInitiator = isInitiator;
	}

	/**
	 * Gets the created on.
	 *
	 * @return the created on
	 */
	public long getCreatedOn() {
		return createdOn;
	}

	/**
	 * Sets the created on.
	 *
	 * @param createdOn the new created on
	 */
	public void setCreatedOn(long createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public float getScore() {
		return score;
	}

	/**
	 * Sets the score.
	 *
	 * @param score the new score
	 */
	public void setScore(float score) {
		this.score = score;
	}

	/**
	 * Gets the saved state.
	 *
	 * @return the saved state
	 */
	public int getSavedState() {
		return savedState;
	}

	/**
	 * Sets the saved state.
	 *
	 * @param savedState the new saved state
	 */
	public void setSavedState(int savedState) {
		this.savedState = savedState;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public GameStatus getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(GameStatus status) {
		this.status = status;
	}

	/**
	 * Gets the game instance.
	 *
	 * @return the game instance
	 */
	public GameInstance getGameInstance() {
		return gameInstance;
	}

	/**
	 * Sets the game instance.
	 *
	 * @param gameInstance the new game instance
	 */
	public void setGameInstance(GameInstance gameInstance) {
		this.gameInstance = gameInstance;
	}
}
