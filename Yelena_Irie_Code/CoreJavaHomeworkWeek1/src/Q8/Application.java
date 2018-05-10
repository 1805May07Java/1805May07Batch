package Q8;

import java.util.ArrayList;

public class Application {

	private static String w1;

	public static void main(String[] args) {
		// Q8. Write a program that stores the following strings in an ArrayList and saves all the palindromes 
		//in another ArrayList. “karan”, “madam”, ”tom”, “civic”, “radar”, “sexes”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
		String sWord[]= {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",  "refer", "billy", "did"};
		ArrayList<String> wList = new ArrayList();
		ArrayList<String> pList = new ArrayList();
		Palindromes p = new Palindromes();
		for(String s :sWord) {
			wList.add(s);
			boolean flag=true;
			for(int i=0;i < s.length();i++) {
				//System.out.println(s+" : "+p.palindromes(s,i));
				if(p.palindromes(s,i) != true) {
					flag=false;
					break;
				}
				
			
			}
			if(flag){
			    pList.add(s);
			
			}
			
	}
		


 }
}
