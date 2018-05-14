package com.ex.designpatterns;

public class ToolFactory 
{
	
	public static Tool getTool(String toolName) {
			toolName.toLowerCase();
		switch(toolName) {
			case "hammer": return new Hammer();
			case "screwdriver": return new ScrewDriver();
			case "wrench": return new Wrench();
			default: return null;
		}
	}

}
