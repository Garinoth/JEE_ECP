package models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Theme {
	
	@Id
	@GeneratedValue
	private Integer id;
	
    private String name;
    
    private String question;
        
    public Theme() {
    	
    }

	public Theme(String name, String question) {
		super();
		this.name = name;
		this.question = question;
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

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Theme [id=" + id + ", name=" + name + ", question=" + question + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		Theme theme = (Theme)obj;
		return this.name.equals(theme.name) && this.question.equals(theme.question);
	}
    
}
