package controllers;

import models.entities.Theme;
import models.utils.Studies;

public interface ShowVotes {

	Double getAverage(Theme theme);

	Integer getTotalVotes(Theme theme);

	Double getAverageByStudies(Theme theme, Studies studies);

}
