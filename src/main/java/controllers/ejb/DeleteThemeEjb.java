package controllers.ejb;

import models.daos.DaoFactory;
import models.daos.ThemeDao;
import controllers.DeleteTheme;

public class DeleteThemeEjb implements DeleteTheme {

	@Override
	public void run(Integer id) {
		ThemeDao dao = DaoFactory.getFactory().getThemeDao();
		dao.deleteById(id);
	}

}
