package Homework;

import java.util.Scanner;

public class Q10 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter num1: ");
        int num1 = input.nextInt();
        System.out.println("Enter num2: ");
        int num2 = input.nextInt();

        //if (num1>num2), print num2 is minimum, else print num1 is minimum
        String result = (num1>num2) ? num2+ " is the minimum." : num1+ " is the minimum.";
        System.out.println(result);

    }
}
