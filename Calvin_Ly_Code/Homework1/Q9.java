package Homework;

import java.util.ArrayList;

public class Q9 {
    public static void main(String[] args){
        System.out.println("Printing Prime Numbers from 1-100.");
        ArrayList<Integer> numList = new ArrayList<Integer>();
        //loop to store nums from 1-100
        for (int i = 1; i<=100; i++)
            numList.add(i);
        //loop to check each num if prime
        for(int i : numList){
            if(checkPrime(i)){
                System.out.print(i+ " ");
            }
        }

    }
    static boolean checkPrime(int num){
        //prime num cannot be negative, 0, or 1
        if(num<=1)
            return false;
        else{
            //trial division method to check prime.
            for(int i = 2; i<= num/2; i++){
                if(num % i==0)
                    return false;
            }
        }
        return true;
    }
}
