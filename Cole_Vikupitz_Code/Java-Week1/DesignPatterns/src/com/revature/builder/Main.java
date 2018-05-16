/*
 * Main.java
 * Author: Cole Vikupitz
 *
 * Builder pattern builds a complex object using simple objects and using
 * a step by step approach. This type of design pattern comes under creational
 * pattern as this pattern provides one of the best ways to create an object.
 *
 * A Builder class builds the final object step by step. This builder is independent
 * of other objects.
 *
 * - from TutorialsPoint (https://www.tutorialspoint.com/design_pattern/builder_pattern.htm)
 */

package com.revature.builder;

public class Main {

	public static void main(String[] args) {

		// Customize laptop features
		LaptopBuilder builder = new LaptopBuilder();
		builder.setName("Toshiba")
			.setResolution(250)
			.setRam(8000000000L)
			.setCores(4)
			.setBatteryLife(100)
			.setOperatingSystem("Windows 10");

		// Creates the instance with customizations
		Laptop laptop = builder.getLaptop();
		System.out.println(laptop);
	}
}
