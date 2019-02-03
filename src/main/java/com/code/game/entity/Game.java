package com.code.game.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.code.game.enums.GameType;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * Entity Class to represent Game table.
 */
@Entity
@Table(name="GAME")
public class Game implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5353654512648431306L;

	/** The game id. */
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	/** The name. */
	@Column(nullable=false,name="NAME")
	private String name;
	
	/** The game types. */
	@Enumerated(EnumType.STRING)
	@Column(name="GAME_TYPE")
	private GameType gameType;
	
	

	
	/** The game players. */
	@Column(name="PLAY_AREA")
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,targetEntity=PlayArea.class)
	private List<PlayArea> playArea;
	
	
	
	/**
	 * Instantiates a new game.
	 */
	public Game(){
		
	}

	/**
	 * Instantiates a new game.
	 *
	 * @param name the name
	 * @param gameTypes the game types
	 */
	public Game(String name, GameType gameTypes) {
		super();
		this.name = name;
		this.gameType = gameTypes;
	}
	
	/**
	 * Instantiates a new game.
	 *
	 * @param name the name
	 * @param gameTypes the game types
	 * @param playAreas the play areas
	 */
	public Game(String name, GameType gameTypes,List<PlayArea> playAreas) {
		super();
		this.name = name;
		this.gameType = gameTypes;
		this.playArea = playAreas;
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
	 * Gets the game types.
	 *
	 * @return the game types
	 */
	public GameType getGameType() {
		return gameType;
	}

	/**
	 * Sets the game types.
	 *
	 * @param gameTypes the new game types
	 */
	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}

	/**
	 * Gets the play areas.
	 *
	 * @return the play areas
	 */
	public List<PlayArea> getPlayArea() {
		return playArea;
	}

	/**
	 * Sets the play areas.
	 *
	 * @param playAreas the new play areas
	 */
	public void setPlayArea(List<PlayArea> playAreas) {
		this.playArea = playAreas;
	}
	
}
