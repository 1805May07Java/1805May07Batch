package Homework;

public class Q2 {
    public static void main(String[] args){
        //first 2 numbers are always 0 and 1
        int f1=0;
        int f2=1;
        System.out.print(f1 + " "+ f2 +" ");
        //loop iterates until count=25
        //count starts at 2 because two numbers are printed already
        for(int count=2; count<=25;count++){
            //fibonacci sequence is the sum of the two previous numbers
            int f3=f1+f2;
            System.out.print(f3 +" ");
            f1=f2;
            f2=f3;
        }
    }
}
