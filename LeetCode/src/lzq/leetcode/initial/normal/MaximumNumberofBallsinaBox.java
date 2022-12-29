package lzq.leetcode.initial.normal;

import java.util.Comparator;
import java.util.TreeMap;

public class MaximumNumberofBallsinaBox {
    public int countBalls(int lowLimit, int highLimit) {
        TreeMap<Integer, Integer> mm = new TreeMap<>((o1, o2) -> o2 - o1);
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = calcSum(i);
            mm.put(sum, mm.getOrDefault(sum, 0) + 1);
        }
        return mm.firstEntry().getValue();
    }

    private int calcSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(new MaximumNumberofBallsinaBox().countBalls(1, 10));
    }
}
