package lzq.leetcode.initial.normal;

import java.util.*;

public class MaximumProfitinJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int maxEndTime = Integer.MIN_VALUE;
        int maxProfit = 0;
        Map<Integer, List<Job>> jobs = new HashMap<>();
        for (int i = 0; i < startTime.length; i++) {
            List<Job> preJobs = jobs.getOrDefault(endTime[i], new ArrayList<>());
            preJobs.add(new Job(startTime[i], endTime[i], profit[i]));
            jobs.put(endTime[i], preJobs);
            maxEndTime = Math.max(maxEndTime, endTime[i]);
        }

        Map<Integer, Integer> maxMap = new TreeMap<>(new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        for(int i = 1; i <= maxEndTime; i++) {
            List<Job> jobList = jobs.get(i);
            if(null == jobList) {
                continue;
            } else {
                for (Job job : jobList) {
                    int currentStartTime = job.startTime;
                    int currentMax = job.profit;
                    if (!maxMap.isEmpty()) {
                        for (Map.Entry<Integer, Integer> entry : maxMap.entrySet()) {
                            if (entry.getKey() <= currentStartTime) {
                                currentMax = Math.max(currentMax, currentMax + entry.getValue());
                            } else {
                                currentMax = Math.max(currentMax, entry.getValue());
                            }
                        }
                    }
                    maxMap.put(i, currentMax);
                    maxProfit = Math.max(maxProfit, currentMax);
                }
            }
        }
        return maxProfit;
    }
    class Job {
        int startTime;
        int endTime;
        int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
}
