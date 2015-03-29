package views.beans;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import models.daos.jpa.DaoJpaFactory;
import models.entities.Theme;
import models.utils.Studies;
import controllers.ejb.ControllerEjbFactory;

@ManagedBean(name="vote")
public class VoteView {

	private Integer id;
	private String ip;
	private Double rating;
	private Studies studies;
	private Studies[] studiesOptions;
	private Theme theme;
	
	@ManagedProperty(value = "#{themes}")
	private ThemesView themesView;

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

	public ThemesView getThemesView() {
		return themesView;
	}

	public void setThemesView(ThemesView themesView) {
		this.themesView = themesView;
	}

	public void update() {
		this.setStudiesOptions(Studies.values());
		this.setTheme(DaoJpaFactory.getFactory().getThemeDao().read(id));
	}
	
	@PostConstruct
	public void updateJsf() {
		if (themesView.getThemeId() != null) {
			this.setId(Integer.valueOf(themesView.getThemeId()));
		} else if (this.id == null) {
			Map<String,String> params = 
	                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = params.get("id");
			this.setId(Integer.valueOf(id));
		}
		update();
	}
	
	public String process() {
		ControllerEjbFactory.getFactory().getVoteController().run(ip, rating, studies, theme);
		return "home";
	}

}
