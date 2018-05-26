package com.rev.exercise11A;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Q11_AccessExtClass 
{
	public static void main(String args[])
	{
		Q11_AccessExtClass main = new Q11_AccessExtClass();
		
		//Turn this into an 'argument'
		String classPath = "com.rev.exercise11B.DataClass";
		Object data = main.createExternalInstance(classPath, 10, 20);
		System.out.println(main.runExternalMethod(data, "getB").toString());
	}
	
	public Object createExternalInstance(String classPath, Object...args)
	{
		Object object = null;
		try {
			Class<?> cls = Class.forName(classPath);
			
			//TOFIX : Need it to be able to take any arguments
			Constructor<?> ctor = cls.getDeclaredConstructor(float.class, float.class);
			
			object = ctor.newInstance(args);
			
			//END TOFIX
		} catch (Exception e) {
			System.out.println("Error: Unable to run constructor");
			System.out.println(e.toString());
			return null;	
		}
		return object;
	}
	
	public Object runExternalMethod(Object exec, String method, Object...args)
	{
		Object result;
		try {
			Method run = exec.getClass().getDeclaredMethod(method);
			result = run.invoke(exec, args);
		}
		catch(Exception e)
		{
			System.out.println("Error: Unable to run method");
			return null;
		}
		return result;
	}
}
