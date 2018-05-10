package Q20;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class Application {

	public static void main(String[] args) {
		// Q20. Create a notepad file called Data.txt and enter the following: 
		//Mickey:Mouse:35:Arizona
		//Hulk:Hogan:50:Virginia
		//Roger:Rabbit:22:California
		//Wonder:Woman:18:Montana

		//Write a program that would read from the file and print it out to the screen in the following format:

		//Name: Mickey Mouse
		//Age: 35 years
		//State: Arizona State
          
	}
	private BufferedReader readData(String path) throws FileNotFoundException {
		// TODO Auto-generated method stub
		BufferedReader rData = new BufferedReader(new FileReader(path));
	    // while() {
	    	  
	    // }
		return rData;
		 
	}

}
