package org.wecancodeit.courses;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseRestController {

	@Resource
	private CourseRepository repo;

	@RequestMapping("")
	public Iterable<Course> findAllCourses(@RequestParam(defaultValue = "") String search,
			@RequestParam(defaultValue = "") String advanced) {
		if (search.isEmpty()) {
			if (advanced.isEmpty()) {
				return repo.findAll();
			}
			return repo.findByDescriptionIgnoreCaseLike(advanced.replace('*', '%'));
		}

		return repo.findByDescriptionIgnoreCaseContains(search);
	}

	@RequestMapping("/{id}")
	public Course findOneCourse(@PathVariable long id) {
		return repo.findOne(id);
	}
}
