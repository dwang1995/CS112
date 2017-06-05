import java.util.Scanner;
public class test{
    public static void main(String[] args){
        int p = 3 + '3';
        System.out.println(p);
        double x = (3.4 + (int)2.1)*'3';
        System.out.println(x);
        String s = "Hi" + 5 + 't' + true + "there";
        System.out.println(s);
        int n = 1;
        int m = ++n;
        ++m;
        --n;
        n += m--;
        m -= n++;
        System.out.println("n = " + n + "  m = " + m);
    }
}