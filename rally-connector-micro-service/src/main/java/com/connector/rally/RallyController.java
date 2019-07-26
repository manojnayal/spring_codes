package com.connector.rally;

import java.util.List;
import java.util.Map;

import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.connector.rally.model.Subscription;
import com.connector.rally.model.SubscriptionBean;


@RestController

public class RallyController {
	
	@RequestMapping(method=RequestMethod.GET,value="/updateSubcription")
	public SubscriptionBean updateSubscription() {
		final String uri = "https://rally1.rallydev.com/slm/webservice/v2.0/Subscription";
		HttpHeaders headers = new HttpHeaders();
		 headers.set("Zsessionid","_XZu0rtxEQcprbihULphBMHg3DPOUHqgRUreleP4wk");
		 HttpEntity<String> entity = new HttpEntity<>("paramters",headers);

		 RestTemplate restTemplate = new RestTemplate();
		 ResponseEntity<SubscriptionBean> responseObj = restTemplate.exchange(uri, HttpMethod.GET,entity,SubscriptionBean.class);
		 SubscriptionBean resObj = responseObj.getBody();
		 System.out.println("here obj=="+resObj);
		 /*JsonParser springParser = JsonParserFactory.getJsonParser();
		 Map<String, Object> result = springParser.parseMap(resObj);
		 
		 System.out.println(result);*/
		 
	    
		return resObj;
		
	}
}
