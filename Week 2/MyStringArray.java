/* File: MyStringArray.java
 * Author: Dayuan Wang
 * Date: January 30th, 2016
 */

public class MyStringArray { 
    
    // Declare various final (i.e., constant) values to be used to indicate errors of various types
    
    public static final char[] errorString  = { 'N', 'a', 'S' };   // These next three are our choices for error outputs
    public static final char errorCharacter = '#';
    public static final int errorInteger    = Integer.MIN_VALUE;
    public static final double errorDouble  = Double.NaN;          // Nan results when dividing by 0, etc.
    
    // we need to check if the input integer is in the range of array or not
    // if not, return the error
    // else, take the one from the array and return a char
    public static char charAt(char[] s, int i) {
        if (i > s.length){
            return errorCharacter; }
        else{
            char a = s[i];
            return a;
        }
    }
    
    // set a integer to count how many numbers are there in the array
    // use for loop to add one to that integer when there is a number. 
    public static int length(char[] s) {
        int AA = 0;
        for (int i = 0; i < s.length; ++i){
            ++AA;
        }
        return AA;
    }
    
    // First create a new array 
    // use a for loop to take the character from the input and put it in to the new array
    public static char[] subString(char[] s, int l, int r) {
        char[] AA = new char[r-l] ;
        if (l < 0 || r > s.length){
            return errorString;
        }
        else{
            for (int i = l; i < r; ++i){
                AA[i-l] = s[i];
            }
            return AA;
        }
        // return error String, just to get it to compile
    }
    
    // build a new array
    // use the for loop to take out each character first
    // convert them to ascii code and add 32 so we can get the lower case
    // check if the character is a "english character", if not don't change it
    public static char[] toLowerCase(char[] c) {
        char[] AA = new char[c.length];
        for (int i=0; i<c.length; ++i){
            char b= c[i];
            int d = (int)b;
            if (65<= d && d <= 90){
                AA[i] = (char)(d + 32);
            }
            else{
                AA[i] = c[i];
            }
        }
        return AA;
    }
    
    // create a new array first with numbers of number you want to concat
    // put the first array into the new array first
    // put the second array into the new array.
    public static char[] concatenate(char[] a, char[] b) {
        char[] AA = new char[a.length + b.length];
        for (int i = 0; i < a.length; ++i){
            AA[i]= a[i];
        }
        for (int i = 0; i < b.length; ++i){
            AA[i+a.length] = b[i];
        }
        return AA;
    }
    
    // We are going to check that if the input is valid or not.
    // We are going to use the ascii code to change the char to a int
    // A valid input should not have characters other than '-','.' and numbers.
    // We will take that number, use the ascii code to change it to the integer
    // times the power of 10 to get to it's actural digit it should be (100 = 1 * 10 * 10)
    // add up all the integer to finish the convert. 
    public static int intValueOf(char[] a) {
        int B = 0;
        for (int i = 0; i < a.length; ++i){
            if (((int)(a[i])<48||(int)(a[i])>57) && a[i] != '-' ){
                return errorInteger; 
            }
            else if(a[i]== '-'){
                B += 0;
            }
            else if(a[i]=='.'){
                break;
            }
            else{
                int f= 1;
                // This is my version of Math.pow()
                // I was not sure about I can use it or not, so I just write my own one
                for (int z = 0;z <(a.length-i); ++z ){
                    f *= 10;
                }           
                B += ((int)(a[i])-48)*f;
            }
        }
        // I think I make a small mistake in the early part of this, all of my numbers are 10 times bigger
        // than the actual value.
        // so I will carry that out in this part. 
        if (a[0]== '-'){
            B /= -10;
        }
        else{
            B /= 10;
        }
        return B;
        
    }
    
    // The method for this one is similar to the last one i just write.
    // We are going to use the ascii code to change a char to a number.
    // We need to carry out the digit '.' this time
    // Go over the whole array first and then get the index of the '.'
    // Do the same thing as the last method as the integer part
    // The digital part should be the same(but time 10^negative). 
    // combine them together and store the number into a double number.
    public static double doubleValueOf(char[] a) {
        double num = 0.0;
        int index =0;
        int b = 0;
        int dot = 0;
        for(int u = 0; u<a.length; u++){
            if ((a[u]>47 && a[u]<58)|| a[u]==46||a[u]==45){}
            else{
                return Double.NaN;
            }
        }
        for(int t=0; t<a.length; t++){
            if (a[t]=='.'){
                dot = dot + 1;
            }
        }
        for(int i =0; i< a.length; i++){
            if (a[i]== '.'){
                break;}
            else{
                index++;}}
    
        
        if (a[0]== '-'){
            b = 1;
        }
        for (int j=b; j<index; j++){
            num = num + (a[j]-48)*Math.pow(10,index-j-1);
        }
        for (int k = index + 1; k < a.length; k++){
            num = num + (a[k]-48)*Math.pow(10,index-k);
        }
        if(a[0]=='-'){
            num = 0-num;
        }
        if (dot>= 2){
            return Double.NaN;
        }
        else{
            return num;}
    }
    // We know that 185 % 10 = 5
    // We know that 185 / 10 = 18
    // We are going to use these two ways to take out all the numbers out
    // We are going to create two arrays in this method
    // One is for take out each number in the integer (185 has 1, 8, and 5)
    // Another one will convert from the integer to character
    // we will carry out the  negetive sign '-' on the character array
    // lastly we want to return the character array.
    public static char[] int2MyString(int n) {
        int a= n;
        int b = n;
        int index = 0;
        if (a<0){
            a= a*(-1);
        }
        if (b<0){
            b= b*(-1);
        }
        while (a>0){
            a= a/10;
            index += 1;
        }
        int index_1 = index;
        int[] AA = new int[index];
        while(b>0){
            AA[index_1-1]= b % 10;
            b /= 10;
            index_1 -= 1;
        }
        char[] BB = new char[index+1];
        for (int i = 0; i< BB.length-1; ++i){
            BB[i+1] =(char)(AA[i]+48);
        }
        if (n<0){
            BB[0] = '-';
        }
        return BB;
    }
    
    // This method provided for debugging
    public static void printCharArray(char[] A) {
        for(int i = 0; i < A.length; ++i) {
            System.out.print(A[i]);
        }
        System.out.println(); 
    }
    
    
    public static void main(String[] args) {
        
        System.out.println("\nGrading program for MyStringArray library\n");
        int testNum = 0; 
        
        System.out.println("Test " + (++testNum) + ": Should be:\n8"); 
        char[] test = "CS112 A1".toCharArray(); 
        System.out.println(length(test)); 
        System.out.println(); 
        
        System.out.println("Test " + (++testNum) + ": Should be:\nC"); 
        System.out.println(charAt(test,0)); 
        System.out.println(); 
        
        System.out.println("Test " + (++testNum) + ": Should be:\n1"); 
        System.out.println(charAt(test,7)); 
        System.out.println(); 
        
        System.out.println("Test " + (++testNum) + ": Should be:\n#"); 
        System.out.println(charAt(test,9)); 
        System.out.println();
        
        System.out.println("Test " + (++testNum) + ": Should be:\nCS112"); 
        System.out.println(subString(test,0,5)); 
        System.out.println(); 
        
        System.out.println("Test " + (++testNum) + ": Should be:\n12 A1"); 
        System.out.println(subString(test,3,8)); 
        System.out.println(); 
        
        System.out.println("Test " + (++testNum) + ": Should be:\nNaS"); 
        System.out.println(subString(test,-1,4)); 
        System.out.println(); 
        
        System.out.println("Test " + (++testNum) + ": Should be:\nNaS"); 
        System.out.println(subString(test,1,9)); 
        System.out.println();  
        
        System.out.println("Test " + (++testNum) + ": Should be:\ncs112 a1"); 
        System.out.println(toLowerCase(test)); 
        System.out.println();
        
        System.out.println("Test " + (++testNum) + ": Should be:\nCS112 A1"); 
        System.out.println(test); 
        System.out.println();
        
        System.out.println("Test " + (++testNum) + ": Should be:\nCS112 A1CS112 A1"); 
        System.out.println(concatenate(test,test)); 
        System.out.println();
        
        System.out.println("Test " + (++testNum) + ": Should be:\n234"); 
        test = "234".toCharArray(); 
        System.out.println(intValueOf(test)); 
        System.out.println(); 
        
        System.out.println("Test " + (++testNum) + ": Should be:\n-234"); 
        test = "-234".toCharArray(); 
        System.out.println(intValueOf(test)); 
        System.out.println(); 
        
        System.out.println("Test " + (++testNum) + ": Should be:\n-2147483648"); 
        test = "234.4".toCharArray(); 
        System.out.println(intValueOf(test)); 
        System.out.println(); 
        
        System.out.println("Test " + (++testNum) + ": Should be:\n-2147483648"); 
        test = "23a4".toCharArray(); 
        System.out.println(intValueOf(test)); 
        System.out.println();
        
        System.out.println("Test " + (++testNum) + ": Should be:\n3.141592"); 
        test = "3.141592".toCharArray(); 
        System.out.println(doubleValueOf(test)); 
        System.out.println();   
        
        System.out.println("Test " + (++testNum) + ": Should be:\n-3.141592"); 
        test = "-3.141592".toCharArray(); 
        System.out.println(doubleValueOf(test)); 
        System.out.println(); 
        
        System.out.println("Test " + (++testNum) + ": Should be:\n10.0"); 
        test = "10.".toCharArray(); 
        System.out.println(doubleValueOf(test)); 
        System.out.println(); 
        
        System.out.println("Test " + (++testNum) + ": Should be:\n0.5"); 
        test = ".5".toCharArray(); 
        System.out.println(doubleValueOf(test)); 
        System.out.println();
        
        System.out.println("Test " + (++testNum) + ": Should be:\n0.0"); 
        test = ".".toCharArray(); 
        System.out.println(doubleValueOf(test)); 
        System.out.println();
        
        System.out.println("Test " + (++testNum) + ": Should be:\n234.0"); 
        test = "234".toCharArray(); 
        System.out.println(doubleValueOf(test)); 
        System.out.println();
        
        System.out.println("Test " + (++testNum) + ": Should be:\nNaN"); 
        test = "3.141.592".toCharArray(); 
        System.out.println(doubleValueOf(test)); 
        System.out.println(); 
        
        System.out.println("Test " + (++testNum) + ": Should be:\nNaN"); 
        test = "3.141a592".toCharArray(); 
        System.out.println(doubleValueOf(test)); 
        System.out.println(); 
        
        int n = 12345; 
        System.out.println("Test " + (++testNum) + ": Should be:\n12345"); 
        printCharArray( int2MyString(n) ); 
        System.out.println(); 
        
        n = -45; 
        System.out.println("Test " + (++testNum) + ": Should be:\n-45"); 
        printCharArray( int2MyString(n) ); 
        System.out.println(); 
        
        
    }
    
}