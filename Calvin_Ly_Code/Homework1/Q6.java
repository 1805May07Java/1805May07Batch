package Homework;

import java.util.Scanner;

public class Q6 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number: ");
        int num = input.nextInt();
        checkEven(num);
    }
    static void checkEven(int number){
        //int datatype truncates decimals. if condition is not met, number is odd
        if((number/2)*2 == number)
            System.out.println(number+" is even.");
        else
            System.out.println(number+" is odd.");
    }
}
