package com.ex.designpatterns;

public class Driver {

	public static void main(String[] args) {
		//Singleton s = new Singleton();
		
		Singleton s = Singleton.getInstance();
		s.count = 10;
		s.name = "Testing";
		
		System.out.println(s.name);
		
		Singleton two = Singleton.getInstance();
		two.name = "changing name";
		
		System.out.println(s.name);
		
		//FACTORY DESIGN PATTERN
		
		Tool tool = ToolFactory.getTool("screwdriver");
		System.out.println(tool.work());
	}

}
