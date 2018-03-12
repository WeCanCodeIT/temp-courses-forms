package org.wecancodeit.courses;

import org.springframework.data.repository.CrudRepository;

public interface InstructorRepository extends CrudRepository<Instructor, Long> {

	Instructor findByName(String name);
}
