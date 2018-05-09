package com.rev.hello;
//with Java as a package-centric language, the first line of every class
// 	should be the package that it is in. avoid creating classes in the src folder directly
public class HelloWorld {
	//HelloWorld hello = new HelloWorld();
//	public HelloWorld() {
//		super();
//	}
	
	/*
	 * Every java program begins execution with its main method.
	 * A main() method is the gateway between the startup of a Java
	 * process, which is managed by the JVM, and the beginning of 
	 * the developer's code. 
	 */
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		HelloWorld hello = new HelloWorld();
		
		/*
		 * Java's System class contains several useful class fields and
		 * methods for standard input, output, and error output streams,
		 * 
		 * https://www.geeksforgeeks.org/java-lang-system-class-java/
		 * https://docs.oracle.com/javase/7/docs/api/java/lang/System.html
		 */
	}

}
