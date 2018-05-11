package Homework;

import java.util.ArrayList;
import java.util.Arrays;

public class Q8 {
    public static void main(String[] args){
        //making 2 arraylists
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> palindromes = new ArrayList<>();
        //making string array of the words and adding it to list1 ArrayList.
        String[] strings = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",  "refer", "billy", "did"};
        list1.addAll(Arrays.asList(strings));

        for(String word : list1){
            //making temp string for storing reverses
            String temp = "";
            //loop to reverse the word and store in temp
            for(int wordIndex = word.length()-1; wordIndex >= 0; wordIndex--)
                temp = temp + word.charAt(wordIndex);
            //if reversed word equals original word, add to palindromes ArrayList
            if(word.equals(temp))
                palindromes.add(word);
        }
       printPalindromes(palindromes);
    }
    //method to print stored palindromes
    static void printPalindromes(ArrayList<String> palindromes){
        for (String words : palindromes){
            System.out.print(words + " ");
        }
    }
}
