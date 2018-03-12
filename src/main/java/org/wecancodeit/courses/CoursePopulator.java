package org.wecancodeit.courses;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CoursePopulator implements CommandLineRunner {

	@Resource
	private CourseRepository courseRepo;

	@Resource
	private InstructorRepository instructorRepo;

	@Override
	public void run(String... args) throws Exception {

		Instructor alan = new Instructor("Alan");
		Instructor brian = new Instructor("Brian");
		Instructor donny = new Instructor("Donny");

		instructorRepo.save(alan);
		instructorRepo.save(brian);
		instructorRepo.save(donny);

		Course java = new Course("Java", "Java Description", alan);
		Course javascript = new Course("Javascript", "Javascript Description", donny);
		Course spring = new Course("Spring", "Spring Description", brian);

		courseRepo.save(java);
		courseRepo.save(javascript);
		courseRepo.save(spring);

	}

}
