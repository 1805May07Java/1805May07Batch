package com.ex.service;

import javax.jws.WebService;

@WebService(endpointInterface="com.ex.service.Endpoint")
public class EndpointImpl implements Endpoint{

	@Override
	public String sayHello(String message) {
		System.out.println("--IN WEB SERVICE IMPL. MESSAGE: " + message);
		return "HELLO " + message;
	}

	@Override
	public int fib(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		return fib(n-1) + fib(n-2);
	}

}
