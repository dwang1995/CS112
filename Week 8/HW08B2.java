/* File: HW08B2.java
 * Author: Dayuan Wang(wangdayu@bu.edu)
 * Date: 3/25/16
 * Purpose: This is the template for HW 08 B2
 */


public class HW08B2 { 
    
    // These are the definitions and methods from the BinaryTreeCode link on the class web page
    
    private static class Node {
        int item;
        Node left;
        Node right;
        // number of items in this subtree
        
        public Node(int k) {
            left = null;
            right = null;
            item = k;
            
        }
        
        public Node(int k, Node l, Node r) {
            item = k;
            left = l;
            right = r;
            
        }
    }
    
    
    // Height of a binary tree is number of links in longest path, note that
    //     empty tree has height -1.
    
    private static int height(Node t) {
        if (t == null)
            return -1;
        else 
            return 1 + Math.max( height(t.left), height(t.right) ); 
    }
    // this is a helper function that i am going to use later
    // instead of finding the longest path, i am going to find out the shortest path
    private static int height_2(Node t){
        if (t == null)
            return -1;
        else
            return 1 + Math.min(height_2(t.left),height_2(t.right));
    }
    
    
    // Recursively insert into tree
    
    private static Node insert(Node t, int item) {
        if (t == null)
            return new Node(item);
        else if (item < t.item) {
            t.left = insert(t.left, item);            
            return t;
        } else if (item > t.item) {
            t.right = insert(t.right, item);
            
            return t;
        } else               // item is already here, do nothing
            return t;
    }
    
    // Just a utility method to insert into a tree
    
    private static Node insertArray(int[] A, Node r) {
        Node t = null;
        for(int i = 0; i < A.length; ++i)
            t = insert(t,A[i]);
        return t;  
    }
    
    
    
    // Recursively print out a diagram of the tree sideways
    
    private static void printIndentedTree(Node t) {
        System.out.println();
        printIndentedTreeAux(t, "");
        System.out.println();
    }
    
    private static void printIndentedTreeAux(Node t, String indent) {
        if (t != null) {
            printIndentedTreeAux(t.right, indent + "     "); // add five spaces to indent
            //     System.out.println(indent + t.item + "(" + t.N + ")");
            System.out.println(indent + t.item );
            printIndentedTreeAux(t.left, indent + "     "); // add five spaces to indent
        }
    }
    
    
    
    // These are the methods you must develop for HW08B2
    
    
    
    // return the number of nodes in the tree   (just for practice -- solved in lecture!)
    
    private static int size(Node t){
        if(t == null){
            return 0;
        }
        else{
            return 1 + size(t.left) + size(t.right);
        }
    }
    
    // print out a string representation of a binary tree using parentheses, infix style
    // the first version for print
    private static String treeToString(Node r){
        if(r == null){
            return "";
        }
        else if(r.left == null && r.right != null){
            return "( "+r.item+ " " + treeToString(r.right)+")";          
        }
        else if(r.right == null && r.left != null){
            return "("+ treeToString(r.left) +" "+ r.item+ " )" ;          
        }
        else if(r.right == null && r.left == null){
            return "( "+ r.item + " )";   
        }
        else{
            return "(" + treeToString(r.left)  +" "+ r.item+ " " + treeToString(r.right)+ ")" ;          
        }
    }
    
    
    // print out a string representation of a binary tree using parentheses, prefix style
    // the second version of print
    private static String treeToString2(Node r){
        if(r == null){
            return ".";
        }
        else if(r.right == null && r.left == null){
            return r.item + "(.,.)";
        }
        else{
            return r.item+ "(" + treeToString2(r.left)+ "," + treeToString2(r.right) + ")";
        }
    }
    
    // Count the number of leaves in a binary tree
    // count the number of leaf nodes (count the one that r.left == null and r.right == null)
    private static int numLeaves(Node r){
        if(r == null){
            return 0;
        }
//        else if(r.left == null && r.right != null){
//            return 0 + numLeaves(r.right);
//        }
//        else if(r.right == null && r.left != null){
//            return 0 + numLeaves(r.left);
//        }
        else if(r.right == null && r.left == null){
            return 1;
        }
        else{
            return 0 + numLeaves(r.right) + numLeaves(r.left);
        }
    }
    
    // reverse the tree by exchanging left and right pointers (you will modify the original tree)_
    // use the reconstruct as the template
    // just reverse the thing on the left to the right
    public static Node reverse(Node r){
        if(r == null){
            return r;
        }
        else{
            Node p = copy(r.left);
            r.left = reverse(r.right);
            r.right = reverse(p);
            return r;
        }
    }  
    
    // make a copy of a binary tree
    // use the reconstruct as the template
    private static Node copy(Node r){
        if(r == null){
            return r;
        }
        else{
            Node Q= new Node(r.item);
            Q.left = copy(r.left);
            Q.right = copy(r.right);
            return Q;
        }
    }
    
    // this is the helper method for isBST
    public static boolean isBSTHelper(Node r, int lo, int hi){
        if(r == null){
            return true;
        }
        else if(r.item < lo || r.item > hi){
            return false;
        }
        else if(r.left == null && r.right == null && r.item > lo && r.item < hi){
            return true;
        }
//        else if(r.left == null && r.right == null && (r.item < lo || r.item > hi)){
//            return false;
//        }
        else{
            Boolean node_left = isBSTHelper(r.left,lo,r.item);
            Boolean node_right = isBSTHelper(r.right,r.item,hi);
            if( node_left == true && node_right == true ){
                return true;
            }
            else{
                return false;
            }
        }
    }
    
    // return true if the binary tree satisfies the binary search tree property, false otherwise
    // for any node, if its left item is greater than itself or its right item is smaller than itself, return false
    public static boolean isBST(Node r){
        if(r == null){
            return true;
        }
        else{
            int min = Integer.MIN_VALUE;
            int max = Integer.MAX_VALUE;
            return isBSTHelper(r,min,max);
        }
    }
    
    // return true if r is a full binary tree, i.e.,  is one in which all nodes have 0 or 2 children
    // if the tree is empty, return true
    // if any node has only one thing to point, return fasle
    // if the node has nothing to point, return true
    public static boolean isFull(Node r){    
        if(r == null){
            return true;
        }
        else if(r.left != null && r.right == null){
            return false;
        }
        else if(r.left == null && r.right != null){
            return false;
        }
        else{
            Boolean node_left = isFull(r.left);
            Boolean node_right = isFull(r.right);
            if(node_left == true && node_right == true){
                return true;
            }
            else{
                return false;
            }
        }
    }
    
    
    // return true if r is a degenerate (i.e., "linked-list") binary tree, ie.,  in which all nodes have 0 or 1 child
    // the empty tree is not a degenerate tree
    // if a node has something to point on both left and right, return false
    // if a node has nothing to point on both left and right, return true
    public static boolean isDegenerate(Node r){
        if(r == null){
            return false;
        }
        else if(r.left == null && r.right == null){
            return true;
        }
        else if(r.left != null && r.right != null){
            return false;
        }
        else if(r.left == null && r.right != null){
            return isDegenerate(r.right);
        }
        else{
            return isDegenerate(r.left);
        }
    }
    
    // A perfect binary tree is a perfect triangle; test by checking that all subtrees have same size
    // I will use the helper method height and height_2 to help me
    // height will tell me the longest path
    // height_2 will tell me the shortest path
    // when the tree has both longest and shortest path same, and same for the two sides it is a perfect tree
    public static boolean isPerfect(Node r){
        if(r == null){
            return false;
        }
        else if(r.left != null && r.right == null){
            return false;
        }
        else if(r.left == null && r.right != null){
            return false;
        }
        else{
            int height_left = height(r.left);
            int height_right = height(r.right);
            int height_left_2 = height_2(r.left);
            int height_right_2 = height_2(r.right);
            if(height_left == height_right && height_left_2 == height_right_2 && height_left == height_left_2 && height_right == height_right_2){
                return true;
            }
            else{
                return false;
            }
        }
    }
    
    // Determine if the two binary trees are structurally identical
    // compare both tree, node by node
    // need to go through the whole tree to find out if one of the node is not equal than other
    public static boolean equals(Node r, Node s){
        if(r == null && s == null){
            return true;
        }
        else if(r != null && s == null){
            return false;
        }
        else if(r == null && s != null){
            return false;
        }
        else if(r.item != s.item){
            return false;
        }
        else{
            Boolean node_left_side = equals(r.left,s.left);
            Boolean node_right_side = equals(r.right,s.right);
            if(node_left_side == true && node_right_side == true){
                return true;
            }
            else{
                return false;
            }
        }
    }
    
    
    
    
    // Unit Test for HW08B2
    
    public static void main(String[] args) {
        
        
        
        System.out.println("Sample trees for testing tree methods for HW08B2:"); 
        
        System.out.println("\nTree 0 is null.\n"); 
        Node root0 = null; 
        
        Node root1=null;
        
        int[] A = { 5, 2, 9, 4,1, 7, 12 };
        root1 = insertArray(A,root1);
        System.out.println("Tree 1:"); 
        printIndentedTree(root1);
        
        Node root2=null;
        
        int[] B = { 1, 2, 3, 6, 5, 4 };
        root2 = insertArray(B,root2);
        System.out.println("Tree 2:"); 
        printIndentedTree(root2);   
        
        Node root3=null;
        
        int[]C = { 1, 6, 2, 4, 3, 5 };
        root3 = insertArray(C,root3);
        System.out.println("Tree 3:"); 
        printIndentedTree(root3);     
        
        Node root4=null;
        
        int[] D = { 6, 2, 15, 9, 4, 1, 18, 3, 12, 7,5,10,13 };
        root4 = insertArray(D,root4);
        System.out.println("Tree 4:"); 
        printIndentedTree(root4);     
        
        //Uncover one test at a time as you solve the problems
        
        System.out.println("\nPerformance Tests...."); 
        
        System.out.println("\nTesting size....");
        System.out.println("\n[0] Should print out:\n" + D.length); 
        System.err.println(size(root4)); 
        
        System.out.println("\nTesting treeToString....");
        System.out.println("\n[1] Should print out:\n((( 1 ) 2 ( 4 )) 5 (( 7 ) 9 ( 12 )))"); 
        System.err.println(treeToString(root1)); 
        
        System.out.println("\n[2] Should print out:\n( 1 ( 2 ( 3 ((( 4 ) 5 ) 6 ))))"); 
        System.err.println(treeToString(root2));
        
        System.out.println("\nTesting treeToString2....");
        System.out.println("\n[3] Should print out:\n5(2(1(.,.),4(.,.)),9(7(.,.),12(.,.)))");  
        System.err.println(treeToString2(root1)); 
        
        System.out.println("\n[4] Should print out:\n1(.,6(2(.,4(3(.,.),5(.,.))),.))"); 
        System.err.println(treeToString2(root3)); 
        
        System.out.println("\nTesting numLeaves ....");
        System.out.println("\n[5] Should print out:\n0"); 
        System.err.println(numLeaves(root0)); 
        
        System.out.println("\n[6] Should print out:\n7"); 
        System.err.println(numLeaves(root4)); 
        
        System.out.println("\nTesting isFull ....");
        System.out.println("\n[7] Should print out:\ntrue"); 
        System.err.println(isFull(root0)); 
        
        System.out.println("\n[8] Should print out:\ntrue"); 
        System.err.println(isFull(root1)); 
        
        System.out.println("\n[9] Should print out:\nfalse"); 
        System.err.println(isFull(root3)); 
        
        System.out.println("\n[10] Should print out:\ntrue"); 
        System.err.println(isFull(root4)); 
        
        System.out.println("\nTesting isDegenerate ....");
        System.out.println("\n[11] Should print out:\nfalse"); 
        System.err.println(isDegenerate(root0)); 
        
        System.out.println("\n[12] Should print out:\ntrue"); 
        System.err.println(isDegenerate(root2)); 
        
        System.out.println("\n[13] Should print out:\nfalse"); 
        System.err.println(isDegenerate(root3));  
        
        System.out.println("\n[14] Should print out:\nfalse"); 
        System.err.println(isDegenerate(root4)); 
        
        System.out.println("\nTesting isPerfect ....");
        System.out.println("\n[15] Should print out:\nfalse"); 
        System.err.println(isPerfect(root3));  
        
        System.out.println("\n[16] Should print out:\ntrue"); 
        System.err.println(isPerfect(root1));        
        
        
        System.out.println("\nTesting isBST ....");
        
        // not BSTs 
        Node temp = new Node(4, new Node(5), null);
        Node temp2 = new Node(4, new Node(2, new Node(1), new Node(5)), new Node(10));
        
        System.out.println("\n[17] Should print out:\ntrue"); 
        System.err.println(isBST(root0)); 
        
        System.out.println("\n[18] Should print out:\ntrue"); 
        System.err.println(isBST(root4)); 
        
        System.out.println("\n[19] Should print out:\nfalse"); 
        System.err.println(isBST(temp)); 
        
        System.out.println("\n[20] Should print out:\nfalse");
        
        System.err.println(isBST(temp2)); 
        
        System.out.println("\n[21] Should print out:\nfalse"); 
        System.err.println(isBST(temp2)); 
        
        
        int[] A1 = { 9, 4,1, 7, 5, 2,  12 };
        System.out.println("\nTesting copy ....");
        root1 = insertArray(A,root1);
        
        temp = copy(root1);
        System.out.println("\n[22] Should print out:\n((( 1 ) 2 ( 4 )) 5 (( 7 ) 9 ( 12 )))");  
        System.err.println(treeToString(root1)); 
        
        System.out.println("\n[23] Should print out:\n((( 1 ) 2 ( 4 )) 5 (( 7 ) 9 ( 12 )))");  
        System.err.println(treeToString(temp)); 
        
        temp = insert(temp, 1000); 
        
        System.out.println("\n[24] Should print out:\n((( 1 ) 2 ( 4 )) 5 (( 7 ) 9 ( 12 ( 1000 ))))");  
        System.err.println(treeToString(temp)); 
        
        System.out.println("\n[25] Should print out:\n((( 1 ) 2 ( 4 )) 5 (( 7 ) 9 ( 12 )))");  
        System.err.println(treeToString(root1)); 
        
        System.out.println("\nTesting reverse ....");
        
        System.out.println("\n[26] Should print out:\n((( 12 ) 9 ( 7 )) 5 (( 4 ) 2 ( 1 )))");  
        System.err.println(treeToString(reverse(copy(root1)))); 
        
        System.out.println("\n[27] Should print out:\n((( 1 ) 2 ( 4 )) 5 (( 7 ) 9 ( 12 )))");  
        System.err.println(treeToString(reverse(reverse(root1)))); 
        
        System.out.println("\nTesting equals ....");
        
        System.out.println("\n[28] Should print out:\nfalse"); 
        System.err.println(equals(root1, root2)); 
        
        System.out.println("\n[29] Should print out:\nfalse"); 
        System.err.println(equals(root1, temp)); 
        
        int[] A2 = { 5, 2, 9, 1, 4, 12, 7 };
        temp = null; 
        temp = insertArray(A2,temp);
        
        System.out.println("\n[30] Should print out:\ntrue"); 
        System.err.println(equals(root1, temp)); 
        
        
        
        System.out.println("\n :-) "); 
        
        boolean IamDone = true; 
        System.out.println("\n[31] Should print out:\nHigh Five!"); 
        if(IamDone)
            System.err.println("High Five!");
        else
            System.err.println("Nope!"); 
        
        
    }
    
}
                