package lzq.leetcode.initial.normal;

import java.util.*;

/**
 * TimeBasedKeyValueStore
 *
 * @author luzheqi
 * @date 2019-02-01
 * @time 16:52
 */
public class TimeBasedKeyValueStore {
    private Map<String, Map<Integer, String>> valueMap;
    private Map<String, List<Integer>> valueTime;

    /**
     * Initialize your data structure here.
     */
    public TimeBasedKeyValueStore() {
        valueMap = new HashMap<>();
        valueTime = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Map<Integer, String> timeValues = valueMap.get(key);
        List<Integer> times = valueTime.get(key);
        if (null == timeValues) {
            timeValues = new HashMap<>();
            times = new ArrayList<>();
        }
        if (!timeValues.containsKey(timestamp)) {
            times.add(timestamp);
            Collections.sort(times);
        }
        timeValues.put(timestamp, value);
        valueTime.put(key, times);
        valueMap.put(key, timeValues);
    }

    public String get(String key, int timestamp) {
        if (!valueMap.containsKey(key)) {
            return "";
        }
        int nearestKey = findNearest(valueTime.get(key), timestamp, 0, valueTime.get(key).size() - 1);
        if (nearestKey < 0) {
            return "";
        } else {
            return valueMap.get(key).get(valueTime.get(key).get(nearestKey));
        }
    }

    private int findNearest(List<Integer> times, int target, int start, int end) {
        if (start == end || target == times.get(start)) {
            return start;
        } else if (target < times.get(start)) {
            return -1;
        } else if (target >= times.get(end)) {
            return end;
        }

        int mid = start + (end - start) / 2 + 1;
        if (target == times.get(mid)) {
            return mid;
        } else if (target < times.get(mid)) {
            return findNearest(times, target, start, mid -1 );
        } else {
            return findNearest(times, target, mid, end);
        }
    }

    public static void main(String[] args) {
        TimeBasedKeyValueStore tbjvs = new TimeBasedKeyValueStore();
        tbjvs.set("love", "high", 10);
        tbjvs.set("love", "low", 20);
        System.out.println(tbjvs.get("love", 5));
        System.out.println(tbjvs.get("love", 10));
        System.out.println(tbjvs.get("love", 15));
        System.out.println(tbjvs.get("love", 20));
        System.out.println(tbjvs.get("love", 25));
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */