package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * NumberofSubarrayswithBoundedMaximum
 *
 * @author luzheqi
 * @date 2018/3/6
 * @time 下午4:05
 */
public class NumberofSubarrayswithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        if (null == A || A.length <= 0) {
            return 0;
        }
        int sum = 0;
        List<Integer> numSet = new ArrayList<>();
        for (int i : A) {
            if (i <= R) {
                numSet.add(i);
            } else {
                sum = getSum(L, R, sum, numSet);
                numSet.clear();
            }
        }
        sum = getSum(L, R, sum, numSet);
        return sum;
    }

    private int getSum(int L, int R, int sum, List<Integer> numSet) {
        for (int j = 0; j < numSet.size(); j++) {
            if (numSet.get(j) >= L && numSet.get(j) <= R) {
                sum += j + 1;
            } else {
                for (int k = j - 1; k >= 0; k--) {
                    if (numSet.get(k) >= L && numSet.get(k) <= R) {
                        sum += k + 1;
                        break;
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        NumberofSubarrayswithBoundedMaximum n = new NumberofSubarrayswithBoundedMaximum();
        System.out.println(n.numSubarrayBoundedMax(new int[]{55,36,5,55,14,9,7}, 32, 69));
    }
}
