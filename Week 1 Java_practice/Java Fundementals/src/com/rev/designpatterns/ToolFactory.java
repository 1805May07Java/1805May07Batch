package com.rev.designpatterns;

public class ToolFactory {
	
	public static tool getTool(String toolName) {
		switch(toolName.toLowerCase()) {
		case "hammer": return new Hammer();
		case "screwdriver": return new ScrewDriver();
		case "wrench": return new Wrench();
		default: return null;
		}
	}
}
