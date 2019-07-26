package com.spring.basics.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect	
@Configuration
public class BeforeAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//What kind of method calls I would intercept
	//execution(* PACKAGE.*.*(..))
	/*
	@Before("com.spring.basics.aop.aspect.CommonPointConfig.dataLayerExecution()")
	public void beforRun(JoinPoint joinPoint) {
		logger.info("in before interceptor {} ",joinPoint);
	}
	
	@AfterReturning(value="com.spring.basics.aop.aspect.CommonPointConfig.businessLayerExecution()",returning="result")
	public void afterReturn(JoinPoint joinPoint, Object result) {
		logger.info("in after interceptor {} returned value {} ",joinPoint,result);
	}
	*/
	/*@AfterThrowing(value="execution(* com.spring.basics.aop.business.*.*(..))",throwing="exception")
	public void afterException(JoinPoint joinPoint, Object exception) {
		logger.info("in after interceptor {} exception value {} ",joinPoint,exception);
	}
	
	@After(value="execution(* com.spring.basics.aop.business.*.*(..))")
	public void afterException(JoinPoint joinPoint) {
		logger.info("in after interceptor {} exception value",joinPoint);
	}*/
	
	@Around("com.spring.basics.aop.aspect.CommonPointConfig.trackTime()")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();

		joinPoint.proceed();

		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
	}
}
