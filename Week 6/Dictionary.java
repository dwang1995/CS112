/* File: Dictionary.java
 * Author: Dayuan Wang
 * Date: 2/26/2016
 * Purpose: This is a template for HW06, Problem B.2 for CS 112. 
 */
import java.util.Arrays;

public class Dictionary { 
    
    // basic definition of the Pair class; this is an "inner class" inside class Dictionary
    private int LENGTH = 10;
    
    private Pair[] A = new Pair[LENGTH];
    
    private int next = 0; 
    
    private int size = 0;
    
    private class Pair {
        String key;
        String[] value;
        
        public Pair() { }              // default constructor, key and value will be nulls
        
        public Pair(String k, String[] v) {
            key = k;
            value = v;
        }
        // this is the method to print out the value
        public String toString() {
            if(value.length == 0){
                String S = "";
                S += key + ": []";
                return S;
            }
            else{
                String S = "";
                S += key + ": [";
                for(int i = 0; i < value.length-1; ++i){
                    S += value[i] + ",";
                }
                S += value[value.length-1] ;
                S += "]";
                return S;}
        }
    }
    // YOUR CODE HERE!!
    
    // this is the method to insert student
    // if the array is full, we will double the size
    // if he is already in the array, we will just change his class list
    // if he is not in the array, we will insert him
    // during insert, we will check where he should be putting at.
    // i will adjust the position to make sure the list is sorted
    public void insertStudent(String k, String[] val){
        if(size == LENGTH){
            resize();
        }
        if(size == 0){
            Pair B = new Pair(k,val);
            A[0] = B;
            ++next;
            ++size;
        }
        else{ 
            if(member(k) == false){
                Pair B = new Pair(k,val);                
                int whereToPut = next;
                for(int i = 0; i < next; ++i){
                    if((B.key).compareTo(A[i].key) <= 0){
                        whereToPut = i;
                        break;
                    }
                }
                Pair[] C = new Pair[LENGTH];
                C[whereToPut] = B;
                for(int j = 0; j < whereToPut; j++){
                    C[j] = A[j];
                }
                for(int z = whereToPut ; z < next; ++z ){
                    C[z+1] = A[z];
                }
                next = next + 1;
                size = size + 1;
                A = C;
            }
            else{
                int index = location(k);
                A[index].value = val;
            }
        }
    }
    // this is the class to look up someone's class
    // if he is not in the dictionary, return the KeyNotFoundException
    // else find the location and return his class list
    public String[] lookupClasses(String k) throws KeyNotFoundException{
        if(member(k) == false){
            throw new KeyNotFoundException();
        }
        else{
            int index = location(k);
            return (A[index].value);
        }
    }
    // this is the method to check if someone is the member of the dictionary or not
    // use the binary search
    // if i find the place return true
    // if not find, return false
    public boolean member(String k){
        if(size == 0){
            return false;
        }
        else{
            int low = 0;
            int high = size -1; 
            while(high >= low){
                int middle = (high + low)/2;
                //System.out.println(middle);
                if(k.compareTo(A[middle].key) == 0){
                    return true;
                }
                if(k.compareTo(A[middle].key) > 0){
                    low = middle + 1;
                }
                if(k.compareTo(A[middle].key) < 0){
                    high = middle - 1;
                }
            }
            return false;
        }
    }
    // this is the method to delete a student in the dictionary
    // we will just remove him and replace his spot by the other
    // we will keep the array sorted
    public void deleteStudent(String k){
        if(member(k) == true){
            int index = location(k);
            for(int i = index; i< next; ++i){
                A[i]= A[i+1]; 
            }
            --next;
            --size;
        }
    }
    
    // this is the method to drop the class
    // this method is working if and only if the student is in the dictionary
    // and he has the class is going to be droped
    // We are going to make another class array for him, and put class he is not dropping
    // then use the new class array to replace the old class array.
    public void dropClass(String k, String c){
        if(member(k) == true){
            int index = location(k);
            if(memberArray(c, A[index].value) == true){
                String[] B = new String[A[index].value.length - 1];
                String[] C = A[index].value;
                int ind = 0;
                //System.out.println(Arrays.toString(C));
                for(int j = 0; j<C.length; ++j){
                    if(C[j] != c){
                        B[ind] = C[j];
                        ind += 1;
                    }
                }
                A[index].value = B;
            }
        }
    }
    
    // this is the method to add a class to a student
    // if the student is not in the dictionary, we are going to insert this student with this single course
    // if the student is in the dictionary, and he does not have this class in his class array we are going to add it
    // if the condition does not match the two conditions above, we are not doing anything
    // during adding class, we are going to make a new array with one slot bigger
    // copy every class in the old array, and put the new class that he is adding into the last slot
    // use the new array to replace the old one.
    public void addClass(String k, String c){
        if(member(k) == false){
            String[] B = new String[1];
            B[0] = c;
            insertStudent(k,B);
        }
        else if(member(k) == true){
            int index = location(k);
            if(memberArray(c,A[index].value) == false){
                String[] C = new String[A[index].value.length + 1];
                String[] D = A[index].value;
                for(int i = 0; i < D.length; ++i){
                    C[i] = D[i];
                }
                C[C.length-1] = c;
                A[index].value = C;
            }
        }
    }
    
   // this is the method to check that if a student has enroll to a class or not
    // if the student is not in the dictionary, return false
    // if the student is in the dictionary, go through his class list
    // if the class is a member of his memberArray, return true
    // else return false
    public boolean enrolled(String k, String c){
        if(member(k) == false){
            return false;
        }
        else{
            int index = location(k);
            if(memberArray(c,A[index].value) == true){
                return true;
            }
            else{
                return false;
            }
        }
    } 
    
    
    // Get the number of pair in the array
    public int size(){
        return size;
    }
    
    // isEmpty??
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    // get the location based on the key
    /*
    private int location(String k){
        int locat = -1;
        for(int i = 0; i < size; ++i){
            if(A[i].key == k){
                locat = i;
            }
        }
        return locat;
    }
    */
    // i just write this method to match the requirement of
    // location(String k, int lo, int hi)
    // the next method will do the same with this
    private int location(String k, int lo, int hi){
        if(size == 0){
            return -1;
        }
        else{
            int low = lo;
            int high = hi; 
            while(high >= low){
                int middle = (high + low)/2;
                //System.out.println(middle);
                if(k.compareTo(A[middle].key) == 0){
                    return middle;
                }
                if(k.compareTo(A[middle].key) > 0){
                    low = middle + 1;
                }
                if(k.compareTo(A[middle].key) < 0){
                    high = middle - 1;
                }
            }
            return -1;
        }
    }
    // this is the method to find the place
    // i will use the binary search
    // if i find the location, i will return the index
    // if i do not find, i will return -1 as the result
    private int location(String k){
        if(size == 0){
            return -1;
        }
        else{
            int low = 0;
            int high = size -1; 
            while(high >= low){
                int middle = (high + low)/2;
                //System.out.println(middle);
                if(k.compareTo(A[middle].key) == 0){
                    return middle;
                }
                if(k.compareTo(A[middle].key) > 0){
                    low = middle + 1;
                }
                if(k.compareTo(A[middle].key) < 0){
                    high = middle - 1;
                }
            }
            return -1;
        }
    }
    
    // this is the method for resize
    private void resize(){
        LENGTH = 2 * LENGTH;
        Pair[] B = new Pair[LENGTH];
        for(int i = 0; i<A.length; ++i){
            B[i] = A[i];
        }
        A = B;
    }
    
    // this is the helper function to check if a student has a class in his class array
    // we will use the for loop to go through every element in the class array
    // when we find the same one, return true
    // if not find after go through the array, return false
    private boolean memberArray(String k, String[] C) {
        for(int i = 0; i < C.length; ++i){
            if(C[i] == k){
                return true;
            }
        }
        return false;
    }
    
    //Iterators
    
    private int nextPair = 0;
    private int nextStudent = 0;  
    private String className; 
    // the method to reset the nextPair
    public void initPairIterator(){
        nextPair = 0;
    }
    // this is the method to check if there is the nextpair or not
    public boolean hasNextPair(){
        if(nextPair >= size){
            return false;
        }
        else{
            return true;
        }
    } 
    // this is the method to return the nextpair
    public String nextPair(){
        String S = A[nextPair].toString();
        nextPair += 1;
        return S;
    } 
    // this is the method to initializae the nextStudent
    public void initStudentIterator(String c){
        nextStudent = 0;
        className = c;
    }
    // this is the method to check if there is nextStudent or not
    public boolean hasNextStudent(){    
        while(memberArray(className, A[nextStudent].value) != true && nextStudent < (size - 1)) {
            nextStudent++;
        }
        if (nextStudent == size - 1) 
            return false;
        return true;
    }
    // this is the method to return the next student
    public String nextStudent(){
        String S = "";
        if(memberArray(className,A[nextStudent].value) == true){
            S = A[nextStudent].toString();}
        nextStudent += 1;
        return S;
    }
    // this is used in the unit test
    
    private void printDictionary() {
        for(int i = 0; i < next; ++i)
            System.out.println(i + ": " + A[i]);
    }
    
    public static void main(String[] args) {
        
        Dictionary D = new Dictionary(); 
        
        // Insert three (key,value) pairs and test basic methods
        
        String[] A = { "CS111", "CS131", "WR99", "EC101" };
        String[] B = { "CS111", "MA123", "WR100", "SO100" };
        String[] C = { "CS111", "MA294", "WR150", "CL212" };
        String[] E = { "CS350", "CS235", "EC101", "MU101" };
        String[] F = { "CS111", "MA124", "BI108", "SO105" };
        String[] G = { "CS591", "MA442", "EN212", "EC101" };
        
        // uncomment one test at a time as you develop the corresponding methods above
        
        
        D.insertStudent("Christie,Chris",A); 
        D.insertStudent("Carson,Ben", B);
        D.insertStudent("Trump,Donald", C);
        D.insertStudent("Kasich,John",E); 
        D.insertStudent("Cruz,Ted", F);
        D.insertStudent("Bush,Jeb", G);
        //D.insertStudent("Bush,Jeb", A);//
        
        System.out.println("\n[1] Should print out:"); 
        System.out.println("0: Bush,Jeb: [CS591,MA442,EN212,EC101]");
        System.out.println("1: Carson,Ben: [CS111,MA123,WR100,SO100]");
        System.out.println("2: Christie,Chris: [CS111,CS131,WR99,EC101]");
        System.out.println("3: Cruz,Ted: [CS111,MA124,BI108,SO105]");
        System.out.println("4: Kasich,John: [CS350,CS235,EC101,MU101]");
        System.out.println("5: Trump,Donald: [CS111,MA294,WR150,CL212]\n");
        
        D.printDictionary();  
        
        System.out.println("\n[2] Should print out:\n6"); 
        System.out.println(D.size()); 
        
        System.out.println("\n[3] Should print out:\nfalse"); 
        System.out.println(D.isEmpty()); 
        
        System.out.println("\n[4] Should print out:\ntrue"); 
        System.out.println(D.member("Cruz,Ted")); 
        
        System.out.println("\n[5] Should print out:\nfalse"); 
        System.out.println(D.member("Jindal,Bobby")); 
        
        D.deleteStudent("Bush,Jeb");
        D.deleteStudent("Christie,Chris");
        System.out.println("\n[6] Should print out:\nfalse  false"); 
        System.out.println(D.member("Bush,Jeb") + "  " + D.member("Christie,Chris")); 
        System.out.println("\n size? \n4");
        System.out.println(D.size());
        
        System.out.println("\n[7] Should print out:\n[CS111, MA123, WR100, SO100]"); 
        String name = "Carson,Ben";
        try {
            System.out.println(Arrays.toString(D.lookupClasses(name))); 
        }
        catch(KeyNotFoundException e) {
            System.err.println("Key not found: " + name);
        }
        
        name = "Jindal,Bobby";
        System.out.println("\n[8] Should print out:");
        System.err.println("Key not found: " + name); 
        try {
            System.out.println(Arrays.toString(D.lookupClasses(name))); 
        }
        catch(KeyNotFoundException e) {
            System.err.println("Key not found: " + name);
        }
        
        System.out.println("\n[9] Should print out:\n[CS111, WR100, SO100]");  
        D.dropClass("Carson,Ben", "MA123");
        D.dropClass("Carson,Ben", "EC102"); 
        try {
            System.out.println(Arrays.toString(D.lookupClasses("Carson,Ben"))); 
        }
        catch(KeyNotFoundException e) {
            System.err.println("Key not found: Carson,Ben");
        } 
        
        System.out.println("\n[10] Should print out:\n[CS111, MA294, WR150, CL212, CS591]");  
        D.addClass("Trump,Donald", "CS591");
        D.addClass("Trump,Donald", "WR150"); 
        try {
            System.out.println(Arrays.toString(D.lookupClasses("Trump,Donald"))); 
        }
        catch(KeyNotFoundException e) {
            System.err.println("Key not found: Carson,Ben");
        } 
        
        System.out.println("\n[11] Should print out:\nfalse  true"); 
        D.dropClass("Walker,Scott","PH150");
        System.out.print(D.member("Walker,Scott") + "  " );
        D.addClass("Walker,Scott","PH110"); 
        System.out.println(D.member("Walker,Scott")); 
//         System.out.println("\n[11] Should do nothing...."); 
//         
//         D.dropClass("Walker,Scott","PH150");
//         //
//         D.addClass("Walker,Scott","PH110");
//         //D.dropClass("Walker,Scott","PH150");
//         try {
//         System.out.println(Arrays.toString(D.lookupClasses("Walker,Scott"))); 
//         }
//         catch(KeyNotFoundException e) {
//         System.err.println("Key not found: Carson,Ben");
//         } 
//         D.printDictionary();
        
        
        System.out.println("\n[12] Should print out:\ntrue"); 
        System.out.println(D.enrolled("Trump,Donald", "CS591"));  
        
        System.out.println("\n[13] Should print out:\nfalse"); 
        System.out.println(D.enrolled("Trump,Donald", "CS101"));        
        
        // testing iterators       
        
        System.out.println("\n[14] Should print out:");
        System.out.println("0: Carson,Ben: [CS111,WR100,SO100]");
        System.out.println("1: Cruz,Ted: [CS111,MA124,BI108,SO105]");
        System.out.println("2: Kasich,John: [CS350,CS235,EC101,MU101]");
        System.out.println("3: Trump,Donald: [CS210,MA294,WR150,CL212,CS591]");
        System.out.println("4: Walker,Scott: [PH110]\n");
        D.printDictionary(); 
        
        System.out.println("\n[15] Should print out same but without index numbers:");
        D.initPairIterator(); 
        
        while(D.hasNextPair()) {
            System.out.println(D.nextPair());
        }
        System.out.println("\n[16] Should print out:\nCarson,Ben:  [CS111,WR100,SO100]");
        D.initPairIterator(); 
        System.out.println(D.nextPair());
        
        System.out.println("\n[17] Should print out:");  
        D.initStudentIterator("CS111");
        System.out.println("Carson,Ben: [CS111,WR100,SO100]");
        System.out.println("Cruz,Ted: [CS111,MA124,BI108,SO105]");
        System.out.println("Trump,Donald: [CS111,MA294,WR150,CL212,CS591]\n");
        
        while(D.hasNextStudent()) {
            System.out.println(D.nextStudent());
        }
        
        System.out.println("\n[18] Should print out:\nTrump,Donald:[CS111,MA294,WR150,CL212,CS591]");
        D.initStudentIterator("CL212"); 
        
        while(D.hasNextStudent()) {
            System.out.println(D.nextStudent());
        } 
        
        System.out.println("\n[19] Testing resizing; should print out a dictionary with 14 pairs.\n"); 
        D.insertStudent("Clinton, Hillary",A); 
        D.insertStudent("Sanders,Bernie", B);
        D.insertStudent("Lincoln,Abraham", C);
        D.insertStudent("Kennedy,John",E); 
        D.insertStudent("Bush,George", F);
        D.insertStudent("Reagan,Ronald", G);
        D.insertStudent("Nixon,Dick",A); 
        D.insertStudent("Carter,Jimmy", B);
        D.insertStudent("Johnson,Lyndon", C);
        
        D.printDictionary(); 
        System.out.println("number of Pairs: " + D.size());
        //*//*    
        
        
    }
    
}



class KeyNotFoundException extends Exception {}

