/*
 * File: Graph.java
 * Purpose: This is the file to generate the Graph, to add, remove the edge
 *          and to determine the winning or losing for each color
 * Date: 4/26/2016
 * Class: CS 112
 *
 * Author: Dayuan Wang
 */


public class Graph{
    public int N;
    private int[][] B;
    
    // I am going to create the adjacent matrix for storing the graph information
    
    
    public Graph(int p){
        this.N = p;
        this.B = new int[N][N];
    }
    public Graph(){
        this.N = 6;
        this.B = new int[N][N];
    }
   
    // this is the method to add the Edge to the graph
    public void addEdge(int u, int v, int w){
        if(isEdge(u,v) == false){
            B[u][v] = w;
            B[v][u] = w;}
    }
    
    // This is the method to remove the edge to the graph
    public void removeEdge(int u, int v){
        B[u][v] = 0;
        B[v][u] = 0;
    }
    
    // This is the method to get the color of a Edge
    public int getEdge(int u, int v){
        return B[u][v];
    }
    
    // this is the method to determine weather there is a edge or not(between two edges)
    public boolean isEdge(int u, int v){
        return (B[u][v] != 0);
    }
    
    // This is the method to get the number of degree for a certain vertex
    public int degree(int v){
        int A = 0;
        for(int i = 0; i< N; ++i){
            if(B[i][v] != 0){
                A += 1;
            }
        }
        return A;
    }
    
    // this is the method to get the number of degree for a certain vertex for a certain color
    public int degree(int v, int w){
        int A = 0;
        for(int i = 0; i< N; ++i){
            if(B[i][v] == w){
                A += 1;
            }
        }
        return A;
    }
    
    // this is the method to print the graph 
    public void printEdges(){
//        System.out.println("0  1   2   3   4   5");
//        for(int i=0; i< N; ++i){
//            System.out.println(i + ": ");
//            for(int j = 0; j<N; ++j){
//                System.out.print(B[i][j]);
//            }
//        }
        String S = ""; 
        for(int i = 0; i < N; ++i){
            for(int j = 0; j< N; ++j){
                //System.out.println(i + "\t" + j);
                S +="   " + B[i][j] + "   ";
            }
            S += "\n";
        }
        System.out.println(S);
    }
    
    // this is the method to determine a winner for a certain color
    // if there is a cycle for with a certain length for the color, return true
    public boolean isCycleOfLength( int n, int w){
        for(int p = 0; p < N; ++p){
            if( isCycleHelper(p, p, n, w)){
                return true;
            }
        }
        return false;
    }
    // this is the helper method for the determine
    // I am going to use the loop with the recursion
    private boolean isCycleHelper(int u,int yuanshi, int n, int w){
        //System.out.println(u + "\t" + yuanshi);
        if(n != 1 ){
            for(int v = 0; v< N ; ++v){
                if(v!= u){
                    if(getEdge(u,v) == w){
                        if(isCycleHelper(v, yuanshi, n-1, w))
                            return true;
                    }               
                }
            }          
        }
        else if(n == 1){            
            if(getEdge(u,yuanshi) == w){
                return true;
            }     
        }
        return false;
    }
    
    public static void main(String[] args){
        ///*
        Graph A = new Graph(6);
        A.printEdges();
        
        System.out.println("Testing addEdge; it should give me the same thing with the website");
        A.addEdge(0,1,-1);
        A.addEdge(0,2,-1);
        A.addEdge(0,3,-1);
        A.addEdge(4,1,1);
        A.addEdge(2,5,1);
        A.addEdge(2,3,1);
        
        A.printEdges();
        System.out.println("Testing getEdge; it should give me -1");
        System.out.println(A.getEdge(0,3));
        System.out.println();
        System.out.println("Testing getEdge; it should give me 1");
        System.out.println(A.getEdge(2,5));
        System.out.println();
        System.out.println("Testing removeEdge; it should remove the edge 0 to 3");
        A.removeEdge(0,3);
        A.printEdges();
        System.out.println();
        System.out.println("Testing removeEdge; it should remove the edge 4 to 1");
        A.removeEdge(4,1);
        A.printEdges();
        System.out.println();
        System.out.println("Add them back in");
        A.addEdge(4,1,1);
        A.addEdge(3,0,-1);
        
        System.out.println("Testing for degree; should give me 3");
        System.out.println(A.degree(0));
        System.out.println();
        System.out.println("Testing for degree; should give me 2");
        System.out.println(A.degree(2,1));
        
        A.addEdge(3,5,1);
        A.printEdges();
        System.out.println("Testing for isCycleOfLength; it should give me true");
        System.out.println(A.isCycleOfLength(3,1));
        System.out.println();
        
        A.addEdge(2,1,-1);
        System.out.println("Testing for isCycleOfLength; it should give me true");
        System.out.println(A.isCycleOfLength(3,-1));
        System.out.println();
        
        
        Graph B = new Graph();
        B.addEdge(0,2,1);
        B.addEdge(2,3,1);
        B.addEdge(3,5,1);
        B.addEdge(0,5,1);
        System.out.println("Testing for isCycleOfLength; it should give me true");
        System.out.println(B.isCycleOfLength(4,1));
        System.out.println();
        
        B.addEdge(1,3,-1);
        B.addEdge(4,3,-1);
        B.addEdge(1,4,-1);
        System.out.println("Testing for isCycleOfLength; it should give me true");
        System.out.println(B.isCycleOfLength(3,-1));
        System.out.println();
        
        System.out.println("Testing for isCycleOfLength; it should give me false");
        System.out.println(B.isCycleOfLength(3,1));
        System.out.println();
        
        Graph C = new Graph(6);
        C.addEdge(0,2,1);
        C.addEdge(2,4,1);
        C.addEdge(4,0,1);
        System.out.println("Testing for isCycleOfLength; it should give me true");
        System.out.println(C.isCycleOfLength(3,1));
        System.out.println();
        
        
        Graph E = new Graph(6);       
        E.addEdge(5,1,1);
        E.addEdge(3,1,1);
        E.addEdge(3,5,1);
        System.out.println(E.getEdge(3,5));
        System.out.println("Testing for isCycleOfLength; it should give me true");
        System.out.println(E.isCycleOfLength(3,1));
        System.out.println();
        
        Graph D = new Graph(6);
        D.addEdge(1,2,1);
        D.addEdge(2,3,1);
        D.addEdge(4,3,1);
        D.addEdge(1,0,1);
        D.addEdge(5,0,1);
        D.addEdge(5,4,1);
        System.out.println("Testing for isCycleOfLength; it should give me true");
        System.out.println(D.isCycleOfLength(6,1));
        System.out.println();
        
        Graph F = new Graph();
        F.addEdge(1,2,-1);
        F.addEdge(2,3,-1);
        F.addEdge(3,1,-1);
        System.out.println("it should give me true");
        System.out.println(F.isCycleOfLength(3,-1));
        System.out.println();
        System.out.println("It should give me false");
        System.out.println(F.isCycleOfLength(3,1));
        System.out.println();
        
        System.out.println("Testing for unusual");
        Graph P = new Graph(7);
        P.addEdge(0,6,-1);
        P.printEdges();
        
    }
    
}