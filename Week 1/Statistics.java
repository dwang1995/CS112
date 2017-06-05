/*
 * File: Statistics.java
 * Author: Dayuan Wang
 * Date: 1.21.2015
 * HW01, Problem B.2
 */

import java.util.Scanner;
public class Statistics{
    public static void main(String[] args){
        System.out.println("Welcome to the Statistics Program!");
        System.out.println("This program will print out the sum, max, mean, variance, and\nstandard deviation for three integers input by the user.\n");
        // this part is to get the input from the user
        Scanner userInput_1 = new Scanner(System.in);
        System.out.println("\nType in the first number and then hit return:"); 
        int numOne = userInput_1.nextInt(); 
        System.out.println("\nYour input was " + numOne);// this will get the first input (integer) from the user
        
        Scanner userInput_2 = new Scanner(System.in);
        System.out.println("\nType in the second number and then hit return:"); 
        int numTwo = userInput_2.nextInt(); 
        System.out.println("\nYour input was " + numTwo);// this will get the second input from the user
        
        Scanner userInput_3 = new Scanner(System.in);
        System.out.println("\nType in the third number and then hit return:"); 
        int numThree = userInput_3.nextInt(); 
        System.out.println("\nYour input was " + numThree + "\n");// this will get the third input from the user
        
        System.out.println("You have input the numbers " + numOne + ", " + numTwo + ", and " + numThree + ".\n");
        // this is the part I will do the calculation
        int sum = numOne + numTwo + numThree;// find the sum from three inputs
        int max_in_first_two = Math.max(numOne, numTwo);// this will find the max from the first two
        int max = Math.max(max_in_first_two, numThree);// this will use the max from first two and compare to the third number, to find the max overall
        int min_in_first_two = Math.min(numOne, numTwo);// this will find the min from the first two
        int min = Math.min(min_in_first_two, numThree);// this will use the min from first two and compare to the third number, to find the min overall
        double mean = sum/(double)3;// this is the calculation of the mean
        double variance = ((numOne - mean)*(numOne - mean) + (numTwo - mean)*(numTwo - mean) + (numThree - mean)*(numThree - mean))/(double)3;
        int range = max - min;
        double standard_deviation = Math.sqrt(variance);
        // Print out the result I get from the calculation
        System.out.println("The sum is " + sum);
        System.out.println("The max is " + max);
        System.out.println("The min is " + min);
        System.out.println("The range is " + range);
        System.out.printf("The mean is %.2f\n" ,mean);
        System.out.printf("The variance is %.2f\n" ,variance);
        System.out.printf("The Standard Deviation is %.2f\n" ,standard_deviation);
        // This part will find the median of the three numbers
        // if the number is not max and is not min, it is the median of the three numbers
        // find it, and print it out
        if ((numOne == max) && (numTwo == min) ){
            int median = numThree;
            System.out.println("The median is " + median);
        }
        else if ((numOne == max) && (numThree == min)){
            int median = numTwo;
            System.out.println("The median is " + median);
        }
        else if ((numThree == min) && (numTwo == max)){
            int median = numOne;
            System.out.println("The median is " + median);
        }
        else if ((numOne == min) && (numTwo == max)){
            int median = numThree;
            System.out.println("The median is " + median);
        }
        else if ((numThree == max) && (numTwo == min)){
            int median = numOne;
            System.out.println("The median is " + median);
        }
        else{
            int median = numTwo;
            System.out.println("The median is " + median);
        }
    }
}