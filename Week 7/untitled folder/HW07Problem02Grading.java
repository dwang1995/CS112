/* File: HW07Problem02grading.java
 * Author: Wayne Snyder (waysnyder@gmail.com)
 * Date: 3/18/16
 * Purpose: This is a grading template for Problem 2, HW 07, CS 112 Spring 2016.
 *          If you run this program and it does not generate any errors, then
 *          you have implemented all the methods as public and static, and
 *          the grading file we eventually write will be able to find your methods. 
 *          This is NOT the final grading file, it is just a check that you have
 *          properly made all your methods available for grading. 
 */

public class HW07Problem02Grading {
    
    public static void printList(Node p) {
        if(p == null) 
            System.out.println(".");
        else {
            System.out.print( p.item + " -> " );
            printList(p.next); 
        } 
    }
    
    public static void printList(String head, Node p) {
        System.out.print(head + " -> ");
        printList(p);
    }
    
    public static Node copy( Node p ) {
       if( p == null )
          return null; 
       else 
          return new Node(p.item, copy( p.next )); 
    } 
    
    public static void main(String [] args) {
        
               
        // No need to add any test here; these are just to make sure the grading file
        // we write will be able to access each of your methods. 
        // If this runs without errors, then you are good to go!
        
        Node A = new Node(3, new Node(6, new Node( 9, new Node(12, null ) ) ) );
        printList("A", A);

        int[] B = {2,3,4};
        printList(HW07Problem02.arrayToLinkedList(B));//
        printList(HW07Problem02.deleteNth(copy(A),2));//
        System.out.println(HW07Problem02.equalLists(A,A));//
        printList(HW07Problem02.everyOther(copy(A)));//
     
        System.out.println(HW07Problem02.equalListsRec(A,A));
        printList(HW07Problem02.everyOtherRec(copy(A)));
       
        printList(HW07Problem02.splice(2,copy(A),copy(A)));
   
        printList(HW07Problem02.intersection(A,A));
        
        System.err.println("Success! Your program is ready for grading!");
     
        
    }
    
    
}