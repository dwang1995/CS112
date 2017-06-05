public class test3 {
  
  public static void main (String[] argv) 
  {
    int[] A = { 1, 1, 1, 1 };    // this initializes an array of length 4 with all values being 1
    for(int i = 0; i < 4; ++i) {
      for(int j = i-1; j >=0; --j) {
         A[i] +=  A[j];
      }
    }
    for(int i = 0; i < 4; ++i)
      System.out.println(A[i]); 
  }

}