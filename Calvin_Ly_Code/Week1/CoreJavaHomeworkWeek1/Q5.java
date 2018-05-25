package Homework;

public class Q5 {
    public static void main(String[] args){
        String str = "TestingString";
        System.out.println(substr(str,5));
    }
    public static String substr(String a, int endIndx){
        String substr = ""; //empty string to store chars
        for(int i=0; i<endIndx; i++){
            substr = substr + a.charAt(i); //insert char into string at index i
        }
        return substr;
        //return a.substring(0,indx-1);
    }
}
