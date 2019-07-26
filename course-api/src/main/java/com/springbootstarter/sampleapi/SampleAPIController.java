package com.springbootstarter.sampleapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleAPIController {
	
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hi";
	}

}
