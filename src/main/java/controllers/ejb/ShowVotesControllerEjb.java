package controllers.ejb;

import java.util.List;

import models.daos.DaoFactory;
import models.daos.VoteDao;
import models.entities.Theme;
import models.entities.Vote;
import models.utils.Studies;
import controllers.ShowVotes;

public class ShowVotesControllerEjb implements ShowVotes {

	@Override
	public Double getAverage(Theme theme) {
		VoteDao dao = DaoFactory.getFactory().getVoteDao();
		List<Vote> votes = dao.findAll();
		Double result = 0.0;
		int quantity = 0;
		for (Vote vote : votes) {
			if (vote.getTheme().equals(theme)) {
				result += vote.getRating();
				quantity++;
			}
		}
		result = quantity == 0 ? 0 : result / quantity;
		return result;
	}

	@Override
	public Integer getTotalVotes(Theme theme) {
		VoteDao dao = DaoFactory.getFactory().getVoteDao();
		List<Vote> votes = dao.findAll();
		int quantity = 0;
		for (Vote vote : votes) {
			if (vote.getTheme().equals(theme)) {
				quantity++;
			}
		}
		return quantity;
	}

	@Override
	public Double getAverageByStudies(Theme theme, Studies studies) {
		VoteDao dao = DaoFactory.getFactory().getVoteDao();
		List<Vote> votes = dao.findAll();
		Double result = 0.0;
		int quantity = 0;
		for (Vote vote : votes) {
			if (vote.getTheme().equals(theme) && vote.getStudies() == studies) {
				result += vote.getRating();
				quantity++;
			}
		}
		result = quantity == 0 ? 0 : result / quantity;
		return result;
	}

}
