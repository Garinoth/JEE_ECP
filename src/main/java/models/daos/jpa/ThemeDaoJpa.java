package models.daos.jpa;

import models.daos.ThemeDao;
import models.entities.Theme;

public class ThemeDaoJpa extends GenericDaoJpa<Theme, Integer> implements ThemeDao {
	public ThemeDaoJpa() {
		super(Theme.class);
	}
}
