package com.accenture.mservice.web.test;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.accenture.mservice.CustomerManagementApplication;
import com.accenture.mservice.bean.Customer;
import com.accenture.mservice.utils.JSONUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=CustomerManagementApplication.class)

@WebAppConfiguration
public class CustomerTest {

	@Autowired
    WebApplicationContext webApplicationContext; // cached
    
    protected MockMvc mockMVC;
    
    @Before
    public void mySetup(){
		//making the mockMVC aware of the all the application components
		mockMVC= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
    @Test
    public void createCustomerTest() throws Exception{
    	  String uri="/customer/addCustomer";
    	  Customer customer = new Customer("Jack@123",0,90011.1);
    	  String customerJsonFormat =JSONUtils.covertFromObjectToJson(customer);
    	 
    	  
    	  MockHttpServletRequestBuilder request= MockMvcRequestBuilders.post(uri)
    			  //ResponseContentType: what test case/ test client expects in return
    			  .accept(MediaType.TEXT_HTML) 
    			 
    			  //Data what is sent to server as RequestBody
    			  .content(customerJsonFormat) 
    			  //Data type of the data being sent to server
    			  .contentType(MediaType.APPLICATION_JSON) ;
    	  
    	  ResultActions rest= mockMVC.perform(request);
    	  MvcResult mvcREsult= rest.andReturn();
		   
		  String finalResult= mvcREsult.getResponse().getContentAsString();
		  int actualStatus = mvcREsult.getResponse().getStatus();
		  
		  Assert.assertTrue(finalResult!=null);
		  Assert.assertTrue(actualStatus==HttpStatus.CREATED.value());
		  
    }
    
    @Test
    public void getCustomerTest() throws Exception{
    	  String uri="/customer/getDetails";
    	  MockHttpServletRequestBuilder request= MockMvcRequestBuilders.get(uri);
    	  ResultActions rest= mockMVC.perform(request);
    	  MvcResult mvcREsult= rest.andReturn();
		  
    	  //actual status and result
		  String result= mvcREsult.getResponse().getContentAsString();
		  int actualStatus= mvcREsult.getResponse().getStatus();
    	  
    	  //As RestControllerProduces Json result, converting from Json to Java Objects
    	  List<Customer> listCustomer= JSONUtils.covertFromJsonToObject2(result, List.class);
    	  
    	  //expected status:
    	  int expectedStatus =HttpStatus.OK.value();
    	  
    	  //Testing: Comparing Expected with Actual
    	  Assert.assertTrue(listCustomer!=null);
    	  Assert.assertTrue(actualStatus==expectedStatus);	 
		  
    }
}




