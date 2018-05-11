/*
 * Laptop.java
 * Author: Cole Vikupitz
 */

package com.revature.builder;

public class Laptop {

	private String name;
	private int resolution;
	private long ram;
	private int cores;
	private int batteryLife;
	private String os;

	public Laptop(String name, int resolution, long ram, int cores, int batteryLife, String os) {
		this.name = name;
		this.resolution = resolution;
		this.ram = ram;
		this.cores = cores;
		this.batteryLife = batteryLife;
		this.os = os;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getResolution() {
		return resolution;
	}

	public void setResolution(int resolution) {
		this.resolution = resolution;
	}

	public long getRam() {
		return ram;
	}

	public void setRam(long ram) {
		this.ram = ram;
	}

	public int getCores() {
		return cores;
	}

	public void setCores(int cores) {
		this.cores = cores;
	}

	public int getBatteryLife() {
		return batteryLife;
	}

	public void setBatteryLife(int batteryLife) {
		this.batteryLife = batteryLife;
	}

	public String getOS() {
		return os;
	}

	public void setOS(String os) {
		this.os = os;
	}

	@Override
	public String toString() {

		return String.format("Name: %s\nResoltion: %dx%d\nRAM: %d B\nCores: %d\nBattery: %d%%\nOperating System: %s\n",
				this.name, this.resolution, this.resolution, this.ram,
				this.cores, this.batteryLife, this.os);
	}
}
