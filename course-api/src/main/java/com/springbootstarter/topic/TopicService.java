package com.springbootstarter.topic;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	/*private List<Topic> topics= new ArrayList<Topic> (Arrays.asList(
			new Topic("1","Sample API","First Sample API"),
			new Topic("2","Sample API2","First Sample API2"),
			new Topic("3","Sample API3","First Sample API3"),
			new Topic("4","Sample API4","First Sample API4")
			));*/
	
	@Autowired
	private TopicServiceRepository topicServiceRepository;
	
	public List<Topic> getAllTopics(){
		//return this.topics;
		List<Topic> topics= new ArrayList<Topic>();
		topicServiceRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
		//return topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();
		return topicServiceRepository.findOne(id);
	}
	
	public void addTopic(Topic topic) {
		//this.topics.add(topic);
		topicServiceRepository.save(topic);
	}
	
	public void updateTopic(String id, Topic topicToUpdate) {
		/*int index=0;
		for (Topic topic : topics) {
			if(topic.getId().equals(id)) {
				topics.set(index, topicToUpdate);
			}
			index ++;
		}*/
		
		topicServiceRepository.save(topicToUpdate);
	}

	public void deleteTopic(String id) {
//		topics.removeIf(t-> t.getId().equals(id));
		topicServiceRepository.delete(id);
		
	}
}
