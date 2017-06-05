/* File: AverageCaseBSTs.java
 * Author: Dayuan Wang
 * Date: 3/24/16
 * Purpose: This is a example of how to graph functions using StdDraw.java
 *    This uses the StdDraw "static container" library, which must be 
 *    in the same directory. 
 * 
 * the theta estimate as the Log(N)
 * the constant C should be 2.6 
 */

// the theta estimate as the Log(N)
// the constant C should be 2.6    (when the constain D = -5) 

import java.util.Random;
import java.awt.Color; 

public class AverageCaseBSTs {
    
    // your methods and fields go here
    
    private static Random R = new Random();
    
    public static class Node {
        int key;
        Node left;
        Node right;
        
        public Node(int k) {
            left = null;
            right = null;
            key = k;
        }
        
        public Node(int k, Node left, Node right) {
            key = k;
            this.left = left;
            this.right = right;
            
        }
    }
    
    // Height of a binary tree is number of links in longest path, note that
    //     empty tree has height -1.
    
    public static int height(Node t) {
        if (t == null)
            return -1;
        else 
            return 1 + Math.max( height(t.left), height(t.right) ); 
    }
    
    public static boolean member(Node t, int key) {
        if (t == null)
            return false;
        else if (key < t.key) {
            return member(t.left, key);
        } else if (key > t.key) {
            return member(t.right, key);
        } else
            return true;
    }
    
    public static Node insert(Node t, int key) {
        if (t == null)
            return new Node(key);
        else if (key < t.key) {
            t.left = insert(t.left, key);
            return t;
        } else if (key > t.key) {
            t.right = insert(t.right, key);
            return t;
        } else
            return t;
    }
    
    public static int[] genRandomArray(int size) {
        Random r = new Random();
        
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++)
            arr[i] = r.nextInt();      
        return arr;
    }
    
    
    private static int runBSTInsertion(int N){
        int sum = 0; 
        for(int i = 0; i < 1000; ++i) {
            Node B = null;
            int[] A = genRandomArray(N);
            for(int j = 0; j< A.length; ++j){
                B = insert(B,A[j]);
            }
            sum += height(B);
        }
        int summ= (int)(sum/1000.0);
        return summ;
    }
    
    
    public static void main(String[] args) {
        
        int N = 500;
        
        double pointRadius = 0.005;
        double lineRadius = 0.001;
        
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N/10.0);
        StdDraw.setPenRadius(pointRadius);
        StdDraw.setPenColor(Color.black);       // Google "Java Color"; the first link gives all the colors
        StdDraw.line(0,0,0,10*N); 
        StdDraw.text(N,20,"" + N);
        StdDraw.line(0,0,N,0);
        StdDraw.text(5,10*N,"" + 10*N);
        
        double prevX, prevY;
        
        // graph the actural BST graph
        StdDraw.setPenColor(Color.blue);
        StdDraw.text(40,50,"BST");
        prevX = 0; prevY = 0; 
        for (int i = 1; i <= N; i++) {
            int y = runBSTInsertion(i);                           // this will graph i    (linear)
            StdDraw.setPenRadius(pointRadius);
            StdDraw.point(i, y);
            StdDraw.setPenRadius(lineRadius);
            StdDraw.line(prevX, prevY, i, y);
            prevX = i; prevY = y;
        }
        
        // graph for the ~() graph
        StdDraw.setPenColor(Color.green);
        StdDraw.text(50,40,"2.6*log(N)-5");
        prevX = 0; prevY = 0; 
        for (int i = 1; i <= N; i++) {
            int y = (int)(2.6 * ((Math.log(i))/(Math.log(2))))-5 ;
            //int y = (int)(3.4 * ((Math.log(i)))) ;
            StdDraw.setPenRadius(pointRadius);
            StdDraw.point(i, y);
            StdDraw.setPenRadius(lineRadius);
            StdDraw.line(prevX, prevY, i, y);
            prevX = i; prevY = y;
        }

    }
    
}
                