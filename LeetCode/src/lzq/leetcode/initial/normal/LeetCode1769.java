package lzq.leetcode.initial.normal;

public class LeetCode1769 {
    public int[] minOperations(String boxes) {
        int[][] left = new int[boxes.length()][2];
        left[0] = boxes.charAt(0) == '0' ? new int[]{0, 0} : new int[]{1, 1};
        for (int i = 1; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '0') {
                left[i] = left[i - 1];
            } else {
                left[i] = new int[]{left[i - 1][0] + 1, left[i - 1][1] + i + 1};
            }
        }
        int[][] right = new int[boxes.length()][2];
        int n = boxes.length();
        right[n - 1] = boxes.charAt(n - 1) == '0' ? new int[]{0, 0} : new int[]{1, 1};
        for (int i = n - 2; i >= 0; i--) {
            if(boxes.charAt(i) == '0') {
                right[i] = right[i + 1];
            } else {
                right[i] = new int[]{right[i + 1][0] + 1,right[i + 1][1] + n - i };
            }
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result[i] = n * right[i + 1][0] - right[i + 1][1];
            } else if (i == n - 1) {
                result[i] = n * left[i - 1][0] - left[i - 1][1];
            } else {
                result[i] = ((i + 1) * left[i - 1][0] - left[i - 1][1]) +
                        ((n - i) * right[i + 1][0] - right[i + 1][1]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode1769 l = new LeetCode1769();
        System.out.println(l.minOperations("110"));
    }
}
