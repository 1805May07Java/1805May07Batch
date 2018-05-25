package Homework;

public class Q3 {
    public static void main(String[] args){
        String a = "Reverse this String"; //original string
        String b = ""; //empty string

        //start at the end of the string, and go backwards
        //use length-1, because of 0 starting index
        for(int index = a.length()-1; index >= 0; index--)
            b = b + a.charAt(index); //

        System.out.println(b);
    }
}
