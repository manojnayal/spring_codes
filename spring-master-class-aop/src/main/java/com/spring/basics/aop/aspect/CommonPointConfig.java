package com.spring.basics.aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointConfig {
	
	@Pointcut("execution(* com.spring.basics.aop.data.*.*(..))")
	public void dataLayerExecution() {}
	
	
	@Pointcut("execution(* com.spring.basics.aop.business.*.*(..))")
	public void businessLayerExecution() {}

	@Pointcut("@annotation(com.spring.basics.aop.aspect.TrackTime)")
	public void trackTime() {}
}
