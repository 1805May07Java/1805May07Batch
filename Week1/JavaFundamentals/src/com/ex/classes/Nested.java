package com.ex.classes;

public class Nested {
	
	public static void main(String[] args) {
		
		class LocalClass{
			void message() {
				System.out.println("In local Class");
			}
		}
		
		LocalClass lc = new LocalClass();
		//lc.message();
		
		LocalClass anonymous = new LocalClass() {
			@Override
			void message() {
				System.out.println("overriding Local Class message inside of anon");
			}
		};
		anonymous.message();
		
	}
	/*
	 * In java, each file can have at most one public class, but
	 * it can have as many standalone classes (default) as you wish
	 * In order for a class to be private, static, or protected, you
	 * must created a nested class. 
	 * There are 4 types. 
	 */
	
	int instancevar = 8;
	static int staticvar = 90;
	
	//INSTANCE CLASS 
	class InstanceClass{
		void message() {
			System.out.println("In instance class's message method");
		}
	}

	//STATIC NESTED CLASS
	static class StaticClass{
		void message() {
			System.out.println("In static class's message method");
		}
	}
}
