package views.beans;

import controllers.ejb.ControllerEjbFactory;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Theme;
import models.entities.Vote;
import models.utils.Studies;

public class VotesView {

	private Integer id;
	private Theme theme;
	private Integer total;
	private Double average;
	private Double averageByStudies;
	private Studies studies;
	private Studies[] studiesOptions;

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

	public void update() {
		this.setStudiesOptions(Studies.values());
		this.setTheme(DaoJpaFactory.getFactory().getThemeDao().read(id));
		this.setAverage(ControllerEjbFactory.getFactory().getShowVotesController().getAverage(theme));
		this.setTotal(ControllerEjbFactory.getFactory().getShowVotesController().getTotalVotes(theme));
		if (this.studies != null) {
			this.setAverageByStudies(ControllerEjbFactory.getFactory().getShowVotesController().getAverageByStudies(theme, this.studies));
		}
	}

}
