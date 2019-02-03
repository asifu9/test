package com.code.game.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.code.game.enums.GameStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;

// TODO: Auto-generated Javadoc
/**
 * Entity Class to represent Game Instance table.
 */
@Entity
@Table(name="GAME_INSTANCE")
public class GameInstance implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7711991132251014108L;

	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	/** The play area. */
	@OneToOne
	@JoinColumn(name = "PLAY_AREA_ID")
	private PlayArea playArea;
	
	/** The game. */
	@OneToOne
	@JoinColumn(name = "GAME_ID")
	private Game game;
	
	/** The game players. */
	@Column(nullable=false,name="GAME_PLAYERS")
	@JsonManagedReference
	@OneToMany(mappedBy="gameInstance",cascade = CascadeType.ALL,orphanRemoval=true)
	private List<GamePlayer> gamePlayers;
	
	/** The status. */
	@Column(nullable=false,name="GAME_STATUS")
	@Enumerated(EnumType.STRING)
	private GameStatus status;

	/**
	 * Instantiates a new game instance.
	 */
	public GameInstance() {
		super();
	}

	
	/**
	 * Instantiates a new game instance.
	 *
	 * @param playArea the play area
	 * @param game the game
	 * @param gamePlayers the game players
	 * @param status the status
	 */
	public GameInstance(PlayArea playArea, Game game, List<GamePlayer> gamePlayers, GameStatus status) {
		super();
		this.playArea = playArea;
		this.game = game;
		this.gamePlayers = gamePlayers;
		this.status = status;
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
	 * Gets the game players.
	 *
	 * @return the game players
	 */
	public List<GamePlayer> getGamePlayers() {
		return gamePlayers;
	}

	/**
	 * Sets the game players.
	 *
	 * @param gamePlayers the new game players
	 */
	public void setGamePlayers(List<GamePlayer> gamePlayers) {
		this.gamePlayers = gamePlayers;
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
	 * Adds the player.
	 *
	 * @param gamePlayer the game player
	 */
	public void addPlayer(GamePlayer gamePlayer){
		if(!gamePlayers.contains(gamePlayer)){
			gamePlayers.add(gamePlayer);
		}
	}

	/**
	 * Gets the play area.
	 *
	 * @return the play area
	 */
	public PlayArea getPlayArea() {
		return playArea;
	}

	/**
	 * Sets the play area.
	 *
	 * @param playArea the new play area
	 */
	public void setPlayArea(PlayArea playArea) {
		this.playArea = playArea;
	}

	/**
	 * Gets the game.
	 *
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * Sets the game.
	 *
	 * @param game the new game
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	

}
