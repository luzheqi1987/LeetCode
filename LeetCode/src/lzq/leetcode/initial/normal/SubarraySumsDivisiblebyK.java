package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * SubarraySumsDivisiblebyK
 *
 * @author luzheqi
 * @date 2019-02-03
 * @time 10:58
 */
public class SubarraySumsDivisiblebyK {


    public int subarraysDivByK(int[] A, int K) {
        //There K mod groups 0...K-1
        //For each prefix sum that does not have remainder 0 it needs to be paired with 1 with the same remainder
        //this is so the remainders cancel out.
        int N = A.length;
        int[] modGroups = new int[K];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i];
            int group = sum % K;

            if (group < 0) {
                group += K;
            }
            modGroups[group]++;
        }

        int total = 0;
        for (int x : modGroups) {
            if (x > 1) {
                total += (x * (x - 1)) / 2;
            }
        }
        //Dont forget all numbers that divide K
        return total + modGroups[0];
    }

    public int subarraysDivByK1(int[] A, int K) {
        List<Integer> numbers = new ArrayList<>();
        int index = 0;
        int num = 0;
        int sum = 0;
        while (index < A.length) {
            while (index < A.length && A[index] == 0) {
                num++;
                index++;
            }
            if (num != 0) {
                sum += (1 + num) * num / 2 - 1;
                num = 0;
                numbers.add(0);
            } else {
                numbers.add(A[index]);
                index++;
            }
        }
        int[][] road = new int[numbers.size()][numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            road[0][i] = numbers.get(i);
            if (road[0][i] % K == 0) {
                sum++;
            }
        }
        for (int i = 1; i < numbers.size(); i++) {
            for (int j = i; j < numbers.size(); j++) {
                road[i][j] = road[i - 1][j - 1] + numbers.get(j);
                if (road[i][j] % K == 0) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        SubarraySumsDivisiblebyK s = new SubarraySumsDivisiblebyK();
        System.out.println(s.subarraysDivByK1(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }
}
