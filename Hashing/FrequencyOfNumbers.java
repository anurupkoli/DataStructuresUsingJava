package Hashing;

import java.util.*;

public class FrequencyOfNumbers {
    public static void main(String[] args) {
        int[] arr = {1,3,3,5,1,3,1,3,1};
        int n = arr.length/3;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if(map.get(key) > 3){
                System.out.print(key + " : " + map.get(key));
                System.out.println();
            }
        }
    }
}
