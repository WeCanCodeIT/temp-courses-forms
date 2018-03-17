package org.wecancodeit.courses;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Instructor {

	@GeneratedValue
	@Id
	private Long id;
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "instructor")
	private Collection<Course> courses;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<Course> getCourses() {
		return courses;
	}
	
	public Collection<String> getCoursesUrls() {
		Collection<String> urls = new ArrayList<>();
		for (Course c : courses) {
			urls.add(format("/courses/%d", c.getId()));
		}
		return urls;
	}
	
	protected Instructor() {

	}

	public Instructor(String name) {
		this.name = name;
	}

}
