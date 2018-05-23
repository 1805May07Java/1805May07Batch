package com.rev.designpatterns;

public class driver {
	public static void main(String[] args) {
		
		
		Singleton s = Singleton.getInstance();
		s.count = 10;
		s.name = "testing";
		
		System.out.println(s.name);
		
		Singleton two = Singleton.getInstance();
		two.name = "changing name";
		System.out.println(s.name);
		
		tool Tool = ToolFactory.getTool("hammer");
		System.out.println(Tool.work());
	}
}
