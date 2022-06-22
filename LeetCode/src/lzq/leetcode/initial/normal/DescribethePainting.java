package lzq.leetcode.initial.normal;

import java.util.*;
import java.util.stream.Collectors;

public class DescribethePainting {

//    public List<List<Long>> splitPainting(int[][] segments) {
//        Map<Integer, Set<Integer>> overlapMap = new HashMap<Integer, Set<Integer>>();
//        int maxPos = -1;
//        int minPos = Integer.MAX_VALUE;
//        long[] sums = new long[100001];
//        for (int i = 0; i < segments.length; i++) {
//            for (int j = segments[i][0]; j < segments[i][1]; j++) {
//                Set<Integer> colors = overlapMap.getOrDefault(j, new HashSet<>());
//                colors.add(segments[i][2]);
//                overlapMap.put(j, colors);
//                sums[j] += segments[i][2];
//            }
//            if (segments[i][1] > maxPos) {
//                maxPos = segments[i][1];
//            }
//            if (segments[i][0] < minPos) {
//                minPos = segments[i][0];
//            }
//        }
//        List<List<Long>> result = new ArrayList<>();
//        for (int i = minPos; i < maxPos; i++) {
//            if (!overlapMap.containsKey(i)) {
//                continue;
//            }
//            List<Long> newRange = new ArrayList<>();
//            newRange.add((long) i);
//            while (i + 1 <= maxPos &&
//                    sums[i + 1] == sums[i] &&
//                    overlapMap.containsKey(i + 1) &&
//                    overlapMap.get(i).containsAll(overlapMap.get(i + 1))) {
//                i++;
//            }
//            newRange.add((long) i + 1);
//            newRange.add(sums[i]);
//            result.add(newRange);
//        }
//        return result;
//    }

    public List<List<Long>> splitPainting(int[][] segments) {
        Map<Integer, Long> colorMap = new TreeMap<>(Comparator.comparingInt(o -> o));
        for (int[] segment : segments) {
            colorMap.put(segment[0], colorMap.getOrDefault(segment[0], 0L) + segment[2]);
            colorMap.put(segment[1], colorMap.getOrDefault(segment[1], 0L) - segment[2]);
        }
        int st = Integer.MIN_VALUE;
        long color = 0;
        List<List<Long>> result = new ArrayList<>();
        for(Map.Entry<Integer, Long> entry: colorMap.entrySet()){
            if(st != Integer.MIN_VALUE && color != 0){
                List<Long> r = new ArrayList<>();
                r.add((long) st);
                r.add((long) entry.getKey());
                r.add(color);
                result.add(r);
            }
            color += colorMap.get(entry.getKey());
            st = entry.getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        DescribethePainting d = new DescribethePainting();
        System.out.println(d.splitPainting(
                new int[][]{
                        {4, 16, 12}, {9, 10, 15}, {18, 19, 13}, {3, 13, 20}, {12, 16, 3}, {2, 10, 10}, {3, 11, 4}, {13, 16, 6}
                }));
    }
}
