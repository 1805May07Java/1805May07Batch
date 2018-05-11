package Q20;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Application {

	public static void main(String[] args) {
	
          
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

	public String readData(String path) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader b= new BufferedReader(new FileReader(path));
		String content = "";
		
		
		String line;
		
		while((line = b.readLine()) != null) {
			  content+=line+"\n";
		  }
		
		 return content;
		 }

}
