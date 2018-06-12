package com.ex.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.autowiring.Employee;

public class AutowireRun {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Employee me = (Employee) context.getBean("employee");
		me.getDepartment().setName("Training");
		System.out.println(me.getDepartment().getName());
		
		Employee e = (Employee) context.getBean("employee");
		Employee e2 = (Employee) context.getBean("employee");
		Employee e3 = (Employee) context.getBean("employee");
		
		e.setName("Genesis");
		e2.setName("John");
		e3.setName("Peggy");
		
		e.getDepartment().setName("training");
		System.out.println(e.getName());
		System.out.println(e3.getDepartment().getName());
	}

}
