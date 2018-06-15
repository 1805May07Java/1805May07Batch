package com.ex.run;


import java.util.logging.Logger;

import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.application.Methods;

public class App {
	
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Methods m = (Methods) context.getBean("methods");
		
		m.test();
		try {
			m.counter(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.exceptionTest();
	}

}
