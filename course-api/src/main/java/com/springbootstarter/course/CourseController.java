package com.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springbootstarter.topic.Topic;

@RestController
@RequestMapping("/topic/{topicId}/Courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	@RequestMapping(method = RequestMethod.GET )
	public List<Course> getAllCourse(@PathVariable String topicId) {
		return courseService.getAllCourses(topicId);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Course getCourse(@PathVariable String id){
		return courseService.getCourse(id);
	}
	
	@RequestMapping(value="/addTopic", method = RequestMethod.POST)
	public void addCourse(@RequestBody Course course,@PathVariable String topicId){
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.PUT)
	public void putCourse(@PathVariable String id,@PathVariable String topicId, @RequestBody Course course){
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(id,course);
	
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public void putCourse(@PathVariable String id){
		courseService.deleteCourse(id);
	
	}
	
}
