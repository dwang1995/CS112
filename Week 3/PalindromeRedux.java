/*
 * Palindrome.java
 * 
 * Author: Wayne Snyder
 * Boston University CS 112, Spring 2016
 * 
 * Purpose: This is an exercise in debugging by implementing a
 * palindrome-checker using an auxiliary array. 
 */
import java.util.Scanner;
import java.util.Arrays;

public class PalindromeRedux {
    
    public static boolean debug = true;
    
    public static void db(String s) { 
        if(debug)
            System.err.println("\t" + s);
    }    
    
    public static final int SIZE = 30; 
    
    // Check whether str is a palindrome by moving first half of the string
    // to an array, and then go backward through array and forward
    // through str and compare. 
    
    public static boolean palindrome(String str) {
        
        char[] A = new char[SIZE];        // array to hold first half of string
        int next = 0;                     // next location to put a character                  
        // The str.lenght()/2 is where the problem coming from
        // I will name it into a new variable called "middle" to help me do the correction
        int middle = str.length()/2;
        db("this is middle: " + middle);
        
// Move first half of str into the array.
        for (int i = 0; i < middle ; i++) { 
            A[next] = str.charAt(i);
            ++next;
        }
        db("the first half array( " + Arrays.toString(A) + " )");
        
        // This is where the error come from
        if (str.length() % 2 == 0){
            middle += 0;
        }
        else{
            middle += 1;
        }
        // Compare array backwards with rest of str. 
        for (int i = middle; i < str.length(); i++) {                                 
            --next;
            char c = A[next];
            db("the character here ready to compare is " + c);
            db("the character to compare with is " + str.charAt(i));
            db("if these two letters are not equal, it should return false");
            if (c != str.charAt(i))            
                return false;
        }
        
        return true;
    }     
    
    public static void main(String[] args) {
        
        System.out.println("\nIs redder a palindrome? Should be true:");
        System.out.println(palindrome("redder"));
        
        System.out.println("\nIs reddet a palindrome? Should be false:");
        System.out.println(palindrome("reddet"));
        
        System.out.println("\nIs rer a palindrome? Should be true:");
        System.out.println(palindrome("rer"));
        
        System.out.println("\nIs re a palindrome? Should be false:");
        System.out.println(palindrome("re"));
        
        System.out.println("\nIs app a palindrome? Should be false:");
        System.out.println(palindrome("app"));
        
        System.out.println("\nIs QAQ a palindrome? Should be true:");
        System.out.println(palindrome("QAQ"));
        
        System.out.println("\nIs e a palindrome? Should be true:");
        System.out.println(palindrome("e"));
        
        System.out.println("\nIs palindrome a palindrome? Should be false:");
        System.out.println(palindrome("palindrome"));
        
        System.out.println("\nIs dayuan a palindrome? Should be false:");
        System.out.println(palindrome("dayuan"));
       
        System.out.println("\nIs zhang a palindrome? Should be false:");
        System.out.println(palindrome("zhang"));
        
        System.out.println("\nIs ABCBA a palindrome? Should be true:");
        System.out.println(palindrome("ABCBA"));
        
        System.out.println("\nWelcome to the Palindrome Test Program!");
        
        // Define a scanner for user input
        
        Scanner userInput = new Scanner(System.in);
        
        while(userInput.hasNextLine()) {
            
            String line = userInput.nextLine();
            
            if(palindrome(line)) 
                System.out.println("Palindrome!");
            else
                System.out.println("Not a palindrome!");
    }
    
    }}