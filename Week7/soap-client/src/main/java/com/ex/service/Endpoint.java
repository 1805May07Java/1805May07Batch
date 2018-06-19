package com.ex.service;

import javax.jws.WebService;

@WebService
public interface Endpoint {

	String sayHello(String message);
	int fib(int n);
}
