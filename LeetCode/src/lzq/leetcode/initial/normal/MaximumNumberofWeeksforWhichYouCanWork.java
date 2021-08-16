package lzq.leetcode.initial.normal;

public class MaximumNumberofWeeksforWhichYouCanWork {

    public long numberOfWeeks(int[] milestones) {
        if (null == milestones || milestones.length <= 0) {
            return 0;
        }
        long sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i : milestones) {
            if (i > max) {
                max = i;
            }
            sum += i;
        }
        if (max > (sum - max + 1)) {
            return 2 * (sum - max) + 1;
        } else {
            return sum;
        }
    }

    public static void main(String[] args) {
        MaximumNumberofWeeksforWhichYouCanWork x = new MaximumNumberofWeeksforWhichYouCanWork();
        System.out.println(x.numberOfWeeks(new int[]{5,2,1}));
    }
}
