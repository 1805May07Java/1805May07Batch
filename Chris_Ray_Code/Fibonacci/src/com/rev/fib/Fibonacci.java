package com.rev.fib;

public class Fibonacci {

	public static void main(String[] args) {
                  
	}
	
	/*public static void printFib(int n) {
		int n1=0,n2=1,n3,i,count=n;    
	       System.out.print(n1+" "+n2);  
	          
	       for(i=2;i<count;++i){    
	        n3=n1+n2;    
	        System.out.print(" "+n3);    
	        n1=n2;    
	        n2=n3;    
	       }
	}*/
	
	public static int fib(int n) {
		int n1 = 0;
		int n2 = 1;
		int count = n;
		int n3 = 0;
		int i;
		for(i=2; i < count; ++i) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
		}
		return n3;
	}
}
 
  