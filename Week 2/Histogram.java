/* File: Histogram.java
 * Author: Dayuan Wang
 * Date: January 29th, 2016
 * Purpose: This is a template for HW02, Problem B.1 (Lab problem)
 */


import java.util.Scanner;

public class Histogram { 
    // this is the limited number that we decide how many values we want to keep in this program.
    public static int Maxnumber = 20;
    public static int num_bins = 10;
    // This is telling us how many series of numbers we want to keep countining. This time is 100/10= 10.
    public static final int Bin_size = 100 / num_bins;
    // This is the function that I am going to print out the heading
    public static void printHeading(){
        System.out.println("\nWelcome to the Histogram Program!");
        System.out.println("This program will print out a histogram of the numbers");
    }
    // I am going to set a variable that can be used everywhere in this program; it is a
    // integer "count" that keep tracking how many numbers I have input in this program.
    public static int count = 0;
    // This is the list I will be used later to print out the histogram, there should be some better ways, but I 
    // think this is the clearest ways for me. 
    public static String[] List = {"(0..10]:\t","(10..20]:\t","(20..30]:\t","(30..40]:\t","(40..50]:\t","(50..60]:\t","(60..70]:\t","(70..80]:\t","(80,90]:\t","(90..100]:\t"};
    // This is the method that I am going to print out the number of asterisks.
    // I will use loop to keep concat the asterisks
    public static String printAsterisks(int a){
        String Y = "";
        for (int i = 0; i < a; i++){
            Y= Y.concat("*");
        }       
        return Y;
    }
    // This the the method that I am going to print out the whole histogram
    // I will use the helper method printAsterisks and helper list to do this.
    public static void printHistogram(int histogram[]){
        System.out.println("Histogram of Values in Decades from 0 to 100:");
        for (int i = 0; i< histogram.length; i++){
            System.out.print(List[i]  + printAsterisks(histogram[i])+"\n");
        }
    }
    // This is the method that determine a input is a valid or not
    public static boolean validInput(double a){
        if (a<0.0 || a>100.0 ){
            return false;
        }
        else{
            return true;
        }
    }
    // This is the method that going to print out all the input in a array. 
    // If the input is less or equal to the max number of input, it will count how many numbers are there, and print out
    // else, it will print out only the first 20 valid input.
    public static void printArray(double[] a){
        if (count<Maxnumber){
            System.out.print("\nYour input" + count +" numbers: [");
            for (int i = 0; i < count -1 ; i++)
                System.out.print(a[i] + ",");
            System.out.println(a[count-1] +"]");
        }
        else{
            System.out.print("\nYour input " + Maxnumber +" numbers: [");
            for (int i = 0; i < a.length -1 ; i++)
                System.out.print(a[i] + ",");
            System.out.println(a[a.length-1] +"]");
        }
    }
    // This is the main method for this program
    public static void main(String[] args) {
        
        // Print out welcome message
        
        printHeading();
        
        // Create a array to track all the valid input values
        double[] number = new double[Maxnumber];
        // Create a array to track the "histogram" of each input
        int[] histogram = new int[Bin_size];
        // Get the input from the user.
        Scanner userInput = new Scanner(System.in);
        System.out.println("\ninput by the user; enter up to 20 doubles and hit Control-d to end:"); 
        while(userInput.hasNextLine()) {
            double num ;
            if (userInput.hasNextDouble()){
                num = userInput.nextDouble();}
            else break;
            // when we are getting the input from the user, we are keep checking if it is valid or not
            // if it is not valid, we will not put the number into the array, and ask for a new number
            if (validInput(num)==true){  
                if (count<Maxnumber){
                    number[count] = num;                 
                }
                ++count;
            }
            else{
                System.out.println("Input must be a double in range [0..100], try again!");
            }        
        }
        // When the input numbers more than max number we can have, print this line.
        if (count> Maxnumber){
            System.out.println("Maximum number of inputs (20) exceeded, proceeding to calculate Histogram...\n");
        }
        // this is the part that I am going to determine which histogram is each number should be
        if (count< Maxnumber){
            for (int i = 0; i < count; i++){
                if (number[i] % Bin_size == 0.0 && number[i] != 0.0)
                    histogram[(int)(number[i] / Bin_size) - 1]++;
                else
                    histogram[(int)(number[i] / Bin_size)]++;
            }}
        else{
            for (int i = 0; i < number.length; i++){
                if (number[i] % Bin_size == 0.0 && number[i] != 0.0)
                    histogram[(int)(number[i] / Bin_size) - 1]++;
                else
                    histogram[(int)(number[i] / Bin_size)]++;
            }
        }
        //System.out.println("bye!");
        //for (int i = 0; i < histogram.length; ++i){
        //    System.out.print(histogram[i] + ",");
        //}
        
        // Use the method we write to print out the things we want. 
        printArray(number);
        printHistogram(histogram);       
    }    
}