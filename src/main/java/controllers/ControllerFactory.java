package controllers;

public abstract class ControllerFactory {
    public abstract AddTheme getAddThemeController();

    public abstract DeleteTheme getDeleteThemeController();

    public abstract ShowVotes getShowVotesController();

    public abstract Vote getVoteController();

}