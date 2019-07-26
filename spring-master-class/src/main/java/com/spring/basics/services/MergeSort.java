package com.spring.basics.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.spring.basics.specifications.SortAlgorithm;


@Component
@Primary
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE,proxyMode=ScopedProxyMode.TARGET_CLASS)
@Qualifier("merge")
public class MergeSort<T> implements SortAlgorithm<T> {

	
	@Override
	public T[] sort(T[] t) {
		// TODO Auto-generated method stub
		return t;
	}

}
