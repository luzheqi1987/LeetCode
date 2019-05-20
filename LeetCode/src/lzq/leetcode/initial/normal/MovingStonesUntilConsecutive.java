package lzq.leetcode.initial.normal;

/**
 * MovingStonesUntilConsecutive
 *
 * @author luzheqi
 * @date 2019-05-17
 * @time 11:16
 */
public class MovingStonesUntilConsecutive {
    public int[] numMovesStones(int a, int b, int c) {
        int maxNum = Math.max(a, Math.max(b, c));
        int minNum = Math.min(a, Math.min(b, c));
        int midNum = maxNum == a ? Math.max(b, c) : (maxNum == b ? Math.max(a, c) : Math.max(a, b));

        if (maxNum - midNum == 1 && midNum - minNum == 1) {
            return new int[]{0, 0};
        } else if (Math.min(maxNum - midNum, midNum - minNum) <= 2) {
            return new int[]{1, maxNum - midNum - 1 + (midNum - minNum - 1)};
        } else {
            return new int[]{2, maxNum - midNum - 1 + (midNum - minNum - 1)};
        }
    }

    public static void main(String[] args) {
        MovingStonesUntilConsecutive n = new MovingStonesUntilConsecutive();
        int[] result = n.numMovesStones(3, 5, 1);
        System.out.println(result[0] + "\t" + result[1]);
    }
}
