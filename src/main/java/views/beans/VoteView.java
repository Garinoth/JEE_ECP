package views.beans;

import controllers.ejb.ControllerEjbFactory;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Theme;
import models.utils.Studies;

public class VoteView {

	private Integer id;
	private String ip;
	private Double rating;
	private Studies studies;
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
		return studies;
	}

	public void setStudies(Studies studies) {
		this.studies = studies;
	}

	public void update() {
		this.setTheme(DaoJpaFactory.getFactory().getThemeDao().read(id));
	}
	
	public String process() {
		ControllerEjbFactory.getFactory().getVoteController().run(ip, rating, studies, theme);
		return "home";
	}

}
