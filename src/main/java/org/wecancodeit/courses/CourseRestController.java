package org.wecancodeit.courses;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseRestController {

	@Resource
	private CourseRepository repo;

	@RequestMapping("")
	public Iterable<Course> findAllCourses() {
		return repo.findAll();
	}

	@RequestMapping("/{id}")
	public Course findOneCourse(@PathVariable long id) {
		return repo.findOne(id);
	}
}
