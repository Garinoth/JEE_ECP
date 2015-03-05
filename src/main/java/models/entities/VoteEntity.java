package models.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import models.utils.Studies;

@Entity
public class VoteEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String ipUser;
	
	private Double rating;
	
	@Enumerated(EnumType.STRING)
	private Studies studies;
	
	@ManyToOne
	@JoinColumn
	private ThemeEntity theme;

	public VoteEntity() {
		
	}

	public VoteEntity(String ipUser, Double rating, Studies studies,
			ThemeEntity theme) {
		super();
		this.ipUser = ipUser;
		this.rating = rating;
		this.studies = studies;
		this.theme = theme;
	}

	public String getIpUser() {
		return ipUser;
	}

	public void setIpUser(String ipUser) {
		this.ipUser = ipUser;
	}

	public Studies getStudies() {
		return studies;
	}

	public void setStudies(Studies studies) {
		this.studies = studies;
	}

	public ThemeEntity getTheme() {
		return theme;
	}

	public void setTheme(ThemeEntity theme) {
		this.theme = theme;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getId() {
		return id;
	}
}
