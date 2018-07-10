package org.wecancodeit.courses;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class CoursePopulator implements CommandLineRunner {

	@Resource
	private CourseRepository courseRepo;

	@Resource
	private InstructorRepository instructorRepo;

	@Override
	public void run(String... args) throws Exception {
		
		Instructor alan = instructorRepo.save(new Instructor("Alan"));
		Instructor donny = instructorRepo.save(new Instructor("Donny"));
		Instructor brian = instructorRepo.save(new Instructor("Brian"));

		Course java = new Course("Java", "Java Description", alan);
		Course javascript = new Course("JavaScript", "JavaScript Description", donny);
		Course spring = new Course("Spring", "Spring Description", brian);

		courseRepo.save(java);
		courseRepo.save(javascript);
		courseRepo.save(spring);

	}

}
