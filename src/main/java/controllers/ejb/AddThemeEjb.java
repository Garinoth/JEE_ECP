package controllers.ejb;

import models.daos.DaoFactory;
import models.daos.ThemeDao;
import models.entities.Theme;
import controllers.AddTheme;

public class AddThemeEjb implements AddTheme {

	@Override
	public void run(String name, String question) {
		ThemeDao dao = DaoFactory.getFactory().getThemeDao();
		Theme theme = new Theme(name, question);
		dao.create(theme);
	}

}
