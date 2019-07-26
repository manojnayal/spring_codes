package com.spring.basics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring.basics.business.BinarySearchImpl;

/**
 * 
 * @author manoj.nayal
 *
 */
//@Configuration - Spring configuration
//@ComponentScan - scan for component to manage by spring
@SpringBootApplication
public class SpringMasterClassApplication {
	
	public static Logger logger= LoggerFactory.getLogger(SpringMasterClassApplication.class);
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext appContext= SpringApplication.run(SpringMasterClassApplication.class, args);
		
		BinarySearchImpl<Integer> binarySearch=appContext.getBean(BinarySearchImpl.class);
		binarySearch.search(new Integer[] {2,4,5,9,7,3,10},3);
		System.out.println(binarySearch);
		logger.info("Binary Search instance {} ", binarySearch);
		logger.info("Sort Algorithm instance {} ", binarySearch.getSortAlgorithm());
		
		BinarySearchImpl<Integer> binarySearchNew=appContext.getBean(BinarySearchImpl.class);
		binarySearchNew.search(new Integer[] {2,4,5,9,7,3,11},4);
		logger.info("Binary Search instance {} ", binarySearchNew);
		logger.info("Sort Algorithm instance {} ", binarySearchNew.getSortAlgorithm());
	}

}
