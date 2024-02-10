package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class JobSequencingProblme {
    static class Job {
        int id;
        int deadline;
        int profit;

        Job(int i, int d, int p){
            this.id = i;
            this.deadline = d;
            this.profit = p;
        }
    }
    public static void main(String[] args) {
        int[][] jobInfo = {{4,20}, {1,10},{1,40},{1,30}};

        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < jobInfo.length; i++) {
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        Collections.sort(jobs, (a, b) -> b.profit - a.profit);        

        int time = 0;
        ArrayList<Integer> seq = new ArrayList<>();

        for (int i = 0; i < jobInfo.length; i++) {
            if(jobs.get(i).deadline > time){
                time++;
                seq.add(jobs.get(i).id);
            }
        }

        System.out.println("Max Jobs: " + seq.size());
        System.out.println(seq.toString());

    }
}
