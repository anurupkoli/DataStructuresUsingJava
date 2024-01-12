package Recursion;

public class PrintNoInDecreasingOrder {
    static int prevNo = 1;
    static void printNoIncresingOrder(int n, int prevNo){
        if(prevNo > n){
            return;
        }
        System.out.print(prevNo + " ");
        printNoIncresingOrder(n, prevNo+1);
    }
    public static void main(String[] args) {
        printNoIncresingOrder(10, prevNo);
    }
}
