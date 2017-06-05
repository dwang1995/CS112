/* File: AverageCaseSorting.java
 * Author: Dayuan Wang
 * Date: 2/11/16
 * Purpose: This is a example of how to graph functions using StdDraw.java
 *    This uses the StdDraw "static container" library, which must be 
 *    in the same directory. 
 */

import java.util.Random;
import java.awt.Color; 

public class AverageCaseSorting {
    
    // your methods and fields go here
   
    private static Random R = new Random();
    
    // This method is to get the number of comparison for Selection sort
    private static int runSelectionSort(int N){
        int[] A = new int[N];
        for(int i = 0; i<N; ++i){
            A[i] = R.nextInt();
        }
        Sorting.counter = 0;
        Sorting.selectionSort(A);
        return Sorting.counter;
    }
    
    // This method is to get the number of comparison for Insertion sort
    private static int runInsertionSort(int N){
        int[] A = new int[N];
        for(int i = 0; i<N; ++i){
            A[i] = R.nextInt();
        }
        Sorting.counter = 0;
        Sorting.insertionSort(A);
        return Sorting.counter;
    }
    
    // This method is to get the number of comparison for Merge sort
    private static int runMergeSort(int N){
        int[] A = new int[N];
        for(int i = 0; i<N; ++i){
            A[i] = R.nextInt();
        }
        Sorting.counter = 0;
        Sorting.mergeSort(A);
        return Sorting.counter;
    }
    
    // This method is to get the number of comparison for Quick sort
    private static int runQuickSort(int N){
        int[] A = new int[N];
        for(int i = 0; i<N; ++i){
            A[i] = R.nextInt();
        }
        Sorting.counter = 0;
        Sorting.quickSort(A);
        return Sorting.counter;
    }
    
    
    public static void main(String[] args) {
        
        int N = 100;
        
        double pointRadius = 0.005;
        double lineRadius = 0.001;
        
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, 10*N);
        StdDraw.setPenRadius(pointRadius);
        StdDraw.setPenColor(Color.black);       // Google "Java Color"; the first link gives all the colors
        StdDraw.line(0,0,0,10*N); 
        StdDraw.text(N,20,"" + N);
        StdDraw.line(0,0,N,0);
        StdDraw.text(5,10*N,"" + 10*N);
        
        double prevX, prevY;
        
        // Graph N^2 in black
        StdDraw.setPenColor(Color.black);
        StdDraw.text(80,30,"N^2");       // draw label String at point (15,500)
        prevX = 0; prevY = 0; 
        for (int i = 1; i <= N; i++) {
            // here is where you put the function you are graphing
            // for example this graphs i^2 (squared)
            int y = i*i;                         
            StdDraw.setPenRadius(pointRadius);
            StdDraw.point(i, y);
            StdDraw.setPenRadius(lineRadius);
            StdDraw.line(prevX, prevY, i, y);
            prevX = i; prevY = y;
        }
        
        // Graph N in gray
        StdDraw.setPenColor(Color.gray);
        StdDraw.text(80,130,"N");
        prevX = 0; prevY = 0; 
        for (int i = 1; i <= N; i++) {
            int y = i;                           // this will graph i    (linear)
            StdDraw.setPenRadius(pointRadius);
            StdDraw.point(i, y);
            StdDraw.setPenRadius(lineRadius);
            StdDraw.line(prevX, prevY, i, y);
            prevX = i; prevY = y;
        }
        
        // Graph Selection sort in orange
        StdDraw.setPenColor(Color.orange);
        StdDraw.text(80,230,"SelectionSort");
        prevX = 0; prevY = 0; 
        for (int i = 1; i <= N; i++) {
            int y = runSelectionSort(i);                           // this will graph i    (linear)
            StdDraw.setPenRadius(pointRadius);
            StdDraw.point(i, y);
            StdDraw.setPenRadius(lineRadius);
            StdDraw.line(prevX, prevY, i, y);
            prevX = i; prevY = y;
        }
        
        // Graph Insertion sort in blue
        StdDraw.setPenColor(Color.blue);
        StdDraw.text(80,330,"InsertionSort");
        prevX = 0; prevY = 0; 
        for (int i = 1; i <= N; i++) {
            int y = runInsertionSort(i);                           // this will graph i    (linear)
            StdDraw.setPenRadius(pointRadius);
            StdDraw.point(i, y);
            StdDraw.setPenRadius(lineRadius);
            StdDraw.line(prevX, prevY, i, y);
            prevX = i; prevY = y;
        }
        
        // Graph merge sort in green
        StdDraw.setPenColor(Color.green);
        StdDraw.text(80,430,"MergeSort");
        prevX = 0; prevY = 0; 
        for (int i = 1; i <= N; i++) {
            int y = runMergeSort(i);                           // this will graph i    (linear)
            StdDraw.setPenRadius(pointRadius);
            StdDraw.point(i, y);
            StdDraw.setPenRadius(lineRadius);
            StdDraw.line(prevX, prevY, i, y);
            prevX = i; prevY = y;
        }
        
        // Graph Quick sort in red
        StdDraw.setPenColor(Color.red);
        StdDraw.text(80,530,"QuickSort");
        prevX = 0; prevY = 0; 
        for (int i = 1; i <= N; i++) {
            int y = runQuickSort(i);                           // this will graph i    (linear)
            StdDraw.setPenRadius(pointRadius);
            StdDraw.point(i, y);
            StdDraw.setPenRadius(lineRadius);
            StdDraw.line(prevX, prevY, i, y);
            prevX = i; prevY = y;
        }
    }
    
}