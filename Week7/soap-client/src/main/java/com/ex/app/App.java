package com.ex.app;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.ex.service.Endpoint;

public class App {

	public static void main(String[] args) {
		String server = "http://localhost";
		String port = "8081";
		String contextRoot = "soap-service";
		String endpoint = "endpoint";
		
		String url = server + ":" + port + "/" + contextRoot + "/" + endpoint;

		//Config
		JaxWsProxyFactoryBean beanFactory = new JaxWsProxyFactoryBean();
		beanFactory.setServiceClass(Endpoint.class);
		beanFactory.setAddress(url);
		
		//Actually consume interface implementation from service app
		Endpoint service = (Endpoint) beanFactory.create();
		String response = service.sayHello("Java Batch!");
		int x = service.fib(4);
		System.out.println("IN SOAP CLIENT! RESPONSE = " + response);
		System.out.println(x);
		
	}

}
