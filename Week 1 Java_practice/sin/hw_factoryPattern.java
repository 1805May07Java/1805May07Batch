package com.rev.sin;

public class hw_factoryPattern {
	public shape getShape(String shapeT){
	      if(shapeT == null){
	         return null;
	      }		
	      if(shapeT.equalsIgnoreCase("circle")){
	         return new circle();
	         
	      } else if(shapeT.equalsIgnoreCase("rectangle")){
	         return new rec();
	         
	      } else if(shapeT.equalsIgnoreCase("triangle")){
	         return new triangle();
	      }
	      
	      return null;
	   }
}
