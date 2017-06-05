public class test4 {
  
    public static void main (String[] argv) 
    {
        int[] A = { 1, 2, 3, 4, 5, 6 };    
        for(int i = 0; i < A.length; ++i) {
            if( A[i] % 2 == 0 )
                continue;
            else if( A[i] > 4 )
                break;
            else
                A[i] *= 2;
        }
        for(int i = 0; i < A.length; ++i)
            System.out.println(A[i]); 
    }

}