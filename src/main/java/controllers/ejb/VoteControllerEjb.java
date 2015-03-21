package controllers.ejb;

import models.daos.DaoFactory;
import models.daos.VoteDao;
import models.entities.Theme;
import models.entities.Vote;
import models.utils.Studies;

public class VoteControllerEjb implements controllers.Vote {

	@Override
	public void run(String ipUser, Double rating, Studies studies, Theme theme) {
		VoteDao dao = DaoFactory.getFactory().getVoteDao();
		Vote vote = new Vote(ipUser, rating, studies, theme);
		dao.create(vote);
	}
}
