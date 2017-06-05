/* File: IntDeque.java
 * Date: 2/19/2016
 * Author:  Dayuan Wang (wangdayu@bu.edu)
 * Class: CS 112, Spring 2016
 * Purpose: This is the template for HW 05, Problem B.2.
 */

public class IntDeque {
    
    // your code here!
    
    private int SIZE = 10;
    
    private int front = 0;
    
    private int next = 0;
    
    private int size = 0;
    
    private int[] A = new int[SIZE];
    
    private int nextSlot(int k){
        return ((k+1) % A.length);
    }
    
    private int previousSlot(int k){
        if(k == 0)
            return (A.length - 1);
        else
            return (k - 1);
    }
    
    public boolean isEmpty(){
        if (size == 0)
            return true;
        else
            return false;
    }
    
    public int size(){
        return size;
    }
    
    public void resize(){
        SIZE = SIZE * 2;
        reset();
        int[] B = new int[SIZE];
        for(int i = 0; i<A.length; ++i){
            B[i] = A[i];
        }
        A = B;
    }
    
    private void reset() {
        // your code here
        int[] B = new int[SIZE];
        int a = size();
        for(int i = 0; i < a; ++i){
            B[i] = A[front];
            front = nextSlot(front);
        }
        A = B;
        front = 0;
        next = a;
    }
    
    public void enqueueRear(int k){
        if (size == SIZE)
            resize();
        A[next] = k;
        next = nextSlot(next);
        ++size;
    }
    
    public void enqueueFront(int k){
        if (size == SIZE)
            resize();
       // A[previousSlot(front)] = k;
        front = previousSlot(front);
        A[front] = k;
        ++size;
    }
    
    public int dequeueFront()throws QueueUnderflowException{
        if (size() == 0){
            throw new QueueUnderflowException();
        }
        else{
            int temp = A[front];
            front = nextSlot(front);
            --size;
            return temp;
        }}
    
    public int dequeueRear()throws QueueUnderflowException{
        if (size() == 0){
            throw new QueueUnderflowException();
        }
        else{
            int temp = A[previousSlot(next)];
            next = previousSlot(next);
            --size;
            return temp;
        }}
    
    public String toString() {
        String s = "";
        s += "[";
        for(int i = A.length-1; i>0; --i){
            s += "" + A[i] + ", ";
        }
        s += A[0] + "]";
        s += "  length: " + SIZE;
        s += "  size: " + size;
        s += "  front: " + front;
        s += "  next: " + next;
        return s; 
    }
    
    // Unit Test (you must complete this with additonal tests as indicated)
    
    public static void main(String[] args) {
        try{
            
            IntDeque D = new IntDeque(); 
            
            System.out.println("\n[1] First test toString on empty dequeue... Should print out:"); 
            System.out.println("[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]  length: 10  size: 0  front: 0  next: 0"); 
            System.out.println(D); 
            
            System.out.println("\n[2] Test size and isEmpty... Should print out:\n0  true"); 
            System.out.println(D.size() + "  " + D.isEmpty()); 
            
            System.out.println("\n[3] Test enqueueRear.... Should print out:"
                                   + "\n[0, 0, 0, 0, 0, 0, 4, 3, 2, 1]  length: 10  size: 4  front: 0  next: 4");
            D.enqueueRear(1); 
            D.enqueueRear(2);
            D.enqueueRear(3); 
            D.enqueueRear(4);
            
            System.out.println(D); 
            
            System.out.println("\n[4] Test size and isEmpty again... Should print out:\n4  false"); 
            System.out.println(D.size() + "  " + D.isEmpty()); 
            
            System.out.println("\n[5] Test dequeueFront.... Should print out:"
                                   + "\nn = 1  m = 3");
            int n = D.dequeueFront(); 
            D.dequeueFront();  
            int m = D.dequeueFront(); 
            System.out.println("n = " + n + "  m = " + m); 
            
            System.out.println("\n[6] And should print out:"
                                   + "\n[0, 0, 0, 0, 0, 0, 4, 3, 2, 1]  length: 10  size: 1  front: 3  next: 4");
            System.out.println(D); 
            
            
            System.out.println("\n[7] Test wrap-around of enqueueRear .... Should print out:"
                                   + "\n[10, 9, 8, 7, 6, 5, 4, 13, 12, 11]  length: 10  size: 10  front: 3  next: 3");
            
            for(int i = 5; i < 14; ++i)
                D.enqueueRear(i);
            
            System.out.println(D); 
            
            System.out.println("\n[8] Test wrap-around of dequeueFront .... Should print out:"
                                   + "\n[10, 9, 8, 7, 6, 5, 4, 13, 12, 11]  length: 10  size: 0  front: 3  next: 3  m = 13");
            
            for(int i = 0; i < 9; ++i)
                D.dequeueFront();
            m = D.dequeueFront(); 
            
            System.out.println(D + "  m = " + m); 
            
            // Write some temporary tests to make sure that previousSlot(...) works properly; test it especially
            // to make sure that it returns the correct value when you call previousSlot( 0 ). 
            // Delete these test after you are sure that this method works. 
            
            
            IntDeque E = new IntDeque();
            E.enqueueFront(1);
            E.enqueueFront(2);
            E.enqueueFront(3);
            
            System.out.println("\n[9-1] Test enqueueFront .... Should print out:" 
                                   + "\n[1, 2, 3, 0, 0, 0, 0, 0, 0, 0]  length: 10  size: 3  front: 7  next: 0 ");
            System.out.println(E);
            // Test 9: Test enqueue front by inserting several numbers in front and printing out the queue
            
            
            
            D.enqueueFront(3);
            D.enqueueFront(2);
            D.enqueueFront(1);
            
            
            System.out.println("\n[9-2] Test enqueueFront .... Should print out:" 
                                   + "\n[10, 9, 8, 7, 6, 5, 4, 3, 2, 1]  length: 10  size: 3  front: 0  next: 3 ");
            System.out.println(D);
            
            
            // Test 10: Test the size and isempty again
            System.out.println("\n [10-1] Test the size and isempty ... should print out:"
                                   + "\n the size for E is 3; isEmpty false");
            System.out.println("the size for E is " + E.size +";"+ " isEmpty " + E.isEmpty());
            
            System.out.println("\n [10-2] Test the size and isempty ... should print out:"
                                   + "\n the size for D is 3; isEmpty false");
            System.out.println("the size for E is " + D.size +";"+ " isEmpty " + D.isEmpty());
            
            IntDeque F = new IntDeque();
            System.out.println("\n [10-3] Test the size and isempty ... should print out:"
                                   + "\n the size for F is 0; isEmpty true");
            System.out.println("the size for F is " + F.size +";"+ " isEmpty " + F.isEmpty());
            
            
            // Test 11: Test dequeue rear by removing some elements, printing them out, and printing the queue
            
            n = E.dequeueRear();
            System.out.println("\n [11-1] Test dequeue rear ... should print out:"
                                   + "\nn = 1");
            System.out.println("n = " + n);
            System.out.println("\n[1, 2, 3, 0, 0, 0, 0, 0, 0, 0]  length: 10  size: 2  front: 7  next: 9 ");
            System.out.println(E);
            
            // Test 12: test wrap-around of enqueue rear and dequeue front by enqueueing several elements in 
            //          rear until it goes past gap between ends of the array. 
            
            E.dequeueFront();
            E.dequeueFront();
            System.out.println("\n[12] Test the warp-around of dequeue front");
            E.enqueueRear(13);
            E.enqueueRear(13);
            E.enqueueRear(13);
            E.enqueueRear(13);
            E.enqueueRear(13);
            E.enqueueRear(13);
            E.enqueueRear(13);
            E.enqueueRear(12);
            E.enqueueRear(11);
            E.enqueueRear(10);
            System.out.println(E);
            E.dequeueFront();
            E.dequeueFront();
            E.dequeueFront();
            E.dequeueFront();
            E.dequeueFront();
            E.dequeueFront();
            E.dequeueFront();
            n = E.dequeueFront();
            m = E.dequeueFront();
            System.out.println(E);
            System.out.println("the answer should be \nn = 12 m = 11");
            System.out.println("n = " + n + " m = " + m);
            
            // Test 13: Test all four methods together by alternately removing and adding from both ends
            //          and print out the queue to make sure it worked. 
            
            E.enqueueFront(50);
            System.out.println("\n[13-1] Test enqueueFront .... Should print out:" 
                                   + "\n[13, 10, 50, 12, 13, 13, 13, 13, 13, 13]  length: 10  size: 2  front: 7  next: 9 ");
            System.out.println(E);
            
            E.enqueueRear(50);
            System.out.println("\n[13-2] Test enqueueRear .... Should print out:" 
                                   + "\n[50, 10, 50, 12, 13, 13, 13, 13, 13, 13]  length: 10  size: 3  front: 7  next: 0 ");
            System.out.println(E);
            
            n = E.dequeueFront();
            System.out.println("\n[13-3] Test dequeueFront .... Should print out:" 
                                   + "\n[50, 10, 50, 12, 13, 13, 13, 13, 13, 13]  length: 10  size: 2  front: 8  next: 0  n = 50 ");
            System.out.println(E + "  n = " + n);
            
            m = E.dequeueRear();
            System.out.println("\n[13-4] Test dequeueRear .... Should print out:" 
                                   + "\n[50, 10, 50, 12, 13, 13, 13, 13, 13, 13]  length: 10  size: 1  front: 8  next: 9  m = 50 ");
            System.out.println(E + "  m = " + m);
            
            // Test 14: Test size to make sure it works with all four
            D.enqueueRear(50);
            D.enqueueRear(60);
            D.enqueueRear(70);
            D.enqueueRear(80);
            D.enqueueRear(90);
            System.out.println("\n[14-1] Test enqueueRear .... Should print out:" 
                                   + "\n[10, 9, 90, 80, 70, 60, 50, 3, 2, 1]  length: 10  size: 8  front: 0  next: 8 ");
            System.out.println(D);
            
            n = D.dequeueFront();
            System.out.println("\n[14-2] Test dequeueFront .... Should print out:" 
                                   + "\n[10, 9, 90, 80, 70, 60, 50, 3, 2, 1]  length: 10  size: 7  front: 1  next: 8 n = 1 ");
            System.out.println(D + " n = " + n);
            
            D.dequeueRear();
            m = D.dequeueRear();
            System.out.println("\n[14-3] Test dequeueRear .... Should print out:" 
                                   + "\n[10, 9, 90, 80, 70, 60, 50, 3, 2, 1]  length: 10  size: 5  front: 1  next: 6 m = 80 ");
            System.out.println(D + " m = " + m);
            
            D.enqueueRear(99);
            System.out.println("\n[14-4] Test enqueueFront .... Should print out:" 
                                   + "\n[10, 9, 90, 99, 70, 60, 50, 3, 2, 1]  length: 10  size: 6  front: 1  next: 7 ");
            System.out.println(D);
            
            
            // Test 15: test resizing by inserting enough elements to trigger a resize to size 20 and print out
            for(int j = 1; j < 12; ++j){
                F.enqueueRear(j);
            }
            
            System.out.println("\n[15-1] Test enqueueRear .... Should print out:" 
                                   + "\n[0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1]  length: 20  size: 11  front: 0  next: 11");
            System.out.println(F);
            
            IntDeque G = new IntDeque();
            for(int k = 1; k < 12; ++k){
                G.enqueueFront(k);
            }
            System.out.println("\n[15-2] Test enqueueRear .... Should print out:" 
                                   + "\n[11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]  length: 20  size: 11  front: 19  next: 10 ");
            System.out.println(G);
            
            IntDeque R = new IntDeque();
            R.enqueueFront(3);
            R.dequeueFront();
            for(int y = 1; y < 12; ++y){
                R.enqueueRear(y);
            }
            System.out.println("\n[15-3] Test enqueueRear .... Should print out:" 
                                   + "\n[0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1]  length: 20  size: 11  front: 0  next: 11 ");
            System.out.println(R);
            
            IntDeque T = new IntDeque();
            T.enqueueRear(3);
            T.dequeueRear();
            for(int z = 1; z < 12; ++z){
                T.enqueueFront(z);
            }
            System.out.println("\n[15-4] Test enqueueFront .... Should print out:" 
                                   + "\n[11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]  length: 20  size: 11  front: 19  next: 10 ");
             System.out.println(T);
             
             IntDeque W = new IntDeque();
             W.enqueueRear(3);
             W.enqueueRear(4);
             W.enqueueRear(5);
             W.enqueueRear(5);
             W.enqueueRear(5);
             W.enqueueRear(5);
             W.enqueueRear(5);
             W.enqueueRear(5);
             W.enqueueRear(5);
             W.enqueueRear(5);
             
             W.dequeueFront();
             System.out.println(W);
             for(int u = 1; u < 13; ++u){
                W.enqueueRear(u);
            }
             System.out.println("\n[15-5] Test enqueueFront .... Should print out:" 
                                   + "\n[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 5, 5, 5, 5, 5, 5, 5, 5, 4]  length: 40  size: 21  front: 0  next: 21 ");
             System.out.println(W);
            // Test 16: test that enqueue and dequeue (all four) work after resize by alternately removing and adding from both ends
            //          and print out the queue to make sure it worked.
            // Test 17: Test size to make sure it works after the resize
            
            G.enqueueFront(50);
            System.out.println("\n[16&17-1] Test enqueueFront .... Should print out:" 
                                   + "\n[11, 50, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]  length: 20  size: 12  front: 18  next: 10 ");
            System.out.println(G);
            
            G.enqueueRear(60);
            System.out.println("\n[16&17-2] Test enqueueRear .... Should print out:" 
                                   + "\n[11, 50, 0, 0, 0, 0, 0, 0, 0, 60, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]  length: 20  size: 13  front: 18  next: 11");
            System.out.println(G);
            
            n = G.dequeueRear();
            System.out.println("\n[16&17-3] Test dequeueRear .... Should print out:" 
                                   + "\n[11, 50, 0, 0, 0, 0, 0, 0, 0, 60, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]  length: 20  size: 12  front: 18  next: 10 n = 60");
            System.out.println(G + " n = " + n);
            
            G.enqueueRear(70);
            System.out.println("\n[16&17-4] Test enqueueRear .... Should print out:" 
                                   + "\n[11, 50, 0, 0, 0, 0, 0, 0, 0, 70, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]  length: 20  size: 13  front: 18  next: 11");
            System.out.println(G);
            
            m = G.dequeueFront();
            n = G.dequeueRear();
            System.out.println("\n[16&17-5] Test dequeuefront .... Should print out:" 
                                   + "\n[11, 50, 0, 0, 0, 0, 0, 0, 0, 70, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]  length: 20  size: 11  front: 19  next: 10 m = 50 n = 70");
            System.out.println(G + " m = " + m + " n = " + n);
            
            //test area
//            IntDeque X = new IntDeque();
//            X.enqueueFront(5);
//            System.out.println(X);
//            
//            X.dequeueRear();
//            System.out.println(X);
//            
//            X.enqueueRear(3);
//            X.enqueueRear(5);
//            System.out.println(X);
//            
//            X.dequeueFront();
//            System.out.println(X);
            
            
            // Test 18: Test exceptions by removing all elements from queue and then doing one more
            //          dequeueRear and showing how it prints out a message 
            IntDeque Q = G;
            System.out.println("\n[18] Test exceptions");
            while(Q.isEmpty() == false)
                Q.dequeueFront();
            System.out.println(Q);
            System.out.println("\nQ is empty:  " + Q.isEmpty());
            System.out.println(Q.dequeueFront());
        }
        catch(QueueUnderflowException e){
            System.out.println("QueueUnderflowException");
        }
            // Test 19: Do the same for dequeueFront
        try{   
            System.out.println("\n[19] Test exceptions");
            IntDeque V = new IntDeque();
            V.enqueueRear(3);
            V.dequeueRear();
            System.out.println(V);
            System.out.println("\nV is empty:  " + V.isEmpty());
            V.dequeueRear();
        }
            // Strong suggestion for tests 18 and 19: Put a try block around the whole main method
            // up to and including test 18, and then you can make sure that test 18 is correct; then
            // put a separate try block around test 19. It is important to test each of these separately
            // and you can't do that if you use only one try block for the whole main method. 
        
        catch(QueueUnderflowException e){
            System.out.println("QueueUnderflowException");
        }
    }
}
class QueueUnderflowException extends Exception{}

                