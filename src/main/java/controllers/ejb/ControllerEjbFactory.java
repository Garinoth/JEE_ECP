package controllers.ejb;

import controllers.AddTheme;
import controllers.ControllerFactory;
import controllers.DeleteTheme;
import controllers.ShowVotes;
import controllers.Vote;

public class ControllerEjbFactory extends ControllerFactory {
    
	private AddTheme addThemeController;
    private DeleteTheme deleteController;
    private ShowVotes showVotesController;
    private Vote voteController;
	
	private static ControllerEjbFactory factory;
	
	private ControllerEjbFactory(){
		
	}

    public static ControllerEjbFactory getFactory() {
        if (factory == null) {
        	factory = new ControllerEjbFactory();
        }
        return factory;
    }
    
	@Override
	public AddTheme getAddThemeController() {
		if (addThemeController == null) {
            addThemeController = new AddThemeEjb();
        }
        return addThemeController;
	}

	@Override
	public DeleteTheme getDeleteThemeController() {
		if (deleteController == null) {
            deleteController = new DeleteThemeEjb();
        }
        return deleteController;
	}

	@Override
	public ShowVotes getShowVotesController() {
		if (showVotesController == null) {
            showVotesController = new ShowVotesControllerEjb();
        }
        return showVotesController;
	}

	@Override
	public Vote getVoteController() {
		if (voteController == null) {
            voteController = new VoteControllerEjb();
        }
        return voteController;
	}

}