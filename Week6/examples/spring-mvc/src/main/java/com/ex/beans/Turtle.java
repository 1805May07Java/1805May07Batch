package com.ex.beans;

public class Turtle {
	
	String name;
	String faveColor;
	String faveFood;
	String weapon;
	
	public Turtle(){}
	
	public Turtle(String name, String faveColor, String faveFood, String weapon) {
		super();
		this.name = name;
		this.faveColor = faveColor;
		this.faveFood = faveFood;
		this.weapon = weapon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFaveColor() {
		return faveColor;
	}
	public void setFaveColor(String faveColor) {
		this.faveColor = faveColor;
	}
	public String getFaveFood() {
		return faveFood;
	}
	public void setFaveFood(String faveFood) {
		this.faveFood = faveFood;
	}
	public String getWeapon() {
		return weapon;
	}
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	
	
	

}
