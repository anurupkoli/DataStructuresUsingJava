package ArraysAndLinkedLists.Arrays;

import java.util.Arrays;

public class TrappingRainWater {
    public static int trappingRainWater(int[] arr) {
        int[] maxLefVal = new int[arr.length];
        maxLefVal[0] = arr[0];
        int[] maxRightVal = new int[arr.length];
        maxRightVal[arr.length-1] = arr[arr.length-1];
        if(arr.length <= 2){
            return 0;
        }
        // for (int i = 0; i < arr.length; i++) {
        //     int rightMax = Integer.MIN_VALUE;
        //     int leftMax = Integer.MIN_VALUE;
        //     for (int j = i; j < arr.length; j++) {
        //         if (arr[j] > rightMax) {
        //             rightMax = arr[j];
        //         }
        //     }
        //     for (int j = i; j >= 0; j--) {
        //         if (arr[j] > leftMax) {
        //             leftMax = arr[j];
        //         }
        //     }
        //     maxRightVal[i] = rightMax;
        //     maxLefVal[i] = leftMax;
        // }
        for (int i = 1; i < arr.length; i++) {
            maxLefVal[i] = Math.max(arr[i], maxLefVal[i-1]);
        }
        for (int i = arr.length-2; i >= 0; i--) {
            maxRightVal[i] = Math.max(arr[i], maxRightVal[i+1]);
        }
        
        int waterVolume = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = Math.min(maxLefVal[i], maxRightVal[i]);
            int currWater = min - arr[i];
            if(currWater <= 0){
                continue;
            }
            waterVolume += currWater;
        }

        return waterVolume;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,0,6,3,2,5};
        System.out.println(trappingRainWater(arr));;
    }
}
