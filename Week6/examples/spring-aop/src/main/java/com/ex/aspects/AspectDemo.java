package com.ex.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectDemo {
	
	//BEFORE ADVICE
	@Before("execution(* com.ex.application.Methods.*(..))")
	public void beforeTest(JoinPoint jp) {
		System.out.println("Before method " + jp.getSignature());
	}
	
	//AFTER ADVICE USING NAMED POINTCUT
	@After("methodsMethods()")
	public void afterTest() {
		System.out.println("after test");
	}
	@AfterThrowing("methodsMethods()")
	public void afterThrowingTest() {
		System.out.println("AFTER THROWING");
	}
	@AfterReturning("methodsMethods()")
	public void afterReturningTest() {
		System.out.println("AFTER RETURNING");
	}
	
	@Around("methodsMethods()")
	public void AroundTest(ProceedingJoinPoint pjp) {
		System.out.println("in around");
		System.out.println("before pjp");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("doing more things after execution");
	}
	
	@Pointcut("execution(* com.ex.application.Methods.*(..))")
	public void methodsMethods() {}
	
	void timer() {
		
	}
	
	
	

}
