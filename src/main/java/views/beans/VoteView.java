package views.beans;

import models.daos.jpa.DaoJpaFactory;
import models.entities.Theme;
import models.utils.Studies;
import controllers.ejb.ControllerEjbFactory;

public class VoteView {

	private Integer id;
	private String ip;
	private Double rating;
	private Studies studies;
	private Studies[] studiesOptions;
	private Theme theme;

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}
	
	public Studies getStudies() {
		return this.studies;
	}

	public void setStudies(Studies studies) {
		this.studies = studies;
	}
	
	public Studies[] getStudiesOptions() {
		return this.studiesOptions;
	}

	public void setStudiesOptions(Studies[] studiesOptions) {
		this.studiesOptions = studiesOptions;
	}

	public void update() {
		this.setStudiesOptions(Studies.values());
		this.setTheme(DaoJpaFactory.getFactory().getThemeDao().read(id));
	}
	
	public String process() {
		ControllerEjbFactory.getFactory().getVoteController().run(ip, rating, studies, theme);
		return "home";
	}

}
