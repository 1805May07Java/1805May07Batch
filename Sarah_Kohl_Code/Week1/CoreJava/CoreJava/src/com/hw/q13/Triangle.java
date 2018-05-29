package com.hw.q13;

public class Triangle {
	private boolean printOne = false;
	
	public String triangleOfHeight(int maxHeight)
	{
		StringBuilder pyramidWIP = new StringBuilder();
		
		for(int height = 1; height<=maxHeight;height++ )
		{
			for(int width = 1; width<=height;width++)
			{
				pyramidWIP.append(printOne ? "1 " : "0 "); 
				printOne = !printOne;
			}
			pyramidWIP.append("\n");
		}
		printOne = false;
		return pyramidWIP.toString();
	}
	
}
