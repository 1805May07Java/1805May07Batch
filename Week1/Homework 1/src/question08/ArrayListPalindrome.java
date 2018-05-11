package question08;

import java.util.ArrayList;

public class ArrayListPalindrome {
	 public static String reverse(String str) 
	    {     
	        if ((str==null)||(str.length() <= 1) )
	            return str;
	        return reverse(str.substring(1)) + str.charAt(0);
	    }
	
	 public static ArrayList<String> arrListInit() {
		 ArrayList<String> list = new ArrayList<String>();
		 list.add("karan");
		 list.add("madam");
		 list.add("tom");
		 list.add("civic");
		 list.add("radar");
		 list.add("sexes");
		 list.add("jimmy");
		 list.add("kayak");
		 list.add("john");
		 list.add("refer");
		 list.add("billy");
		 list.add("did");
	
		 return list;
	 }
	 
	 public static void main(String [] args) {
		 ArrayList<String> listFull = arrListInit();
		 ArrayList<String> listPalindrome = new ArrayList<String>();
		 
		 for (String i : listFull) {
			 if (reverse(i).equals(i)) {
				 listPalindrome.add(i);
				 System.out.print(i + ", ");
			 }
		 }
	 }
}
