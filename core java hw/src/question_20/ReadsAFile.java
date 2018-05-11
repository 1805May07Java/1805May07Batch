package question_20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadsAFile {
	public static void main(String[] args) throws FileNotFoundException {
		File file=new File("src/question_20/Data.txt");
	    System.out.println(file.exists());
	    
	}
}
