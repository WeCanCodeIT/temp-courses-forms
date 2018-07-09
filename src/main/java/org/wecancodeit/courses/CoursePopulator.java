package org.wecancodeit.courses;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class CoursePopulator implements CommandLineRunner {

	@Resource
	private CourseRepository courseRepo;

	@Override
	public void run(String... args) throws Exception {

		Course java = new Course("Java", "Java Description", "Alan");
		Course javascript = new Course("JavaScript", "JavaScript Description", "Donny");
		Course spring = new Course("Spring", "Spring Description", "Brian");

		courseRepo.save(java);
		courseRepo.save(javascript);
		courseRepo.save(spring);

	}

}
