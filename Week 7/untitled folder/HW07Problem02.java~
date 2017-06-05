/* File: HW07Problem02.java
 * Author: Dayuan Wang (wangdayu@bu.edu)
 * Date: 3/18/16
 * Purpose: This is a template for Problem 2 in HW 07 in CS 112, Spring 2016.  
 */

public class HW07Problem02 {
    
    // Definition of Node class is at end of file
    
    // Utility methods to print out the list
    
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
    
    // Here is a sample of a method which will be tested below. 
    
    public static Node reverse(Node p) {
        return reverseHelper(p, null);
    }
    
    public static Node reverseHelper(Node p, Node q) {
        if(p == null)
            return q;
        else {
            Node temp = p.next;
            p.next = q;
            return reverseHelper(temp, p); 
        }
        
    }
    
    // Now add your solutions for each of the methods in Problem 2. BE SURE TO MAKE
    // THEM PUBLIC AND STATIC AND NAME THEM EXACTLY AS IN THE ASSIGNMENT!
   
    
    // this is the method that makes a array into a link list
    // I will use iterative way
    // push the integer in the array from the back to front and link them
    public static Node arrayToLinkedList(int[] A){
        Node Q = null;
        if(A.length == 0)
            return Q;
        else{
            for(int i = A.length-1 ; i > -1; --i){
                Node P = new Node(A[i], null);
                P.next = Q;
                Q = P;
            }
            return Q;
        }
    }
    
    
    // This is the mothod to delete the Nth Node in the link list
    // I will use iterative way
    // I will use the iterative way to get the size of the link list first
    // If the Nth node is larget than the size of it, don't do anything
    // Else I will set up a pointer and go through the link list
    // If it is not the Nth node, keep looping
    // When I get the Nth node, just delete that node and return
    public static Node deleteNth(Node p,int n){
        int count = 0;
        Node p_1 = p;
        while(p_1 != null){
            count += 1;
            p_1 = p_1.next;
        }
        if(n > count){
            return p;
        }
        else{
            int counter = 2;
            Node a = p.next;
            Node b = p;
            if(n == 1){
                p = a;
                return p;
            }
            else{
                while(counter != n){
                    a = a.next;
                    b = b.next;
                    counter += 1;
                }
                b.next = a.next;
                return p;
            }
        }
    }
    
    
    // This is the method to make a deep copy of the Link List
    // This is same with the slides
    public static Node copy(Node p){
        if(p == null){
            return p;
        }
        else{
            Node q = new Node(p.item,null);
            q.next = copy(p.next);
            return q;
        }
    }
    
    
    // This is the iterative version of equalLists
    // Set up a pointer to each of the link list
    // and check the item it is pointing to is equal or not
    // Make the pointer go through the link list until the end
    public static boolean equalLists(Node p, Node q){
        Node p_1 = p;
        Node q_1 = q;
        if(p == null && q != null){
            return false;
        }
        else if(p!= null && q == null){
            return false;
        }
        else{
            while(p_1 != null && q_1 != null){
                if(p_1.item != q_1.item)
                    return false;
                p_1 = p_1.next;
                q_1 = q_1.next;
            }
            if(p_1 != null && q_1 == null){
                return false;
            }
            else if(p_1 == null && q_1 != null){
                return false;
            }
            else{
                return true;}
        }
    }
    
    
    // This is the Iterative version for the everyOther Node
    // I will set up two pointer and make them go over the list
    // The two pointer will help me to delete everyOther one node in the link list
    public static Node everyOther(Node p){
        Node p_1 = p;
        if(p_1 == null)
            return p;
        else{
            Node q = p_1.next;
            while(q != null){
                p_1.next = q.next;
                p_1 = p_1.next;
                if(p_1 != null){
                    q = p_1.next;}
                else{
                    q = null;
                }
            }
            return p;
        }
    }
    
    
    // This is the recursive way to do the equalists
    // Go through two link list and check each node's item
    // if the two nodes' item are not equal with each other return false;
    public static boolean equalListsRec(Node p, Node q){
        Node a = p;
        Node b = q;
        if(a == null && b != null){
            return false;
        }
        else if(a != null && b == null){
            return false;
        }
        else if(a == null && b == null){
            return true;
        }
        else if(a.item != b.item){
            return false;
        }
        else{
            return equalListsRec(a.next,b.next);
        }
    }
    
    // this is the recursive version to find the everyOther Node
    public static Node everyOtherRec(Node p){
        if(p == null){
            return p;
        }
        else{
            if(p.next != null){
                p.next = everyOtherRec(p.next.next);
            }
            return p;
        }
    }
    /*
    public static Node splice(int n, Node p, Node q){
        if(p == null){
            return q;
        }
        else if(q == null){
            return p;
        }
        else{
            int count = 0;
            Node p_1 = p;
            while(p_1 != null){
                count += 1;
                p_1 = p_1.next;
            }
            //System.out.println(count);
            if(n > count){
                Node e = p;
                while(e.next != null){
                    e = e.next;
                }
                e.next = q;
                return p;
              
            }
            else if(n == 0){
                Node d = q;
                while(d.next != null){
                    d = d.next;
                }
                d.next = p;
                return q;
            }
            else{
                int index = 1;
                Node b = p.next;
                Node a = p;
                while(index < n){
                    a= a.next;
                    b = b.next;
                    index += 1;
                }
                a.next = q;
                //printList(p);
                //printList(b);
                Node c = p;
                while(c.next != null){
                    c = c.next;
                }
                c.next = b;
                return p;
            }
        }
    }
    */
    
    
    // This is my helper function
    // in this function, I will use the recursion to let the pointer
    // points to the last node
    private static Node pointToLast(Node p){
        if(p == null || p.next == null)
            return p;
        else{
            p = pointToLast(p.next);
            return p;
        }
    }
    
    // this is the recursive function that I need to use for the splice method
    // it is going to find the place to splice and splice the link list
    // this is in the recursive way
    private static Node spliceHelper(int r,int a, Node p, Node q, int s){
        
        if(r >= s){
            Node d = pointToLast(p);
            d.next = q;
            return p;
        }
        else if(p == null){
            return p;
        }
        else if(r == a){
            Node d = p;
            p = q;
            Node e = pointToLast(p);
            e.next = d;
            p.next = spliceHelper(r , a+1 , p.next, q,s);
            return p;
        }
        else{
            p.next =  spliceHelper(r , a+1 , p.next, q,s);
            return p;
        }
    }
    
    // this is the actural splice method
    // it is going to splice one link list into another one
    public static Node splice(int n, Node p, Node q){
        if(p == null)
            return q;
        else if(q == null)
            return p;
        else{
            return spliceHelper(n,0,p,q, size(p));}
    }
    
    // this is the helper function
    // I am going to use recursion to find out the size of the recursion
    private static int size(Node p){
        if(p == null)
            return 0;
        else{
            return 1 + size(p.next);
        }
    }
    
    // this is the method for swap pairs
    // it is the same with one on lecture notes
    public static Node swapPairs(Node p){
        if(p == null || p.next == null){
            return p;
        }
        else{
            Node q = p.next;
            p.next = swapPairs(q.next);
            q.next = p;
            return q;
        }
    }
    /*
    public static Node intersection(Node p, Node q){
        if(p == null){
            return p;
        }
        else if(q == null){
            return q;
        }
        else{
        Node B = new Node(0,null);
        Node A = B;
        Node q_1 = q;
        for(; p != null ; p=p.next){      
            //System.out.println(p.item);
            for(;q_1 != null ; q_1 = q_1.next){
                //System.out.println(q_1.item);
                if(p.item == q_1.item){
                    A.next = new Node(p.item,null);
                    A= A.next;    
                }
            }
             q_1 = q;
        }
        B = B.next;
             return B;}
    }
    */
    
    // this is the helper method for intersection
    // it is going to check if a integer is in the link list
    // if we do not find the integer in the link list reture false
    // else, return true
    private static boolean memberOf(int n, Node q){
        if(q == null)
            return false;
        else{
            if(q.item == n){
                return true;
            }
            else{
                return memberOf(n, q.next);
            }
        }
    }
    // this is the helper method for intersection method
    // we are going to modify the first link list, and to check 
    // is the node in the other link list. if it is not just delete it
    // use recursive way
    private static Node intersectionHelper(Node p, Node q){
        if(p == null)
            return p;
        else if( memberOf(p.item, q) == false){
            return intersectionHelper(p.next, q);
        }
        else{
            p.next = intersectionHelper(p.next,q);
            return p;
        }
    }
    // this is the method for the intersection
    // create the link list that show all the intersection nodes
    public static Node intersection(Node p, Node q){
        Node m = copy(p);
        m = intersectionHelper(m,q);
        return m;
    }
    
    
    public static void main(String [] args) {
        Node A = new Node(3, new Node(6, new Node( 9, new Node(12, null ) ) ) );
        printList("A", A); 
        
        // Sample unit test for reverse
        
        System.out.println("\n[0] reverse(A):  should print out:\nA -> 12 -> 9 -> 6 -> 3 -> .");
        A = reverse(A);
        printList("A", A); 
        
        // You should write your own unit tests for each of the methods you develop.
        System.out.println("\n[1-1] arrayToLinkedList(A_1):  should print out:\nA_1 -> 1 -> 2 -> 3 -> 4 -> 5 -> .");
        int[] A_1_1 = {1,2,3,4,5};
        Node A_1 = arrayToLinkedList(A_1_1);
        printList("A_1",A_1);
        
        System.out.println("\n[1-2] arrayToLinkedList(A_1):  should print out:\nA_2 -> 2 -> 5 -> 4 -> . ");
        int[] A_1_2 = {2,5,4};
        Node A_2 = arrayToLinkedList(A_1_2);
        printList("A_2",A_2);
        
        System.out.println("\n[2-1] deleteNth(B_1,1):  should print out:\nB_1 -> 5 -> 4 -> . ");
        int[] B_1_1 = { 2,5,4 };
        Node B_1 = arrayToLinkedList(B_1_1);
        B_1 = deleteNth(B_1,1);
        printList("B_1",B_1);
        
        System.out.println("\n[2-2] deleteNth(B_1,2):  should print out:\nB_1 -> 2 -> 4 -> . ");
        int[] B_1_2 = { 2,5,4 };
        Node B_2 = arrayToLinkedList(B_1_2);
        B_2 = deleteNth(B_2,2);
        printList("B_2",B_2);
        
        System.out.println("\n[2-3] deleteNth(B_1,3):  should print out:\nB_1 -> 2 -> 5 -> . ");
        int[] B_1_3 = { 2,5,4 };
        Node B_3 = arrayToLinkedList(B_1_3);
        B_3 = deleteNth(B_3,3);
        printList("B_3",B_3);
        
        System.out.println("\n[2-4] deleteNth(B_1,4):  should print out:\nB_1 -> 2 -> 5 -> 4 -> . ");
        int[] B_1_4 = { 2,5,4 };
        Node B_4 = arrayToLinkedList(B_1_4);
        B_4 = deleteNth(B_4,4);
        printList("B_4",B_4);
        
        System.out.println("\n[2-5] deleteNth(B_1,4):  should print out:\nB_5 -> 2 -> 5 -> 6 -> 2 -> 9 -> .");
        int[] B_1_5 = {2,5,4,6,2,9};
        Node B_5 = arrayToLinkedList(B_1_5);
        B_5 = deleteNth(B_5,3);
        printList("B_5", B_5);
        
        System.out.println("\n[3-1] copy(C_2):  should print out:\nC_2 -> 2 -> 5 -> 4 -> . ");
        int[] C_1_1 = {2,5,4};
        Node C_1 = arrayToLinkedList(C_1_1);
        Node C_2 = copy(C_1);
        printList("C_2",C_2);
        
        System.out.println("\n[3-2] copy(C_2):  should print out:\nC_4 -> . ");
        int[] C_1_2 = {};
        Node C_3 = arrayToLinkedList(C_1_2);
        Node C_4 = copy(C_3);
        printList("C_4",C_4);
        
        System.out.println("\n[4-1] equalLists(D_1, D_2):  should print out:\ntrue");
        int[] D_1_1 = {4,5,7,2,6,9};
        int[] D_1_2 = {4,5,7,7,6,9};
        int[] D_1_3 = {4,5,2,6,9};
        Node D_1 = arrayToLinkedList(D_1_1);
        Node D_2 = arrayToLinkedList(D_1_1);
        printList("D_1",D_1);
        printList("D_2",D_2);
        System.out.println(equalLists(D_1,D_2));
        
        System.out.println("\n[4-2] equalLists(D_1, D_3):  should print out:\nfalse");
        Node D_3 = arrayToLinkedList(D_1_2);
        printList("D_1",D_1);
        printList("D_3",D_3);
        System.out.println(equalLists(D_1,D_3));
        
        System.out.println("\n[4-3] equalLists(D_1, D_4):  should print out:\nfalse");
        Node D_4 = arrayToLinkedList(D_1_3); 
        printList("D_4",D_4);
        printList("D_1",D_1);
        System.out.println(equalLists(D_4,D_1));
        
        System.out.println("\n[4-4] equalLists(D_4, D_6):  should print out:\nfalse");
        int[] D_1_6 = {4,5,2,6,9,8};
        Node D_6 = arrayToLinkedList(D_1_6);
        System.out.println(equalLists(D_4,D_6));
        
        System.out.println("\n[5-1] everyOther(E_1):  should print out:\nE_1 -> .");
        int[] E_1_1 = {};
        Node E_1 = arrayToLinkedList(E_1_1);
        E_1 = everyOther(E_1);
        printList("E_1",E_1);
        
        System.out.println("\n[5-2] everyOther(E_2):  should print out:\nE_2 -> 4 -> 7 -> .");
        int[] E_1_2 = {4,5,7};
        Node E_2 = arrayToLinkedList(E_1_2);
        E_2 = everyOther(E_2);
        printList("E_2",E_2);
        
        System.out.println("\n[5-3] everyOther(E_3):  should print out:\nE_3 -> 4 -> 7 -> 8 -> .");
        int[] E_1_3 = {4,5,7,2,8,1};
        Node E_3 = arrayToLinkedList(E_1_3);
        E_3 = everyOther(E_3);
        printList("E_3",E_3);
        
        System.out.println("\n[5-4] everyOther(E_4):  should print out:\nE_3 -> 4 -> 7 -> 8 -> 2 -> .");
        int[] E_1_4 = {4,5,7,2,8,1,2};
        Node E_4 = arrayToLinkedList(E_1_4);
        E_4 = everyOther(E_4);
        printList("E_4",E_4);
        
        System.out.println("\n[6-1] equalListsRec(F_1, F_2):  should print out:\ntrue");
        int[] F_1_1 = {4,5,7,2,6,9};
        int[] F_1_2 = {};
        int[] F_1_3 = {4,5,2,6,9};
        Node F_1 = arrayToLinkedList(F_1_1);
        Node F_2 = arrayToLinkedList(F_1_1);
        printList("D_1",D_1);
        printList("D_2",D_2);
        System.out.println(equalListsRec(F_1,F_2)); 
        
        System.out.println("\n[6-2] equalListsRec(F_1, F_3):  should print out:\nfalse");
        Node F_3 = arrayToLinkedList(F_1_2);
        printList("F_1",F_1);
        printList("F_3",F_3);
        System.out.println(equalListsRec(F_1,F_3));
        
        System.out.println("\n[6-3] equalListsRec(F_1, F_4):  should print out:\nfalse");
        Node F_4 = arrayToLinkedList(F_1_3); 
        printList("F_4",F_4);
        printList("F_1",F_1);
        System.out.println(equalListsRec(F_4,F_1));
        
        System.out.println("\n[7-1] everyOtherRec(G_1):  should print out:\nG_1 -> .");
        int[] G_1_1 = {};
        Node G_1 = arrayToLinkedList(G_1_1);
        G_1 = everyOtherRec(G_1);
        printList("G_1",G_1);
        
        System.out.println("\n[7-2] everyOtherRec(G_2):  should print out:\nG_2 -> 4 -> 7 -> .");
        int[] G_1_2 = {4,5,7};
        Node G_2 = arrayToLinkedList(G_1_2);
        G_2 = everyOtherRec(G_2);
        printList("G_2",G_2);
        
        System.out.println("\n[7-3] everyOtherRec(G_3):  should print out:\nG_3 -> 4 -> 7 -> 8 -> .");
        int[] G_1_3 = {4,5,7,2,8,1};
        Node G_3 = arrayToLinkedList(G_1_3);
        G_3 = everyOtherRec(G_3);
        printList("G_3",G_3);
        
        System.out.println("\n[7-4] everyOtherRec(G_4):  should print out:\nG_4 -> 4 -> 7 -> 8 -> 2 -> .");
        int[] G_1_4 = {4,5,7,2,8,1,2};
        Node G_4 = arrayToLinkedList(G_1_4);
        G_4 = everyOtherRec(G_4);
        printList("G_4",G_4);
        
        System.out.println("\n[8-1] splice(1,H_1,H_2):  should print out:\nH_3 -> 1 -> 5 -> 6 -> 7 -> 2 -> 3 -> .");
        int[] H_1_1 = {1,2,3};
        int[] H_1_2 = {5,6,7};
        Node H_1 = arrayToLinkedList(H_1_1);
        Node H_2 = arrayToLinkedList(H_1_2);
        Node H_3 = splice(1,H_1,H_2);
        printList("H_3",H_3);
        
        System.out.println("\n[8-2] splice(3,H_4,H_5):  should print out:\nH_6 -> 1 -> 2 -> 3 -> 5 -> 6 -> 7 -> .");
        Node H_4 = arrayToLinkedList(H_1_1);
        Node H_5 = arrayToLinkedList(H_1_2);
        Node H_6 = splice(3,H_4,H_5);
        printList("H_6",H_6);
        
        System.out.println("\n[8-3] splice(0,H_7,H_8):  should print out:\nH_7 -> 5 -> 6 -> 7 -> 1 -> 2 -> 3 -> .");
        Node H_7 = arrayToLinkedList(H_1_1);
        Node H_8 = arrayToLinkedList(H_1_2);
        H_7 = splice(0,H_7,H_8);
        printList("H_7",H_7);
        
        System.out.println("\n[8-4] splice(10,H_9,H_10):  should print out:\nH_9 -> 1 -> 2 -> 3 -> 5 -> 6 -> 7 -> .");
        Node H_9 = arrayToLinkedList(H_1_1);
        Node H_10 = arrayToLinkedList(H_1_2);
        H_9 = splice(10,H_9,H_10);
        printList("H_9",H_9);
        
        System.out.println("\n[9-1] swapPairs(I_1):  should print out:\nI_1 -> 2 -> 1 -> 4 -> 3 -> 6 -> 5 -> .");
        int[] I_1_1 = {1,2,3,4,5,6};
        Node I_1 = arrayToLinkedList(I_1_1);
        I_1 = swapPairs(I_1);
        printList("I_1",I_1);
        
        System.out.println("\n[9-2] swapPairs(I_2):  should print out:\nI_2 -> 2 -> 1 -> 3 -> .");
        int[] I_1_2 = {1,2,3};
        Node I_2 = arrayToLinkedList(I_1_2);
        I_2 = swapPairs(I_2);
        printList("I_2",I_2);
        
        System.out.println("\n[9-3] swapPairs(I_3):  should print out:\nI_3 -> .");
        int[] I_1_3 = {};
        Node I_3 = arrayToLinkedList(I_1_3);
        I_3 = swapPairs(I_3);
        printList("I_3",I_3);
        
        System.out.println("\n[10-1] intersection(J_1,J_2):  should print out:\nJ_3 -> 2 -> 4 -> 5 -> .");
        int[] J_1_1 = {2,3,4,5,6};
        int[] J_1_2 = {1,2,4,5};
        Node J_1 = arrayToLinkedList(J_1_1);
        Node J_2 = arrayToLinkedList(J_1_2);
        Node J_3 = intersection(J_1,J_2);
        printList("J_1",J_1);
        printList("J_2",J_2);
        printList("J_3", J_3);
        
        
        System.out.println("\n[10-2] intersection(J_4,J_5):  should print out:\nJ_6 ->  .");
        int[] J_1_3 = {2,3};
        int[] J_1_4 = {1,4,5};
        Node J_4 = arrayToLinkedList(J_1_3);
        Node J_5 = arrayToLinkedList(J_1_4);
        Node J_6 = intersection(J_4,J_5);
        printList("J_6", J_6);
        
        System.out.println("\n[10-3] intersection(J_7,J_8):  should print out:\nJ_9 -> .");
        
        int[] J_1_5 = {};
        Node J_7 = arrayToLinkedList(J_1_1);
        Node J_8 = arrayToLinkedList(J_1_5);
        Node J_9 = intersection(J_7,J_8);
        printList("J_9", J_9);
        //printList("J_7",J_7);
        //printList("J_8",J_8);
    }
}

// You can put another class in the same file, as long as you do not make it public;
// it will be visible to any other file in the same directory

class Node {
    int item;
    Node next;
    public Node(int it, Node n) {
        item = it; next = n;
    }
}
                