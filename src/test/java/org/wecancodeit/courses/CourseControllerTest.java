package org.wecancodeit.courses;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(CourseController.class)
public class CourseControllerTest {
	@Autowired
	MockMvc mvc;
	
	@MockBean
	CourseRepository courseRepo;
	
	@Mock
	Course testCourse;
	
	@Test
	public void properRequestToCoursesShouldBeOk() throws Exception {
		mvc.perform(get("/courses")).andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void improperRequestToCoursesShouldNotBeOk() throws Exception {
		mvc.perform(get("/couses")).andExpect(status().is4xxClientError());
	}
	
	@Test
	public void properRequestToCoursesShouldReturnExpectedView() throws Exception {
		mvc.perform(get("/courses")).andExpect(view().name("courses"));
	}
	
	@Test
	public void properRequestToCoursesShouldProvideTheCorrectModel() throws Exception {
		mvc.perform(get("/courses")).andExpect(model().attribute("courses", is(equalTo(courseRepo.findAll()))));
	}
	
	@Test
	public void properRequestToCourseShouldBeOk() throws Exception {
		given(courseRepo.findOne(1L)).willReturn(testCourse);
		mvc.perform(get("/courses/1")).andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void improperRequestToCourseShouldNotBeOk() throws Exception {
		given(courseRepo.findOne(1L)).willReturn(testCourse);
		mvc.perform(get("/couses/1")).andExpect(status().is4xxClientError());
	}
	
	@Test
	public void properRequestToCourseShouldReturnExpectedView() throws Exception {
		given(courseRepo.findOne(1L)).willReturn(testCourse);
		mvc.perform(get("/courses/1")).andExpect(view().name("course"));
	}
	
	@Test
	public void properRequestToCourseShouldProvideTheCorrectModel() throws Exception {
		given(courseRepo.findOne(3L)).willReturn(testCourse);
		mvc.perform(get("/courses/3")).andExpect(model().attribute("course", courseRepo.findOne(3L)));
	}
}
