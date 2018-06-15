package com.ex.aspects;


import org.apache.log4j.Logger;
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
import org.springframework.util.StopWatch;

@Aspect
@Component
public class AspectDemo {
	

	final static Logger logger = Logger.getLogger(AspectDemo.class);
	
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
	
	@Pointcut("execution(* com.ex.application.*.*(..))")
	public void methodsMethods() {}
	
	@Pointcut("execution(* com.ex.application.Methods.do*(..))")
	public void startsWithDo() {}
	
	@Around("methodsMethods()")
	void timer(ProceedingJoinPoint pjp) throws Throwable{
		StopWatch timer = new StopWatch();
		timer.start();
		pjp.proceed();
		timer.stop();
		String logMessage = "METHOD EXECUTION INFO:\n";
		logMessage += pjp.getTarget().getClass().getName() + ".";
		logMessage += pjp.getSignature().getName() + "\n";
		logMessage += "Execution Time: " + timer.getTotalTimeMillis() + "ms";
		logger.info(logMessage);
	}
	
	
	

}
