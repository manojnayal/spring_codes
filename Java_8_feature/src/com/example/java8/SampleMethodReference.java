package com.example.java8;

import java.util.ArrayList;
import java.util.List;

public class SampleMethodReference {
	public static void main(String args[]) {
	      List<String> names = new ArrayList<String>();
			
	      names.add("Mahesh");
	      names.add("Suresh");
	      names.add("Ramesh");
	      names.add("Naresh");
	      names.add("Kalpesh");
			
	      names.forEach(System.out::println);
	   }
    
}
