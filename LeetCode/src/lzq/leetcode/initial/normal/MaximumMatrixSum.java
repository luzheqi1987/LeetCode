package lzq.leetcode.initial.normal;

public class MaximumMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        int num = 0;
        int maxMinus = Integer.MIN_VALUE;
        int minUpper = Integer.MAX_VALUE;
        long sum = 0;
        int zeroNum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < 0) {
                    if (matrix[i][j] > maxMinus) {
                        maxMinus = matrix[i][j];
                    }
                    num++;
                    sum += -matrix[i][j];
                } else {
                    if (matrix[i][j] < minUpper) {
                        minUpper = matrix[i][j];
                    }
                    sum += matrix[i][j];
                }
                if (matrix[i][j] == 0) {
                    zeroNum++;
                }
            }
        }
        if (num % 2 == 1 && zeroNum <= 0) {
            sum -= 2L * Math.min(-maxMinus, minUpper);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{
                {2, 9, 3},
                {5, 4, -4},
                {1, 7, 1}

        };
        MaximumMatrixSum a = new MaximumMatrixSum();
        System.out.println(a.maxMatrixSum(m));
    }
}
