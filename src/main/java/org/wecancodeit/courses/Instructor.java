package org.wecancodeit.courses;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Instructor {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "instructor")
	Collection<Course> courses;
	
	public Instructor() {}

	public Instructor(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return id + ": " + name;
	}
}
