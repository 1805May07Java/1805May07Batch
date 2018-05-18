package com.ex.inheritance;

class Baap{ 
	public int h = 4;
	public int getH(){
		System.out.println("Baap "+h);
		return h;
	}
}

public class Beta extends Baap{
	public int h = 44;
	public int getH(){
		System.out.println("Beta "+ h); 
		return h;
	}
	
public static void main(String[] args) {
		Baap b = new Beta(); 
		System.out.println(b.h + " " +b.getH());
		Beta bb = (Beta) b;
		System.out.println(bb.h+" "+bb.getH());
		
	}

/*When an overridden method is called through a reference of parent class, 
 * then type of the object determines which method is to be executed. 
 * Thus, this determination is made at run time.
*/


/* Baap b = new Beta(); 
		// any instance variables belong to Baap, but Betas constructor and overwritten methods are called
		System.out.println(b.h + " " +b.getH());
		//b.getH sill call betas H which will be Beta 44, and return 44, 
		// b.h will call baaps b which is 4, hence 4 44, Beta 44
		Beta bb = (Beta) b;
		// bb.h is a beta now so 44 44, beta 44
		System.out.println(bb.h+" "+bb.getH());
* instance methods are overridden and variables are hidden.
*  which method is 
* invoked depends on the class of the actual object, while which field is accessed depends on the class
* of the variable
* Here, b refers to an object of class Beta, so b.getH() will call the overridden (subclass's) method. However, the ref type
* of b is Baap so b.h will refer to Baap's h. Further, inside 
* Beta's getH(), Beta's h will be accessed inside of Baap's h because
* you are accessing this.h ('this' is implicit) and the type of this is Beta
* The class of bb, on the other hand, is Beta, so bb.h will refer to Betas h
*/
}
