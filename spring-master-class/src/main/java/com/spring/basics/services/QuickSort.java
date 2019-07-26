package com.spring.basics.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.spring.basics.specifications.SortAlgorithm;

@Component
@Qualifier("quick")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class QuickSort<T> implements SortAlgorithm<T> {

	@Override
	public T[] sort(T[] t) {
		// TODO Auto-generated method stub
		return t;
	}

}
