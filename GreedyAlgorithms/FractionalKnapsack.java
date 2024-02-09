package GreedyAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int w = 50;

        double[][] ratios = new double[weight.length][2];

        for (int i = 0; i < ratios.length; i++) {
            ratios[i][0] = i;
            ratios[i][1] = val[i]/(double)weight[i];
        }

        Arrays.sort(ratios, Comparator.comparingDouble(o -> o[1]));
        int totalAmt = 0;
        int capacaty = w;

        for (int i = weight.length-1; i >= 0; i--) {
            int indx = (int)ratios[i][0];
            if(capacaty >= weight[indx]){
                totalAmt += val[indx];
                capacaty -= weight[indx];
            }
            else{
                totalAmt += ratios[i][1]*capacaty;
                capacaty = 0;
                break;
            }
        }

        System.out.println(totalAmt);
    }
}
