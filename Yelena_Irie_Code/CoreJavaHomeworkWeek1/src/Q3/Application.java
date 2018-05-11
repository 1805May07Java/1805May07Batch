package Q3;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public String Reverse(String w1){
    	
    	        String rWord="";
    			for(int i=w1.length()-1;i >= 0;i--) {
    				rWord+= ""+w1.charAt(i)+"";
    			}
        System.out.println(rWord);
        return rWord;
    }
}
