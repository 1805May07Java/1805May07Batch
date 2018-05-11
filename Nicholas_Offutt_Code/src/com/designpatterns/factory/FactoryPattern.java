package com.designpatterns.factory;

enum whatAreWe { ONE, TWO, THREE, GO};
 
public class FactoryPattern 
{

	public Speaker getSpeaker(whatAreWe shout) 
	{
		
		switch(shout)
		{
		case ONE: return new firstBeat();
			
		case TWO: return new secondBeat();
			
		case THREE: return new thirdBeat();
			
		case GO: return new goBeat();
			
		default: return null;
				
	}
		
		
		
		
	}
	
	
	
}
