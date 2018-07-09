package org.wecancodeit.courses;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
	Course findAllByName(String string);
}
