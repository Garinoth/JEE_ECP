package views.beans;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import models.daos.jpa.DaoJpaFactory;
import models.entities.Theme;
import controllers.ejb.ControllerEjbFactory;

@ManagedBean(name="deleteTheme")
public class DeleteThemeView {
	
	private Integer id;
	
	@ManagedProperty(value = "#{themes}")
	private ThemesView themesView;
	private Theme theme;
	
	@ManagedProperty(value = "auth")
	private String auth;
	private static final String AUTH = "666";

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

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public ThemesView getThemesView() {
		return themesView;
	}

	public void setThemesView(ThemesView themesView) {
		this.themesView = themesView;
	}

	public void update() {
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
		if (auth.equals(AUTH)) {
			ControllerEjbFactory.getFactory().getDeleteThemeController().run(id);
		}
		return "home";
	}

}
