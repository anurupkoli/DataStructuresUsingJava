package ArraysAndLinkedLists.Arrays;

public class TrappingRainWater {
    public static int trappingRainWater(int[] arr) {
        int[] maxLefVal = new int[arr.length];
        int[] maxRightVal = new int[arr.length];
        if(arr.length <= 2){
            return 0;
        }
        for (int i = 0; i < arr.length; i++) {
            int rightMax = Integer.MIN_VALUE;
            int leftMax = Integer.MIN_VALUE;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] > rightMax) {
                    rightMax = arr[j];
                }
            }
            for (int j = i; j >= 0; j--) {
                if (arr[j] > leftMax) {
                    leftMax = arr[j];
                }
            }
            maxRightVal[i] = rightMax;
            maxLefVal[i] = leftMax;
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
        int[] arr = {1,2,3,4,5,6 };
        System.out.println(trappingRainWater(arr));;
    }
}
