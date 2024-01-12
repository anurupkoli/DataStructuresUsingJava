package Recursion;

public class PrintNoInDecreasingOrder {
    static void printNoIncresingOrder(int n){
        if(n == 0){
            return;
        }
        printNoIncresingOrder(n-1);
        System.out.print(n + " ");
    }
    public static void main(String[] args) {
        printNoIncresingOrder(10);
    }
}
