/*
 * LaptopBuilder.java
 * Author: Cole Vikupitz
 */

package com.revature.builder;

public class LaptopBuilder {

	private String name;
	private int resolution;
	private long ram;
	private int cores;
	private int batteryLife;
	private String os;

	public LaptopBuilder() {
		this.name = "Toshiba";
		this.resolution = 1000;
		this.ram = 19000000L;
		this.cores = 4;
		this.batteryLife = 100;
		this.os = "Windows 7";
	}

	public LaptopBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public LaptopBuilder setResolution(int resolution) {
		this.resolution = (resolution <= 0) ? 100 : resolution;
		return this;
	}

	public LaptopBuilder setRam(long ram) {
		this.ram = (ram <= 0) ? 100000L : ram;
		return this;
	}

	public LaptopBuilder setCores(int cores) {
		this.cores = (cores <= 0) ? 1 : cores;
		return this;
	}

	public LaptopBuilder setBatteryLife(int batteryLife) {
		this.batteryLife = (batteryLife < 0) ? 0 : batteryLife;
		return this;
	}

	public LaptopBuilder setOperatingSystem(String os) {
		this.os = os;
		return this;
	}

	public Laptop getLaptop() {
		return new Laptop(
				this.name, this.resolution, this.ram, this.cores,
				this.batteryLife, this.os);
	}
}
