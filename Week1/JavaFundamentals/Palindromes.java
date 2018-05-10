package com.rev.exercises;

import java.util.ArrayList;

public class Palindromes {

	public static void main(String[] args) 
	{
		ArrayList<StringBuilder> possibles = new ArrayList<StringBuilder>();
		ArrayList<StringBuilder> dromes = new ArrayList<StringBuilder>();
		
		possibles.add(new StringBuilder("karan"));
		possibles.add(new StringBuilder("madam"));
		possibles.add(new StringBuilder("tom"));
		possibles.add(new StringBuilder("civic"));
		possibles.add(new StringBuilder("radar"));
		possibles.add(new StringBuilder("sexes"));
		possibles.add(new StringBuilder("jimmy"));
		possibles.add(new StringBuilder("kayak"));
		possibles.add(new StringBuilder("john"));
		possibles.add(new StringBuilder("refer"));
		possibles.add(new StringBuilder("billy"));
		possibles.add(new StringBuilder("did"));
		
		
		for(int i = 0; i < possibles.size(); i++)
		{
			StringBuilder temp = new StringBuilder(possibles.get(i));
			temp.reverse();
			if(possibles.get(i).toString().equals(temp.toString()))
			{
				dromes.add(possibles.get(i));
			}
			
		}
		
		System.out.print(dromes);
	}

}

