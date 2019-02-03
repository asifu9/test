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
import javax.persistence.Table;

import com.code.game.enums.GameType;
import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Entity Class to represent Play Area table.
 */
@Entity
@Table(name="PLAY_AREA")
public class PlayArea implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -888458079923097015L;

	/** The map id. */
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	/** The name. */
	@Column(name="NAME",nullable=false)
	private String name;
	
	/** The game type. */
	@Enumerated(EnumType.STRING)
	@Column(name="GAME_TYPE")
	private GameType gameType;
	
	
	/** The number of player. */
	@Column(name="NUM_OF_PLAYERS")
	private int numberOfPlayer;

	/** The min score. */
	@Column(name="MIN_SCORE")
	private int minScore;
	
	/** The max score. */
	@Column(name="MAX_SCORE")
	private int maxScore;
	
	/** The max score. */
	@Column(name="GAME_LENGTH")
	private int gameLength;
	


	

	/**
	 * Instantiates a new play area.
	 */
	public PlayArea() {
		super();
	}


	/**
	 * Instantiates a new play area.
	 *
	 * @param name the name
	 * @param gameType the game type
	 * @param numberOfPlayer the number of player
	 */
	public PlayArea(String name, GameType gameType, int numberOfPlayer,int gameLength) {
		super();
		this.name = name;
		this.gameType = gameType;
		this.numberOfPlayer = numberOfPlayer;
		this.gameLength = gameLength;
	}


	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Gets the game type.
	 *
	 * @return the game type
	 */
	public GameType getGameType() {
		return gameType;
	}


	/**
	 * Sets the game type.
	 *
	 * @param gameType the new game type
	 */
	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}


	/**
	 * Gets the number of player.
	 *
	 * @return the number of player
	 */
	public int getNumberOfPlayer() {
		return numberOfPlayer;
	}


	/**
	 * Sets the number of player.
	 *
	 * @param numberOfPlayer the new number of player
	 */
	public void setNumberOfPlayer(int numberOfPlayer) {
		this.numberOfPlayer = numberOfPlayer;
	}


	/**
	 * Gets the min score.
	 *
	 * @return the min score
	 */
	public int getMinScore() {
		return minScore;
	}


	/**
	 * Sets the min score.
	 *
	 * @param minScore the new min score
	 */
	public void setMinScore(int minScore) {
		this.minScore = minScore;
	}


	/**
	 * Gets the max score.
	 *
	 * @return the max score
	 */
	public int getMaxScore() {
		return maxScore;
	}


	/**
	 * Sets the max score.
	 *
	 * @param maxScore the new max score
	 */
	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}


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


	public int getGameLength() {
		return gameLength;
	}


	public void setGameLength(int gameLength) {
		this.gameLength = gameLength;
	}
	
	
	
}
