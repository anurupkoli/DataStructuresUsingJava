package GreedyAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLenChainPairs {
    public static void main(String[] args) {
        int[][] arr = {{5,24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};
        Arrays.sort(arr, Comparator.comparingDouble(o -> o[1]));

        int result = 1;
        int pairLast = arr[0][1];

        for (int i = 1; i < arr.length; i++) {
            if(arr[i][0] > pairLast){
                result++;
                pairLast = arr[i][1];
            }
        }
        System.out.println(result);
    }
}
