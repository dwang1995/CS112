/* File: PalindromeTest.java
 * Author: Dayuan Wang
 * Date: January 28th, 2016
 * Purpose: This is a template for HW02, Problem B.1 (Lab problem)
 */


import java.util.Scanner;

public class PalindromeTest { 
    
    public static void main(String[] args) {
        
        // Print out welcome message
        
        System.out.println("\nWelcome to the String Test Program!");
        
        // Define a scanner for user input
        
        Scanner userInput = new Scanner(System.in);
        
        
        System.out.println("\nType in a sentence or Control-d to end:"); 
        while(userInput.hasNextLine()) {
            String line = userInput.nextLine();
            
            char[] charsToRemove = {'\'','.',',',':',';','!','?','"','/','-','(',')','~'};
            
            line = line.toLowerCase();
            // Use the loop to scane the whole array
            // We are going to remove all the characters that we don't want.
            for( int i = 0; i< charsToRemove.length; ++i){
                String a = Character.toString(charsToRemove[i]);
                line = line.replace(a,"");
            }
            // We are going to check for the white space by using the loop. 
            // when we see a white space, we remove it. 
            for( int i = 0; i< line.length(); ++i){
                if (Character.isWhitespace(line.charAt(i))){
                    line = line.replace(" ","");
                }
            }
            
            boolean a =true;
            // We are going to check if the character is mirror (beginning vs end)
            // And print out the result that we need. 
            for( int i = 0; i < line.length(); ++i){
                if (line.charAt(i) != line.charAt((line.length() - 1)- i)){
                    System.out.println("Not a palindrome!");
                    a = false;
                    break;
                }
            }
            if (a == true){
                System.out.println("Palindrome!");
            }
        }
        System.out.println("bye!"); 
    }
}
