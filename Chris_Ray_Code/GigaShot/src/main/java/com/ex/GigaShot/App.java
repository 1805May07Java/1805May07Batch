package com.ex.GigaShot;

public class App 
{
    public static void main( String[] args )
    {
        GigaShot gigashot = new GigaShot();
        
        gigashot.add10AndPrint("12"); //good
        String str = gigashot.toUpperCase("hello");
        System.out.println(str); //good
        
        System.out.println(gigashot.checkIfUpperCaseLettersArePresent("abCdef")); // good
        System.out.println(gigashot.checkIfUpperCaseLettersArePresent("abcdef")); //good
    }
}
