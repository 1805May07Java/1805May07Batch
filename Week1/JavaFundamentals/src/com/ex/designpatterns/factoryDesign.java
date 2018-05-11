package com.ex.designpatterns;

import java.util.Scanner;

interface Currency {
       String getSymbol();
}
// Concrete Rupee Class code
class Rupee implements Currency {
       @Override
       public String getSymbol() {
              return "Rs";
       }
}

// Concrete SGD class Code
class SGDDollar implements Currency {
       @Override
       public String getSymbol() {
              return "SGD";
       }
}

// Concrete US Dollar code
class USDollar implements Currency {
       @Override
       public String getSymbol() {
              return "USD";
       }

}
 // Factory Class code
class CurrencyFactory 
{

       public static Currency createCurrency (String country) {
       if (country. equalsIgnoreCase ("India")){
              return new Rupee();
       }else if(country. equalsIgnoreCase ("Singapore")){
              return new SGDDollar();
       }else if(country. equalsIgnoreCase ("US")){
              return new USDollar();
        }
       throw new IllegalArgumentException("No such currency");
       }
}


public class factoryDesign 
{
	
	public static void main(String[] args) 
	{
		System.out.println("Which country?");
		Scanner reader = new Scanner(System.in);
		String country = reader.nextLine();
        Currency rupee = CurrencyFactory.createCurrency(country);
        System.out.println(rupee.getSymbol());

	}

}
