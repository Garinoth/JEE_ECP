package controllers;

import models.entities.Theme;
import models.utils.Studies;

public interface Vote {

	void run(String ip, Double rating, Studies studies, Theme theme);

}
