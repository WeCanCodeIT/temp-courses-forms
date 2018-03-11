package org.wecancodeit.courses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;

	private String instructor;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getInstructor() {
		return instructor;
	}

	public String getDescription() {
		return description;
	}

	protected Course() {

	}

	public Course(String name, String description, String instructor) {
		this.name = name;
		this.description = description;
		this.instructor = instructor;
	}

}
