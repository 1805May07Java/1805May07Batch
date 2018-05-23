package com.rev.sin;

public abstract class Burger implements itm{
	 
	   public Packing packing() {
	      return new Wrapper();
	   }
	   
	   public abstract float price();
}
