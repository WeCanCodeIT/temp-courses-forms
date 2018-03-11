package org.wecancodeit.courses;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
	
	Course findByName(String name);
	Collection<Course> findByInstructor(Instructor instructor);
}

