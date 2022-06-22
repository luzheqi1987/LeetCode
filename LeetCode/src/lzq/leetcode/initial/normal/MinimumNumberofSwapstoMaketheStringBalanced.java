package lzq.leetcode.initial.normal;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberofSwapstoMaketheStringBalanced {


    public int minSwaps(String s) {
        int left = 0;
        int right = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                left++;
            } else {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        if (right == 0) {
            return 0;
        } else {
            return calc(right);
        }
    }

    private int calc(int number) {
        return (number  + 1) /2;
    }

    private int calc1(int number) {
        int[] mins = new int[number + 1];
        for(int i = 1; i <= number; i++){
            int min = Integer.MAX_VALUE;
            if(i == 1 || i == 2){
                min = 1;
                mins[i] = min;
            }else {
                for (int j = 2; j <= i - 1 ; j++) {
                    min = Math.min(min, mins[j - 1] + mins[i - j]);
                }
                mins[i] = min;
            }
        }
        return mins[number];
    }


    private int calc(int i, int[] walked) {
        if (i == 1 || i == 2) {
            return 1;
        } else if (walked[i] > 0) {
            return walked[i];
        }
        int min = Integer.MAX_VALUE;
        for (int start = 1; start <= i / 2; start++) {
            min = Math.min(min, calc(start, walked) + calc(i - start, walked));
        }
        walked[i] = min;
        return min;
    }
    public static void main(String[] args) {
        MinimumNumberofSwapstoMaketheStringBalanced c = new MinimumNumberofSwapstoMaketheStringBalanced();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 500000; i++) {
            sb.append(']');
        }
        for (int i = 0; i < 500000; i++) {
            sb.append('[');
        }
        System.out.println(c.minSwaps(sb.toString()));
        //System.out.println(c.minSwaps("]]][[["));
    }
}
