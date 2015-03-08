package models.daos.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.daos.DaoFactory;
import models.daos.ThemeDao;
import models.daos.VoteDao;

import org.apache.logging.log4j.LogManager;

public class DaoJpaFactory extends DaoFactory {
    private static final String PERSISTENCE_UNIT = "tictactoe";

    private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory(PERSISTENCE_UNIT);

    public DaoJpaFactory() {
        LogManager.getLogger(DaoJpaFactory.class).debug("create Entity Manager Factory");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

	@Override
	public VoteDao getVoteDao() {
		return new VoteDaoJpa();
	}

	@Override
	public ThemeDao getThemeDao() {
		return new ThemeDaoJpa();
	}

}
