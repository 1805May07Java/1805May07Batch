package com.revhomework.Question3;

public class QuickReversal 
{
		public static void main(String [] args) 
		{
			
			reverse("Abra, Kadabra, Alakazam");
			reverse("who is the greatest wizard");
			reverse("in all the land?");
			reverse("Why it is I of course,");
			reverse("Veeder Meeker, Sorceror at Law.");
			
			
		}
		
		
		
		public static void reverse(String str) 
		{
			
			for(int i = str.length() - 1; i >= 0; i--)
			{
				System.out.print(str.charAt(i));
			}
			System.out.println("");
		}
		
		
}
