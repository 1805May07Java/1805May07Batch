package com.rev.sin;

public class hw_Singleton {
	    // static variable single_instance of type Singleton
	    private static hw_Singleton instance = null;
	 
	    // variable of type String
	    public String str;
	 
	    // private constructor restricted to this class itself
	    private hw_Singleton()
	    {
	        str = "I am a string in the Singleton class";
	    }
	 
	    // static method to create instance of Singleton class
	    public static hw_Singleton getInstance()
	    {
	        if (instance == null)
	            instance = new hw_Singleton();
	 
	        return instance;
	    }
	}
