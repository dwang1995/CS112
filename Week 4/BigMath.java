/* File: BigMath.java
 * Date: 2/11/16
 * Author:  Dayuan Wang
 * Class: CS 112, Spring 2016
 * Homework: HW 04, Problem B2
 * Purpose: This is a template for the BigMath class.   
 */

import java.util.Arrays;
public class BigMath  { 
    
    public static final int SIZE = 50;  
    
    // This method is going to compare two BigInt to see which one of them is larger
    // If one has greater length, it will be larger
    // if they have the same length, we compare the number one by one, if the one has the larger number
    // we stop comparing them and we get the result
    public static int compare(BigInt N, BigInt M) {
        int result = 0;
        if(N.length() > M.length()){
            result = 1;
        }
        else if(N.length() < M.length()){
            result = -1;
        }
        else{
            for(int i = 0; i < N.length(); ++i){
                if(N.digitAt(i) > M.digitAt(i)){
                    result = 1;
                    break;
                }
                else if (N.digitAt(i) < M.digitAt(i)){
                    result = -1;
                    break;
                }
                else{
                    result += 0;
                }
            }
        }
        return result;
    }
    
    
    // this method is used to see if two BigInt is equal or not
    // if they do not have the same length, return false
    // if they have the same length, we compare the numbers one by one
    // if any of the number is not same, we return false
    public static boolean equals(BigInt N, BigInt M) {
        if(N.length() != M.length()){
            return false;
        }
        else{
            for(int i = 0; i< N.length(); ++i){
                if(N.digitAt(i) != M.digitAt(i)){
                    return false;
                }
            }
            return true;
        }
    }
    
    // this is the method to add up two BigInt
    public static BigInt add(BigInt N, BigInt M) {
        IntStack SN = new IntStack(60);
        IntStack SM = new IntStack(60);
        IntStack SS = new IntStack(60);
        int carry = 0;
        int the_two_sum = 0;
        int n = 0;
        int m = 0;
        // for each digit in N from left to right
        // push the digit onto SN
        for(int i=0; i<N.length();++i){
            SN.push(N.digitAt(i));
        }
        // for each digit in M from left to right
        // push the digit onto SM
        for(int j=0; j<M.length(); ++j){
            SM.push(M.digitAt(j));
        }
        // follow the argorithm for adding
        // process them while both SN and SM are not empty
        while(SN.isEmpty() == false && SM.isEmpty() == false){
            n = SN.pop();
            m = SM.pop();
            the_two_sum = n + m + carry;
            if(the_two_sum > 9){
                carry = 1;
            }
            else{
                carry = 0;
            }
            SS.push(the_two_sum % 10);
        }
        // process them while SN is empty
        while(SN.isEmpty() == true && SM.isEmpty() == false){
            m=SM.pop();
            n = 0;
            the_two_sum = n + m + carry;
            if(the_two_sum > 9){
                carry = 1;
            }
            else{
                carry = 0;
            }
            SS.push(the_two_sum % 10);
        }
        // process them while SM is empty
        while((SN.isEmpty() == false && SM.isEmpty() == true)){
            m= 0;
            n = SN.pop();
            the_two_sum = n + m + carry;
            if(the_two_sum > 9){
                carry = 1;
            }
            else{
                carry = 0;
            }
            SS.push(the_two_sum % 10);
        }
        // process the carry
        if((SN.isEmpty() == true && SM.isEmpty() == true)){
            SS.push(carry);
        }
        // pop the values from SS into an array
        // create a big integer from the array and return as the sum
        int[] SSSS = new int[SIZE];
        int counter = 0;
        int u = 0;
        while(SS.isEmpty() == false){
            SSSS[u] = SS.pop();
            counter += 1;
            u += 1;
        }
        int[] fin = new int[counter];
        for(int r=0;r<counter;++r){
            fin[r] = SSSS[r];
        }
        BigInt SSS = new BigInt();
        SSS.putValue(fin);
        return SSS;
    }
    
    // this method will return a BigInt 
    // this method will give the the result of a BigInt mutiply by a integer
    private static BigInt multByInt(BigInt N, int m) {
        IntStack SN = new IntStack(60);
        IntStack SS = new IntStack(60);
        // push the every element in BigInt onto intstack
        for(int i=0; i<N.length();++i){
            SN.push(N.digitAt(i));
        }
        int carry = 0;
        int the_result = 0;
        int n = 0;
        // processing the intstack as the algorithm
        while(SN.isEmpty() == false){
            n = SN.pop();
            the_result = n * m + carry;
            if(the_result > 9){
                carry = the_result / 10;
            }
            else{
                carry = 0;
            }
            SS.push(the_result % 10);
        }
        // process the final carry
        if(SN.isEmpty()){
            SS.push(carry);
        }
        // pop the values from SS into an array
        // create a big integer from the array and return as the sum
        int[] SSSS = new int[SIZE];
        int counter = 0;
        int u = 0;
        while(SS.isEmpty() == false){
            SSSS[u] = SS.pop();
            counter += 1;
            u += 1;
        }
        int[] fin = new int[counter];
        for(int r=0;r<counter;++r){
            fin[r] = SSSS[r];
        }
        BigInt SSS = new BigInt();
        SSS.putValue(fin);
        return SSS;        
    }
    

    
    public static BigInt mult(BigInt N, BigInt M) {
        int size_1 = 60;
        IntStack SM = new IntStack(size_1);
        IntStack SS = new IntStack(size_1);
        BigIntStack add = new BigIntStack(size_1);
        BigInt result_1 = new BigInt();
        BigInt result = new BigInt();
        BigInt the_pop = new BigInt();
        BigInt NN = N;
        String P = "";
        for(int i=0; i<M.length();++i){
            SM.push(M.digitAt(i));
        }
        int mm = 0;
        while(SM.isEmpty() == false){
            mm = SM.pop();
            result = multByInt(NN,mm);
            add.push(result);
            P = NN.toString();
            P = P + "0";
            NN = new BigInt(P);
        }
        while(add.isEmpty() == false){
            the_pop = add.pop();
            //System.out.println(result_1);
            result_1 = add(result_1, the_pop);
        }
        return result_1;
    }
    
    
    public static void main(String [] args) {
        
        System.out.println("\nUnit Test for BigMath Class");
        
        BigInt A = new BigInt("9999");
        
        BigInt B = new BigInt(1);
        
        int[] c = {1,8,2,7};
        BigInt C = new BigInt(c);
        
        BigInt D = new BigInt(234);
        BigInt E = new BigInt(235);
        BigInt F = new BigInt(9999);
        BigInt Z = new BigInt(0);
        
        System.out.println("\nTest 1: Should be:\n4 9999");
        System.out.println( A.length() + " " + A );
        
        System.out.println("\nTest 2: Should be:\n1 1");
        System.out.println( B.length() + " " + B );
        
        System.out.println("\nTest 3: Should be:\n4 1827");
        System.out.println( C.length() + " " + C );
        
        System.out.println("\nTest 4: Should be:\n3 234");
        System.out.println( D.length() + " " + D );
        
        System.out.println("\nTest 5: Should be:\n-1");
        System.out.println( compare(D,E) );
        
        System.out.println("\nTest 6: Should be:\n1");
        System.out.println( compare(E,D) );
        
        System.out.println("\nTest 7: Should be:\n1");
        System.out.println( compare(C,D) );
        
        System.out.println("\nTest 8: Should be:\n-1");
        System.out.println( compare(D,C) );
        
        System.out.println("\nTest 9: Should be:\n1");
        System.out.println( compare(A,Z) );
        
        System.out.println("\nTest 10: Should be:\n-1");
        System.out.println( compare(Z,A) );
        
        BigInt G = new BigInt(9999);        
        System.out.println("\nTest 11: Should be:\n0 true");
        System.out.println( compare(A,G) + " " + equals(A,G) );
        
        System.out.println("\nTest 12: Should be:\n-1 false");
        System.out.println( compare(E,F) + " " + equals(F,E) );
        
        System.out.println("\nTest 13: Should be:\n2");
        System.out.println( add(B,B) );
        
        System.out.println("\nTest 14: Should be:\n1827");
        System.out.println( add(C,Z) );
        
        System.out.println("\nTest 15: Should be:\n1827");
        System.out.println( add(Z,C) );
        
        System.out.println("\nTest 16: Should be:\n0");
        System.out.println( add(Z,Z) );
        
        System.out.println("\nTest 17: Should be:\n10000");
        System.out.println( add(A,B) );
        
        System.out.println("\nTest 18: Should be:\n10000");
        System.out.println( add(B,A) );
        
        System.out.println("\nTest 19: Should be:\n2061");
        System.out.println( add(C,D) );
        
        System.out.println("\nTest 20: Should be:\n2061");
        System.out.println( add(D,C) );
        
        System.out.println("\nTest 21: Should be:\n469");
        System.out.println( add(E,D) );
        
        System.out.println("\nTest 22: Should be:\n469");
        System.out.println( add(D,E) );  
        
        System.out.println("\nTest 23: Should be:\n1827");
        System.out.println( multByInt(C,1) ); 
        
        System.out.println("\nTest 24: Should be:\n3654");
        System.out.println( multByInt(C,2) );
        
        System.out.println("\nTest 25: Should be:\n0");
        System.out.println( multByInt(Z,8) );
        
        System.out.println("\nTest 26: Should be:\n99990");
        System.out.println( multByInt(A,10) );
        
        System.out.println("\nTest 27: Should be:\n4");
        BigInt Two = new BigInt(2); 
        System.out.println( mult(Two,Two) );
        
        System.out.println("\nTest 28: Should be:\n468  468");
        System.out.println( mult(D,Two) + "  " + mult(Two,D));
        
        System.out.println("\nTest 29: Should be:\n54990  54990");
        System.out.println( mult(D,E) + "  " + mult(E,D));
        
        System.out.println("\nTest 30: Should be:\n2339766  2339766");
        System.out.println( mult(D,A) + "  " + mult(A,D));
        
        System.out.println("\nTest 31: Should be:\n1013459064417062778220931703313214582990003217000");
        BigInt T = mult(A, mult( B, mult( C, mult( D, mult ( E, F ) ) ) ) ); 
        System.out.println( mult( T, mult( T, T ) ) );
        
        
    }
    
    
}

