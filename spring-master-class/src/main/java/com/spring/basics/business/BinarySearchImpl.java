package com.spring.basics.business;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.spring.basics.specifications.SearchAlgorithm;
import com.spring.basics.specifications.SortAlgorithm;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BinarySearchImpl<T> implements SearchAlgorithm<T> {

	@Autowired
	//@Qualifier("quick")
	public SortAlgorithm<T> sortAlgorithm;
	
	@Override
	public int search(T[] t, T s) {
		// TODO Auto-generated method stub
		t=sortAlgorithm.sort(t);
		System.out.println(sortAlgorithm);
		return Arrays.asList(t).indexOf(s);
	}
	
	public SortAlgorithm<T> getSortAlgorithm(){
		Emp emp = new Emp();
		System.out.println(emp);
		return this.sortAlgorithm;
	}

}

class Emp {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
