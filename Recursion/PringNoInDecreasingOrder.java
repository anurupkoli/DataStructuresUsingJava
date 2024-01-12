package Recursion;

public class PringNoInDecreasingOrder {
    static void printNoDecreasingOrder(int n){
        if(n == 0){
            return;
        }
        System.out.print(n + " ");
        printNoDecreasingOrder(n-1);
    }
    public static void main(String[] args) {
        printNoDecreasingOrder(10);
    }
}
