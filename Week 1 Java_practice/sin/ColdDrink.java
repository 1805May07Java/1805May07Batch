package com.rev.sin;

public abstract class ColdDrink implements itm{

	public Packing packing() {
       return new Bottle();
	}

	public abstract float price();
}
