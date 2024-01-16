package Recursion;

public class XtoPowN{
    static int xToPowN(int x, int n){
        if(n == 1){
            return x;
        }
        return x * xToPowN(x, n-1);
    }

    static int xToPowNOptimized(int x, int n){
        if(n == 0){
            return 1;
        }
        int half = xToPowNOptimized(x, n/2);
        int halfSq = half * half;
        if(n % 2 != 0){
            halfSq = x * halfSq;
        }
        return halfSq;
    }
    public static void main(String[] args) {
        System.out.println(xToPowNOptimized(2, 10));
    }
}