package com.springbootstarter.course;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	/*private List<Topic> topics= new ArrayList<Topic> (Arrays.asList(
			new Topic("1","Sample API","First Sample API"),
			new Topic("2","Sample API2","First Sample API2"),
			new Topic("3","Sample API3","First Sample API3"),
			new Topic("4","Sample API4","First Sample API4")
			));*/
	
	@Autowired
	private CourseServiceRepository courseServiceRepository;
	
	public List<Course> getAllCourses(String topicId){
		
		return courseServiceRepository.findByTopicId(topicId);
		
	}
	
	public Course getCourse(String id) {
		//return topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();
		return courseServiceRepository.findOne(id);
	}
	
	public void addCourse(Course topic) {
		//this.topics.add(topic);
		courseServiceRepository.save(topic);
	}
	
	public void updateCourse(String id, Course topicToUpdate) {
		/*int index=0;
		for (Topic topic : topics) {
			if(topic.getId().equals(id)) {
				topics.set(index, topicToUpdate);
			}
			index ++;
		}*/
		
		courseServiceRepository.save(topicToUpdate);
	}

	public void deleteCourse(String id) {
//		topics.removeIf(t-> t.getId().equals(id));
		courseServiceRepository.delete(id);
		
	}
}
