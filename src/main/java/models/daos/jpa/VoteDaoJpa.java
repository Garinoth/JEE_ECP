package models.daos.jpa;

import models.daos.VoteDao;
import models.entities.Vote;

public class VoteDaoJpa extends GenericDaoJpa<Vote, Integer> implements VoteDao {

	public VoteDaoJpa() {
		super(Vote.class);
	}
	
}
