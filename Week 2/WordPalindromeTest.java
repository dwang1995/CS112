/* File: WordPalindromeTest.java
 * Author: Dayuan Wang
 * Date: January 27th, 2016
 * Purpose: This is a template for HW02, Problem B.1 (Lab problem)
 */


import java.util.Scanner;

public class WordPalindromeTest { 
    
    public static void printArray(String[] a){
        System.out.print("\n[");
        for( int i = 0; i < a.length-1; ++i)
            System.out.print(a[i] + ", ");
        System.out.print(a[a.length-1] + "]\n");
    }
  
  public static void main(String[] args) {
    
    // Print out welcome message
    
    System.out.println("\nWelcome to the String Test Program!");
        
    // Define a scanner for user input
    
    Scanner userInput = new Scanner(System.in);
    

    System.out.println("\nType in a sentence or Control-d to end:"); 
    while(userInput.hasNextLine()) {
       String line = userInput.nextLine();
       // Just like the first one in the lab, we are going to check the Palindrome
       // Make a list of all the character that we want to remove first
       char[] charsToRemove = {'\'','.',',',':',';','!','?','"','/','-','(',')','~'};
       // lower case all the letters
       line = line.toLowerCase();
       // Use a loop to check that if this is the character we want to remove it
       // if it is true, we are going to remove it
       for( int i = 0; i< charsToRemove.length; ++i){
           String a = Character.toString(charsToRemove[i]);
           line = line.replace(a,"");
       }
       // We are going to split the sentence to the array by each word. 
       String[] words = line.split("\\s+");
       printArray(words);
       
       boolean a = true;
       // We are going to check the palindrome now
       // unlike the last one, we are not going to check the characters
       // We are going to check if the words are mirror (frist vs last words are same?)
       for( int i = 0; i < words.length; ++i){
           
           if (words[i].equals(words[(words.length-1)-i]) != true){
               System.out.println("Not a Word Palindrome!");
               a = false;
               break;
           }
       }
       if (a == true){
           System.out.println("Word Palindrome!");
       } 
     
    }
    System.out.println("bye!");
 
    
  }
  
}