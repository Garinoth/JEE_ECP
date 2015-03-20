package views.beans;

import models.daos.jpa.DaoJpaFactory;
import models.entities.Theme;
import controllers.ejb.ControllerEjbFactory;

public class DeleteThemeView {
	
	private Integer id;
	private Theme theme;
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


	public void update() {
		this.setTheme(DaoJpaFactory.getFactory().getThemeDao().read(id));
	}
	
	public String process() {
		if (auth.equals(AUTH)) {
			ControllerEjbFactory.getFactory().getDeleteThemeController().run(id);
		}
		return "home";
	}

}
