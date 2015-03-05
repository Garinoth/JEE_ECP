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
    
    private Double rating;
    
    public Theme() {
    	
    }

	public Theme(String name, String question, Double rating) {
		super();
		this.name = name;
		this.question = question;
		this.rating = rating;
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

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Theme [id=" + id + ", name=" + name + ", question=" + question
				+ ", rating=" + rating + "]";
	}
    
}
