package Homework;

import java.util.Scanner;

public class Q17 {
    public static void main(String[] args){
        double interest, rate, principal, time;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your Principal value: ");
        principal = input.nextInt();
        System.out.println("Enter your Rate value: ");
        rate = input.nextInt();
        System.out.println("Enter your Time value: ");
        time = input.nextInt();

        interest = principal*rate*time;
        System.out.print("Your total Interest is: "+ interest);
    }
}
