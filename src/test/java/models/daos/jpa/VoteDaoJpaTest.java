package models.daos.jpa;

import models.daos.VoteDao;
import models.entities.Theme;
import models.entities.Vote;
import models.utils.Studies;

import org.junit.Before;

public class VoteDaoJpaTest extends DaoJpaTest<Vote> {	
	
	VoteDao dao = DaoJpaFactory.getFactory().getVoteDao();
	
	@Before
	public void before() {
		super.before();
		dao = DaoJpaFactory.getFactory().getVoteDao();
		this.data.add(new Vote("192.168.1.1", 4.3, Studies.BACHILLERATO, new Theme("Tema 1", "Pregunta 1")));
	}
}
