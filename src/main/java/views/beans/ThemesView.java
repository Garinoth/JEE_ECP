package views.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import models.daos.DaoFactory;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Theme;

@ManagedBean(name = "themes")
public class ThemesView {

	private List<Theme> themes;

	@PostConstruct
	public void update() {
		DaoFactory.setFactory(new DaoJpaFactory());
		this.setThemes(DaoJpaFactory.getFactory().getThemeDao().findAll());
	}
	
	public List<Theme> getThemes() {
		return themes;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}
	
}
