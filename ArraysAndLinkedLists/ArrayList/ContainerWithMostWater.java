package ArraysAndLinkedLists.ArrayList;

import java.util.ArrayList;

public class ContainerWithMostWater {
    public static int containerWithMostWater(ArrayList<Integer> arr) {
        int waterVolume = 0;

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                int height = Math.min(arr.get(i), arr.get(j));
                int width = j - i;
                waterVolume = Math.max(waterVolume, height*width);
            }
        }

        return waterVolume;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(); //{1,8,6,2,5,4, 8, 3, 7};
        arr.add(1);
        arr.add(8);
        arr.add(6);
        arr.add(2);
        arr.add(5);
        arr.add(4);
        arr.add(8);
        arr.add(3);
        arr.add(7);
        System.out.println(containerWithMostWater(arr));
    }
}
