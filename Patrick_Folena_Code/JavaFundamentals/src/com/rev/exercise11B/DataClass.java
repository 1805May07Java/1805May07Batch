package com.rev.exercise11B;

public class DataClass 
{
	float varA;
	float varB;
	
	public DataClass()
	{
		varA = 0;
		varB = 0;
	}
	
	public DataClass(float varA, float varB)
	{
		this.varA = varA;
		this.varB = varB;
	}
	
	public float getA()
	{
		return varA;
	}
	public void setA(float varA)
	{
		this.varA = varA;
	}
	public float getB()
	{
		return varB;
	}
	public void setB(float varB)
	{
		this.varB = varB;
	}
	public float[] getAB()
	{
		float[] result = new float[2];
		result[0] = varA;
		result[1] = varB;
		return result;
	}
}
