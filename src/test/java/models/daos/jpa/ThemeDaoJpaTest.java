package models.daos.jpa;

import java.util.ArrayList;
import java.util.List;

import models.daos.GenericDao;
import models.entities.Theme;

import org.junit.After;

public class ThemeDaoJpaTest extends DaoJpaTest<Theme>{

	@Override
	protected ArrayList<Theme> supplyData() {
		ArrayList<Theme> data = new ArrayList<Theme>();
		data.add(new Theme("Tema 1", "Pregunta 1"));
		return data;
	}

	@Override
	protected GenericDao<Theme, Integer> supplyDao() {
		return DaoJpaFactory.getFactory().getThemeDao();
	}
	
	@Override
	protected Theme supplyUpdated(Theme e) {
		e.setName("Updated Name 1");
		e.setQuestion("Updated Question 1");
		Theme updated = new Theme("Updated Name 1", "Updated Question 1");
		return updated;
	}
	
	@Override
	protected Integer supplyId(Theme e) {
		return e.getId();
	}
	
	@After
	public void after() {
		List<Theme> entities = dao.findAll();
		for (Theme e : entities) {
			dao.deleteById(e.getId());
		}
	}	
}
