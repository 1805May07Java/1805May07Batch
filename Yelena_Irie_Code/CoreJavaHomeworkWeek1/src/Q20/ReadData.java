package Q20;



 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReadData {

	
	private String line;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException {
		String path="";
		String content = readData("C:\\Users\\Yelena\\eclipse-workspace\\Yelena_Irie_Code\\CoreJavaHomeworkWeek1\\src\\Q20\\Data.txt");
		String[] s = content.split("\n");
		for(String str : s) {
			formatData(str.trim());
		}
		
	}

	private void formatData(String str) {
		// TODO Auto-generated method stub
		String newline="\n";
		String Name = "Name: "+str.split(":")[0] +" "+str.split(":")[1];
		String Age = "Age: "+str.split(":")[2];
		String State="State: "+str.split(":")[3];
				
		String frmt = Name+newline+Age+newline+State;
		System.out.println(frmt);
		System.out.println("");
	}

	private String readData(String path) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader b= new BufferedReader(new FileReader(path));
		String content = "";
		
		
		while((line = b.readLine()) != null) {
			  content+=line+"\n";
		  }
		
		 return content;
		 } 
	 
}
