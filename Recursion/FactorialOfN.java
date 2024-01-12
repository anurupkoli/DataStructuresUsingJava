package Recursion;

public class FactorialOfN {
    static int factorialN(int n){
        if(n == 0){
            return 1;
        }
        return n * factorialN(n-1);
    }
    public static void main(String[] args) {
        int fact = factorialN(3);
        System.out.println(fact);
    }
}
