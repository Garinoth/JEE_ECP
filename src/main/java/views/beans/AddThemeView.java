package views.beans;

import controllers.ejb.ControllerEjbFactory;

public class AddThemeView {
	
	private String name;
	private String question;

	public AddThemeView() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String process() {

		ControllerEjbFactory.getFactory().getAddThemeController().run(name, question);
		return "home";
	}
}
