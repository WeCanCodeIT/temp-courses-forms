package org.wecancodeit.courses;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {

	@Resource
	CourseRepository courseRepo;

	@Resource
	InstructorRepository instructorRepo;

	@RequestMapping("/show-courses")
	public String findAllCourses(Model model) {
		model.addAttribute("courses", courseRepo.findAll());
		return "courses";
	}

	@RequestMapping("/course")
	public String findOneCourse(@RequestParam(value = "id") Long id, Model model) {
		model.addAttribute("courses", courseRepo.findOne(id));
		return "course";
	}

	@RequestMapping("/add-course")
	public String addCourse(String name, String description, String instructorName) {

		Instructor instructor = instructorRepo.findByName(instructorName);

		Course newCourse = courseRepo.findByName(name);
		if (newCourse == null) {
			newCourse = new Course(name, description, instructor);
			courseRepo.save(newCourse);
		}

		return "redirect:/show-courses";
	}

	@RequestMapping("remove-course")
	public String removeCourse(String name) {

		Course courseToRemove = courseRepo.findByName(name);
		if (courseRepo.findByName(name) != null) {
			courseRepo.delete(courseToRemove);
			return "redirect:/show-courses";
		}

		return "redirect:/show-courses";
	}

	@RequestMapping("find-by-instructor")
	public String findCoursesByInstructor(String instructorName, Model model) {
		Instructor instructor = instructorRepo.findByName(instructorName);
		model.addAttribute("courses", courseRepo.findByInstructor(instructor));
		return "/instructor";
	}

}
