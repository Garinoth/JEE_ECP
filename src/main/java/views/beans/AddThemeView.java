package views.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import controllers.ejb.ControllerEjbFactory;

@ManagedBean(name = "addTheme")
public class AddThemeView {
	
	@ManagedProperty(value = "name")
	private String name;
	
	@ManagedProperty(value = "question")
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
