package com.connector.splunk;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/splunk")
public class SplunkController {

	@RequestMapping("/logs/id/{id}/cartId/{cartId}/AccountId/{accountId}/msisdn/{msisdn}")
	public List<String> getLogsFromDashboard(@PathVariable String id,
											 @PathVariable String cartId,
											 @PathVariable String accountId,
											 @PathVariable String msisdn){
			return null;
		
	}
	
	
	
}
