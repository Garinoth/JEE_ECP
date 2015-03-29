package views.beans;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import models.daos.DaoFactory;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Theme;

@ManagedBean(name = "themes")
@RequestScoped
public class ThemesView {
	
	private String themeId;
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
	
	public String getThemeId() {
		return themeId;
	}

	public void setThemeId(String themeId) {
		this.themeId = themeId;
	}

	public String deleteTheme() {
		Map<String,String> params = 
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String themeId = params.get("themeId");
		this.setThemeId(themeId);
		return "deleteTheme";
	}
	
}
