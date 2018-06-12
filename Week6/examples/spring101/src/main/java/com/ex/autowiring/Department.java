package com.ex.autowiring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/* important Spring annotations to configure beans:
 * @Component - use for any bean 
 * @Service - use for business logic layer. does NOT indicate a web service
 * @Repository - use for DAO layer
 * -- there are many others
 * 
 */
@Component
//@Scope("prototype")
public class Department {
	
	private String name;

	public Department() {} 
	
	public Department(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
