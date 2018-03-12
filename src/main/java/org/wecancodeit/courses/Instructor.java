package org.wecancodeit.courses;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Instructor {

	@GeneratedValue
	@Id
	private Long id;

	private String name;

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

	@SuppressWarnings("unused")
	private Instructor() {

	}

	public Instructor(String name) {
		this.name = name;
	}

}
