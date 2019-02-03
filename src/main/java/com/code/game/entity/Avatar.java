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

import com.code.game.enums.HairColor;
import com.code.game.enums.SkinColor;
import com.fasterxml.jackson.annotation.JsonBackReference;

// TODO: Auto-generated Javadoc
/**
 * Entity Class to represent Avatar table.
 */
@Entity
@Table(name="AVATAR")
public class Avatar implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8285944745581375621L;

	/** The id. */
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	/** The name. */
	@Column(nullable=false,name="NAME")
	private String name;
	
	/** The hair color. */
	@Enumerated(EnumType.STRING)
	@Column(name="HAIR_COLOR")
	private HairColor hairColor;
	
	/** The skin color. */
	@Enumerated(EnumType.STRING)
	@Column(name="SKIN_COLOR")
	private SkinColor skinColor;
	
	/** The gender. */
	@Column(nullable=false,name="GENDER")
	private String gender;
	
	
	/** The score. */
	@Column(name="SCORE")
	private float score;
	
	/** The score. */
	@Column(name="EXPERIENCE")
	private float experience=1f;
	
	/** The game instance. */
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "playerId")
	private Player player;


	/**
	 * Instantiates a new avatar.
	 *
	 * @param name the name
	 * @param hairColor the hair color
	 * @param skinColor the skin color
	 * @param gender the gender
	 */
	public Avatar(String name, HairColor hairColor, SkinColor skinColor, String gender) {
		this.name = name;
		this.hairColor = hairColor;
		this.skinColor = skinColor;
		this.gender = gender;
	}


	/**
	 * Gets the player.
	 *
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}


	/**
	 * Sets the player.
	 *
	 * @param player the new player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}


	/** The total played games. */
	@Column(name="TOTAL_GAMES_PLAYED")
	private int totalPlayedGames;
	
	/**
	 * Instantiates a new avatar.
	 */
	public Avatar(){
		
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
	 * Gets the hair color.
	 *
	 * @return the hair color
	 */
	public HairColor getHairColor() {
		return hairColor;
	}

	/**
	 * Sets the hair color.
	 *
	 * @param hairColor the new hair color
	 */
	public void setHairColor(HairColor hairColor) {
		this.hairColor = hairColor;
	}

	/**
	 * Gets the skin color.
	 *
	 * @return the skin color
	 */
	public SkinColor getSkinColor() {
		return skinColor;
	}

	/**
	 * Sets the skin color.
	 *
	 * @param skinColor the new skin color
	 */
	public void setSkinColor(SkinColor skinColor) {
		this.skinColor = skinColor;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
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
	 * Gets the total played games.
	 *
	 * @return the total played games
	 */
	public int getTotalPlayedGames() {
		return totalPlayedGames;
	}


	/**
	 * Gets the experience.
	 *
	 * @return the experience
	 */
	public float getExperience() {
		return experience;
	}


	/**
	 * Sets the experience.
	 *
	 * @param experience the new experience
	 */
	public void setExperience(float experience) {
		this.experience = experience;
	}


	/**
	 * Sets the total played games.
	 *
	 * @param totalPlayedGames the new total played games
	 */
	public void setTotalPlayedGames(int totalPlayedGames) {
		this.totalPlayedGames = totalPlayedGames;
	}
	
	
}
