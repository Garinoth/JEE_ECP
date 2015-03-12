package models.daos.jpa;

import models.entities.Theme;

import org.junit.Before;

public class ThemeDaoJpaTest extends DaoJpaTest<Theme>{
	
	@Before
	public void before() {
		super.before();
		dao = DaoJpaFactory.getFactory().getThemeDao();
		this.data.add(new Theme("Tema 1", "Pregunta 1"));
	}
}
