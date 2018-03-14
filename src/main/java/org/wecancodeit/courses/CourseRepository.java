package org.wecancodeit.courses;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
	Iterable<Course> findByDescriptionIgnoreCaseLike(String search);
	Iterable<Course> findByDescriptionIgnoreCaseContains(String search);
}

