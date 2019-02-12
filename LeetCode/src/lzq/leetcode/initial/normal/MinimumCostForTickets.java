package lzq.leetcode.initial.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * MinimumCostForTickets
 *
 * @author luzheqi
 * @date 2019-01-31
 * @time 14:44
 */
public class MinimumCostForTickets {
    private static Map<Integer, Integer> tickets2Days = new HashMap<>();
    private Map<Integer, Integer> minCache = new HashMap<>();

    static {
        tickets2Days.put(0, 1);
        tickets2Days.put(1, 7);
        tickets2Days.put(2, 30);
    }

    public int mincostTickets(int[] days, int[] costs) {
        return calcCost(days, 0, costs, 0);
    }

    private int calcCost(int[] days, int index, int[] cost, int currentCost) {
        if (index >= days.length) {
            return currentCost;
        } else if (minCache.containsKey(index)) {
            return minCache.get(index) + currentCost;
        }
        int[] curCost = new int[3];
        for (int i = 0; i < 3; i++) {
            int start = index + 1;
            int startDay = days[index];
            while (start < days.length && days[start] - startDay + 1 <= tickets2Days.get(i)) {
                start++;
            }
            curCost[i] = calcCost(days, start, cost, currentCost + cost[i]);
        }
        int min = Math.min(Math.min(curCost[0], curCost[1]), curCost[2]);
        minCache.put(index, min - currentCost);
        return min;
    }

    public static void main(String[] args) {
        int[] days = new int[]{1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs = new int[]{2,7,15};
        System.out.println(new MinimumCostForTickets().mincostTickets(days, costs));
    }
}
