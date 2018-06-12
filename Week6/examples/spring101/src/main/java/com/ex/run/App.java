package com.ex.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.autowiring.Employee;
import com.ex.hello.HelloWorld;
import com.ex.hello.ParentWorld;

public class App {

	public static void main(String[] args) {
		//WRONG! This is NOT dependency injection
//		HelloWorld hello = new HelloWorld();
//		hello.getText();
		
		
		//Intro to our application context
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		HelloWorld hw = (HelloWorld) context.getBean("thisIsABean");
		hw.getText();
		System.out.println(hw.count);
		
		
		ParentWorld pw = (ParentWorld) context.getBean("parent");
		pw.getHello().getText();
		
		
	
	}
	
	/* The Spring container is at the core of the Spring Framework. 
	 * The container will create the objects, wire them together, 
	 * configure them, and manage their complete life cycle from 
	 * creation until destruction. The Spring container uses DI to 
	 * manage the components that make up an application. These 
	 * objects are called Spring Beans, which are objects managed by
	 * the Spring container. We define these either in XML or with @.
	 * The container gets its instructions on what objects to instantiate,
	 *  configure, and assemble by reading the configuration metadata 
	 *  provided. The configuration metadata can be represented either by 
	 *  XML, Java annotations, or Java code.

	 * The first step is to create an application context where we used 
	 * framework API ClassPathXmlApplicationContext(). This API loads 
	 * beans configuration file and eventually based on the provided API,
	 * it takes care of creating and initializing all the objects, i.e. 
	 * beans mentioned in the configuration file.
	 * The second step is used to get the required bean using getBean() 
	 * method of the created context. This method uses bean ID to return 
	 * a generic object, which finally can be casted to the actual object. 
	 * Once you have an object, you can use this object to call any class method.
	 */

}
