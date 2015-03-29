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

@ManagedBean(name="votes")
public class VotesView {

	private Integer id;
	private Theme theme;
	private Integer total;
	private Double average;
	private Double averageByStudies;
	private Studies studies;
	private Studies[] studiesOptions;

	@ManagedProperty(value = "#{themes}")
	private ThemesView themesView;
	
	public VotesView() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}

	public Double getAverageByStudies() {
		return averageByStudies;
	}

	public void setAverageByStudies(Double averageByStudies) {
		this.averageByStudies = averageByStudies;
	}

	public Studies getStudies() {
		return studies;
	}

	public void setStudies(Studies studies) {
		this.studies = studies;
	}

	public Studies[] getStudiesOptions() {
		return studiesOptions;
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
		this.setAverage(ControllerEjbFactory.getFactory().getShowVotesController().getAverage(theme));
		this.setTotal(ControllerEjbFactory.getFactory().getShowVotesController().getTotalVotes(theme));
		if (this.studies != null) {
			this.setAverageByStudies(ControllerEjbFactory.getFactory().getShowVotesController().getAverageByStudies(theme, this.studies));
		}
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
		return "votes";
	}

}
