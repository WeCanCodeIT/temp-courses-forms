package org.wecancodeit.courses;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class CourseControllerTest {

	@InjectMocks
	private CourseController underTest;

	@Mock
	private CourseRepository courseRepo;

	@Mock
	private Course course1;
	@Mock
	private Course course2;

	@Mock
	private InstructorRepository instructorRepo;

	@Mock
	private Model model;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldAddASingleCourseToModel() {
		Long courseId = 1L;
		when(courseRepo.findOne(courseId)).thenReturn(course1);
		underTest.findOneCourse(courseId, model);
		verify(model).addAttribute("courses", course1);
	}

	@Test
	public void shouldReturnASingleCourse() {
		String template = underTest.findOneCourse(1L, model);
		assertThat(template, is("course"));
	}

	@Test
	public void shouldReturnAllCourses() {
		Collection<Course> allCourses = Arrays.asList(course1, course2);
		when(courseRepo.findAll()).thenReturn(allCourses);
		underTest.findAllCourses(model);
		verify(model).addAttribute("courses", allCourses);
	}

}
