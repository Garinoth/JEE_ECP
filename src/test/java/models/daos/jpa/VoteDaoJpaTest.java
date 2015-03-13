package models.daos.jpa;

import java.util.ArrayList;
import java.util.List;

import models.daos.GenericDao;
import models.daos.ThemeDao;
import models.entities.Theme;
import models.entities.Vote;
import models.utils.Studies;

import org.junit.After;

public class VoteDaoJpaTest extends DaoJpaTest<Vote> {	
	
	ThemeDao daoThemes = DaoJpaFactory.getFactory().getThemeDao();
	
	@Override
	protected ArrayList<Vote> supplyData() {
		ArrayList<Vote> data = new ArrayList<Vote>();
		Theme theme = new Theme("Tema 1", "Pregunta 1");
		daoThemes.create(theme);
		data.add(new Vote("192.168.1.1", 4.3, Studies.BACHILLERATO, theme));
		return data;
	}

	@Override
	protected GenericDao<Vote, Integer> supplyDao() {
		return DaoJpaFactory.getFactory().getVoteDao();
	}

	@Override
	protected Vote supplyUpdated(Vote e) {
		Theme theme2 = new Theme("Updated Name 1", "Updated Question 1");
		daoThemes.create(theme2);
		Vote updated = new Vote("192.168.0.1", 0.0, Studies.ESO, theme2);
		e.setIpUser(updated.getIpUser());
		e.setRating(updated.getRating());
		e.setStudies(updated.getStudies());
		e.setTheme(updated.getTheme());
		return updated;
	}

	@Override
	protected Integer supplyId(Vote e) {
		return e.getId();
	}
	
	@After
	public void after() {
		List<Vote> entities = dao.findAll();
		for (Vote e : entities) {
			dao.deleteById(e.getId());
		}
		List<Theme> themes = daoThemes.findAll();
		for (Theme e : themes) {
			daoThemes.deleteById(e.getId());
		}
	}
}
