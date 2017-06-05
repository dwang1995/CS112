/* File: BigInt.java
 * Date: 2/11/16
 * Author:  Dayuan Wang
 * Class: CS 112, Spring 2016
 * Homework: HW 04, Problem B.2
 * Purpose: This is a template for the BigInt class, representing big integers.  
 */
import java.util.Arrays;
public class BigInt  {  
    // this is a helper function
    // I am going to change a string to a character array
    private static char[] String_to_char_list(String s){
        int len = s.length();
        char[] A = new char[len];
        for(int i = 0; i<len; ++i){
            A[i] = s.charAt(i);
        }
        return A;
    }
    // this is a helper function
    //I am going to change the character array to a integer array 
    private static int[] char_list_to_int(char[] A){
        int len = A.length;
        int[] C = new int[len];
        for(int i = 0; i< len; ++i){
            C[i] = (int)A[i]-48;
        }
        return C;
    }
    
    private int[] A = new int[BigMath.SIZE]; 
    
    // These constructors will build a new instance of this class
    // and return it, see the Unit Test below for how to use them. 
    
    public BigInt() {        // Default constructor   
    }
    
    public BigInt(String s) {    // These will not work until you implement putValue(..)
        putValue(s);
    }
    
    public BigInt(int[] B) {
        putValue(B);
    }
    
    public BigInt(int n) {
        putValue(n);
    }
    // this is the method going to tell me what is my length of my input
    // for example input 33 will give me lenght of 2
    public int length() {
        int zero = 0;
        for(int i = 0; i< BigMath.SIZE; ++i){
            if(A[i] != 0){
                zero = i;
                break;}
        }
        if(zero != 0){
            int B = BigMath.SIZE - zero;
            return B;
        }
        else{
            return 1;
        }
        
    }
    // I am going to use the two helper function to process the string, and put into the 
    // Bigint
    public void putValue(String s) {
        char[] C = String_to_char_list(s);
        int[] D = char_list_to_int(C);
        int index = BigMath.SIZE - D.length;
        for(int i=0; i< D.length; ++i){
            A[index] = D[i];
            ++index;
        }
        //System.out.println(Arrays.toString(A));
    }
    // When we get a integer array as the input, we just need to put them in order
    // and create the BigInt
    public void putValue(int[] B) {
        int index = BigMath.SIZE - B.length;
        for(int i=0; i< B.length; ++i){
            A[index] = B[i];
            ++index;
        }
        //System.out.println(Arrays.toString(A));
    }
    // This is the process of processing the integer into a BigInt
    // I am going to create a integer array and process the whole integer into that array
    // I am going to use the % to get each number
    // and then /10 to process the number
    // When I seperate the whole integer into the integer array, I can process the array
    // and put each number into the BigInt
    public void putValue(int n) {
        int a = n;
        int b = n;
        int the_index = 0;
        while(a>0){
            a = a/10;
            the_index += 1;
        }
        //System.out.println(the_index);
        int the_index_1 = the_index;
        int[] AA = new int[the_index];
        while(b>0){
            AA[the_index_1-1]= b % 10;
            b /= 10;
            the_index_1 -= 1;
        }
        int index = BigMath.SIZE - AA.length;
        for(int i=0; i< AA.length; ++i){
            A[index] = AA[i];
            ++index;
        }
        //System.out.println(Arrays.toString(A));
    }
    // We need to find where out actual number starts at
    // When we find the first place is not a zero, that is where we start with
    // if we want to find the 3rd actual number, we need to use 3 plus the number of zero
    // in the front of the array
    public int digitAt(int i) {
        int index = 0;
        for(int j = 0; j<BigMath.SIZE; ++j){
            if(A[j] != 0){
                index = j;
                break;
            }}
        return A[i + index];                // just to get it compile
    }
    // This is the same thing with last method
    // but this time when we find the number, we will replace that number 
    // by another new integer
    public void putDigitAt(int i,int n) {
        int index = 0;
        for(int j = 0; j<BigMath.SIZE; ++j){
            if(A[j] != 0){
                index = j;
                break;
            }}
        A[i + index] = n;
    }
    // This is the method to print out all the actual number from the array
    // we need to find where our number starts
    // when we find it, we need to create a string and use for loop to add
    // each number into that string and print it out
    public String toString() {
        int index = 0;
        for(int j = 0; j<BigMath.SIZE; ++j){
            if(A[j] != 0){
                index = j;
                break;
            }
        }
        String P = "";
        if(index != 0){
            for(int i = index; i< BigMath.SIZE; ++i){
                P += "" + A[i];
            }
            return P;
        }
        else{
            return "0";
        }
        
    }
    
    
    public static void main(String [] args) {
        
        System.out.println("\nUnit Test for BigInt Class");
        
        int[] a = {3,1,4,1,5,9,2,6,5,3,5,8,9,7,9,3,2,3,8,4,6,2,6,4,3,3,8};
        String b = "314159265358979323846264338327950288";
        int c = 314159265;
        
        BigInt A = new BigInt();
        A.putValue(a);
        
        System.out.println("\nTest 1: Should be:\n27");
        System.out.println( A.length() );
        
        System.out.println("\nTest 2: Should be:\n314159265358979323846264338");
        System.out.println( A );
        
        
        
        BigInt B = new BigInt();
        B.putValue(b);
        
        System.out.println("\nTest 3: Should be:\n36");
        System.out.println( B.length() );
        
        System.out.println("\nTest 4: Should be:\n314159265358979323846264338327950288");
        System.out.println( B );
        
        BigInt C = new BigInt();
        C.putValue(c);  
        
        System.out.println("\nTest 5: Should be:\n9");
        System.out.println( C.length() );
        
        System.out.println("\nTest 6: Should be:\n314159265");
        System.out.println( C );
        
        BigInt Z = new BigInt();       // will be zero
        
        // Special case: 0 will have length 1 and print out as a single digit
        
        System.out.println("\nTest 7: Should be:\n1");
        System.out.println( Z.length() );
        
        System.out.println("\nTest 8: Should be:\n0");
        System.out.println( Z );
        
        BigInt One = new BigInt();
        One.putValue(1);
        
        System.out.println("\nTest 9: Should be:\n1 1");
        System.out.println( One.length() + " " + One);
        
        // Even if string or array has leading zeros, you just put them in, and they get
        // treated like any other leading zeros when you check length and print out. 
        
        System.out.println("\nTest 10: Should be:\n1");
        BigInt D = new BigInt();
        D.putValue("000000004");
        System.out.println( D.length() ); 
        
        System.out.println("\nTest 11: Should be:\n4");
        System.out.println( D ); 
        
        System.out.println("\nTest 12: Should be:\n3 234");
        BigInt E = new BigInt();
        int[] e = {0,0,0,0,2,3,4};
        E.putValue(e);
        System.out.println( E.length() + " " + E ); 
        
        System.out.println("\nTest 13: Should be:\n3 4 5");
        System.out.println( C.digitAt(0) + " " + C.digitAt(2) + " " + C.digitAt( C.length() - 1 ) );
        
        System.out.println("\nTest 14: Should be:\n1000001");
        BigInt F = new BigInt("1000001");
        System.out.println( F ); 
        
        System.out.println("\nTest 15: Should be:\n12345");
        int[] g = {1,2,3,4,5};
        BigInt G = new BigInt(g);
        System.out.println( G ); 
        
        System.out.println("\nTest 16: Should be:\n54321");
        System.out.println( new BigInt(54321) ); 
        
        System.out.println("\nTest 17: Should be:\n984159265");
        C.putDigitAt(0,9);
        C.putDigitAt(1,8);
        System.out.println( C );
        
        System.out.println("\nTest 18: Should be:\n984100005");
        C.putDigitAt(4,0);
        C.putDigitAt(5,0);
        C.putDigitAt(6,0);
        C.putDigitAt(7,0);
        System.out.println( C );
        
        System.out.println("\nTest 19: Should be:\n100005");
        C.putDigitAt(0,0);
        C.putDigitAt(0,0);
        C.putDigitAt(0,0);
        System.out.println( C );
        
        System.out.println("\nTest 20: Should be:\n5");
        C.putDigitAt(0,0);
        System.out.println( C );   
        
       
    }      
}
