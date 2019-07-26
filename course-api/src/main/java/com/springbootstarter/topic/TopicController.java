package com.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics")
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Topic> getAllTopic() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Topic getTopic(@PathVariable String id){
		return topicService.getTopic(id);
	}
	
	@RequestMapping(value="/addTopic", method = RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic){
		topicService.addTopic(topic);
	}
	
	@RequestMapping(value="/change/{id}",method=RequestMethod.PUT)
	public void putTopic(@PathVariable String id, @RequestBody Topic topic){
		topicService.updateTopic(id,topic);
	
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public void putTopic(@PathVariable String id){
		topicService.deleteTopic(id);
	
	}
	
}
