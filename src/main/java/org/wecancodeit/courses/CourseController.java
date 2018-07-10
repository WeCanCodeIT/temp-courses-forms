package org.wecancodeit.courses;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CourseController {

	@Resource
	CourseRepository courseRepo;

	@Resource
	InstructorRepository instructorRepo;

	@RequestMapping("/")
	public String home() {
		return "redirect:/courses";
	}

	@RequestMapping("/courses")
	public String getCourses(Model model) {
		model.addAttribute("courses", courseRepo.findAll());
		return "courses";
	}

	@RequestMapping(value = "/courses", method = RequestMethod.POST)
	public String addCourse(String courseName, String courseDescription, String courseInstructor) {
		if (courseRepo.findByName(courseName) == null) {
			Instructor instructor;
			if (instructorRepo.findByName(courseInstructor) == null) {
				instructor = instructorRepo.save(new Instructor(courseInstructor));
			} else {
				instructor = instructorRepo.findByName(courseInstructor);
			}
			courseRepo.save(new Course(courseName, courseDescription, instructor));
		}
		return "redirect:/courses";
	}

	@RequestMapping(value = "/remove-course", method = RequestMethod.POST)
	public String removeCourse(String deleteCourse) {
		courseRepo.delete(courseRepo.findByName(deleteCourse));
		return "redirect:/courses";
	}

	@RequestMapping("/courses/{id}")
	public String course(@PathVariable(name = "id") Long id, Model model) {
		model.addAttribute("course", courseRepo.findOne(id));
		return "course";
	}

}
