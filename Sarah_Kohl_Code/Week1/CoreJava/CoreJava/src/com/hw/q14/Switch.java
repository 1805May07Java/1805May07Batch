package com.hw.q14;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Switch {
	
	private String[] splitArray;
	
	class InvalidInputException extends RuntimeException {
		
	    public InvalidInputException(String s)
	    {
	        super(s);
	    }
	}
	
	public String[] getArray() {
		if(splitArray==null)
		{
			demo(3);
		}
		
		return splitArray;
	}
	
	public String demo(int n)
	{
		String result = new String();
		switch(n) {
		case 1:
			result = Double.toString(Math.sqrt(2));
			break;
		case 2:
			DateFormat df = new SimpleDateFormat("dd/MM/yy");
	        Calendar cal = Calendar.getInstance();
	        result = df.format(cal.getTime());
	        break;
		case 3:
			splitArray = "I am learning Core Java".split(" ");
			break;
		default:
			throw new InvalidInputException("Valid input range is 1-3");
		}
		return result;
	}

}
