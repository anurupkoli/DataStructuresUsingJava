package GreedyAlgorithms;

import java.util.ArrayList;

public class IndianCoins {
    public static void main(String[] args) {
        int[] money = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        int v = 594;
        int result = 0;
        int moneyTraverse = v;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = money.length-1; i >= 0; i--) {
            while(money[i] <= moneyTraverse){
                result++;
                arr.add(money[i]);
                moneyTraverse -= money[i];
            }
        }

        System.out.println(result);
        System.out.println(arr.toString());
    }
}
