package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivityProblem {
    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};
        int[][] activities = new int[start.length][3];
        for (int i = 0; i < activities.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        Arrays.sort(activities, Comparator.comparing(o -> o[2]));

        ArrayList<Integer> ans = new ArrayList<>();
        int maxActivities = 1;
        ans.add(0);
        int lastEnd=  activities[0][0];
        for (int i = 1; i < end.length; i++) {
            if(activities[i][1] > lastEnd){
                ans.add(i);
                lastEnd = activities[i][2];
                maxActivities++;
            }
        }
        
        System.out.println(maxActivities);
        System.out.println(ans.toString());
    }
}
