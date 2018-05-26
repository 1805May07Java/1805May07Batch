package com.ex.hello;

import org.apache.log4j.Logger;

public class HelloWorld {
	final static Logger logger = Logger.getLogger(HelloWorld.class);
	public static void main(String[] args) {

		logger.debug("debugging");

		System.out.println("test");
	}
}
