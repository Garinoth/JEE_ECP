package views.beans;

import java.util.List;

import models.daos.jpa.DaoJpaFactory;
import models.entities.Theme;

public class ThemesView {

	private List<Theme> themes;

	public void update() {
		this.setThemes(DaoJpaFactory.getFactory().getThemeDao().findAll());
	}
	
	public List<Theme> getThemes() {
		return themes;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}
	
}
