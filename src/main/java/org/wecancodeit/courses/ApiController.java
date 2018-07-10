package org.wecancodeit.courses;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	CourseRepository courseRepo;
	
	@RequestMapping("/courses") // /api/courses
	public Collection<Course> getCourses() {
		return (Collection<Course>) courseRepo.findAll();
	}
	
	@RequestMapping("/courses/{id}") // /api/courses
	public Course getCourse(@PathVariable(name = "id") Long id) {
		return courseRepo.findOne(id);
	}
}
