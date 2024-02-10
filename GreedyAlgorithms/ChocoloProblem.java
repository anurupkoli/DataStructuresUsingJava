package GreedyAlgorithms;

import java.util.Arrays;
import java.util.Collections;

public class ChocoloProblem {
    public static void main(String[] args) {
        Integer[] costHor = { 4, 1, 2 };
        Integer[] costVert = { 2, 1, 3, 1, 4 };

        Arrays.sort(costHor, Collections.reverseOrder());
        Arrays.sort(costVert, Collections.reverseOrder());

        int v = 0, h = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while (v < costVert.length && h < costHor.length) {
            if (costHor[h] >= costVert[v]) {
                cost += costHor[h] * vp;
                hp++;
                h++;
            } else {
                cost += costVert[v] * hp;
                vp++;
                v++;
            }
        }

        while (v < costVert.length) {
            cost += costVert[v] * hp;
            vp++;
            v++;
        }

        while (h < costHor.length) {
            cost += costHor[h] * vp;
            hp++;
            h++;
        }

        System.out.println(cost);
    }
}
