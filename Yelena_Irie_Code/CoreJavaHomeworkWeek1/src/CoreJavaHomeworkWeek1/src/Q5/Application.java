package Q5;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Application app =new Application();
       app.wSubString("test", 3);
	}
     String wSubString(String w1,int n) {
    	 String rWord="";
    	  if(w1.length()-1 >= n) {
			for(int i=0;i <= n-1;i++) {
				rWord+= ""+w1.charAt(i)+"";
			 
			    System.out.println(rWord);
    	     
	       }
         }else {
        	 System.out.println("Number greater than Length of String");
         }
		return rWord;
     }
}
