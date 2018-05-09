/*
 * Car.java
 * Author: Cole Vikupitz
 * 
 * Exercise 11: Class with fields of varying access modifiers.
 * A different package will import this one, and attempt to directly
 * access the class's variables.
 */

package com.revature.exercise11b;

public class Car {

	public float mpg;
	public float speed;
	protected float maxGallons;
	protected float gallonsLeft;
	private String color;
	int year;
	
	public Car(String color) {
		
		this.mpg = 30.0F;
		this.speed = 0.0F;
		this.maxGallons = 20.0F;
		this.gallonsLeft = this.maxGallons;
		this.color = color;
		this.year = 2018;
	}

	public float getMpg() {
		return mpg;
	}

	public void setMpg(float mpg) {
		this.mpg = mpg;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getMaxGallons() {
		return maxGallons;
	}

	public void setMaxGallons(float maxGallons) {
		this.maxGallons = maxGallons;
	}

	public float getGallonsLeft() {
		return gallonsLeft;
	}

	public void setGallonsLeft(float gallonsLeft) {
		this.gallonsLeft = gallonsLeft;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
