package Homework;

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args){
        //4! = 1*2*3*4
        Scanner input = new Scanner(System.in);
        int factorial=1; //factorial always starts at 1
        System.out.print("Enter number: ");
        int num = input.nextInt();

        //a is the counter
        for(int a=1; a<=num; a++){
            //4! = 1*2*3*4
            factorial*=a;
        }
        System.out.println(num +"! = "+factorial);
    }
}
