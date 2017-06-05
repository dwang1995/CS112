
/**
 * name: Dayuan Wang(wangdayu@bu.edu)
 * A program that loads the English dictionary into memory and allows the user
 * to search the dictionary.
 * 
 * 1. if we use simple linked list, we need to use 16 bytes
 * 2. if we use trie we can save 16-7 = 9 bytes
 * 3. the worst case for trie search is theta(M), it is faster than link list search
 * 4. If we use a link list, we need to use the extract space to remember the pattern part, use the pattern part to compare with
 * the link list; if the pattern match, then we will take it as the result. 
 */
import java.util.*;
import java.io.*;

public class WordSearcher {
    public static int charToIndex(char ch) {
        return ch - 'a';
    }
    
    public static String processWord(String A){
        String B = "";
        char C ;
        int length = A.length();
        for(int i=0; i< length; ++i){
            C = Character.toLowerCase(A.charAt(i));
            //System.out.println(C);
            if(-1<charToIndex(C) &&  charToIndex(C)< 26){
                B += ""+C;
            }
        }
        return B;
    }
    
    public static void main(String[] args) {
        //System.out.println(processWord("AAA"));
        try{
            File wordsFile = new File("words.txt");
            TrieNode root = new TrieNode();
            // TODO add code here for Task 3
            BufferedReader reader = new BufferedReader(new FileReader(wordsFile));
            String word = reader.readLine();
            while(word != null){
                //System.out.println(word);
                root.add(processWord(word));
                word = reader.readLine();
                
                //System.out.println(processWord(word));
                
            }
            //root.printKeys();
            Scanner input = new Scanner(System.in);
            System.out.print("Enter a string: ");
            while (input.hasNextLine()) {
                
                String line = input.nextLine();
                root.match(line);
                System.out.print("Enter a string: ");
                
            }
        }
        catch(IOException e){
            System.err.println("IOException");
        }
    }
}


