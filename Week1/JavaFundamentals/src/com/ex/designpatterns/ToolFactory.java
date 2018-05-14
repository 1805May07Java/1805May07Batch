package com.ex.designpatterns;

public class ToolFactory {
	
	public static Tool getTool(String toolName) { 
		switch(toolName.toLowerCase()) {
		case "hammer": return new Hammer();
		case "screwdriver": return new ScrewDriver();
		case "wrench": return new Wrench();
		default: return null;
		}
	}
	

}
