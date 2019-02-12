package lzq.leetcode.initial.normal;

/**
 * LongestTurbulentSubarray
 *
 * @author luzheqi
 * @date 2019-02-02
 * @time 18:29
 */
public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] A) {
        if (A.length <= 2) {
            return A.length;
        }

        boolean needBigger = true;
        boolean started = false;
        int start = 0;
        int longest = 0;
        int tmpPath = 0;

        while (start < A.length - 1) {
            if(A[start] == A[start + 1]){
                start++;
                started = false;
                longest = Math.max(longest, tmpPath);
                continue;
            }
            if (!started) {
                needBigger = !(A[start] > A[start + 1]);
                tmpPath = 2;
                started = true;
                start++;
                continue;
            }
            if (needBigger) {
                if (A[start] > A[start + 1]) {
                    needBigger = !needBigger;
                    tmpPath++;
                    start++;
                } else {
                    started = false;
                    longest = Math.max(longest, tmpPath);
                }
            } else {
                if (A[start] < A[start + 1]) {
                    needBigger = !needBigger;
                    tmpPath++;
                    start++;
                } else {
                    started = false;
                    longest = Math.max(longest, tmpPath);
                }
            }
        }
        longest = Math.max(longest, tmpPath);
        return longest;
    }

    public static void main(String[] args) {
        LongestTurbulentSubarray longestTurbulentSubarray = new LongestTurbulentSubarray();
        System.out.println(longestTurbulentSubarray.maxTurbulenceSize(new int[]{0,8,45,88,48,68,28,55,17,24}));
    }
}
