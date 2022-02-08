package lzq.leetcode.initial.normal;

public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int[][] walked = new int[grid.length][grid[0].length];
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (walked[i][j] > 0) {
                    continue;
                }
                if (grid[i][j] == '1') {
                    walked[i][j] = 1;
                    num++;
                    markIsland(i, j, grid, walked);
                }
            }
        }
        return num;
    }

    private void markIsland(int i, int j, char[][] grid, int[][] walked) {
        if (i - 1 >= 0 && walked[i - 1][j] == 0 && grid[i - 1][j] == '1') {
            walked[i - 1][j] = 1;
            markIsland(i - 1, j, grid, walked);
        }
        if (j - 1 >= 0 && walked[i][j - 1] == 0 && grid[i][j - 1] == '1') {
            walked[i][j - 1] = 1;
            markIsland(i, j - 1, grid, walked);
        }
        if (i + 1 <= grid.length - 1 && walked[i + 1][j] == 0 && grid[i + 1][j] == '1') {
            walked[i + 1][j] = 1;
            markIsland(i + 1, j, grid, walked);
        }
        if (j + 1 <= grid[0].length - 1 && walked[i][j + 1] == 0 && grid[i][j + 1] == '1') {
            walked[i][j + 1] = 1;
            markIsland(i, j + 1, grid, walked);
        }
    }

    public static void main(String[] args) {
        NumberofIslands n = new NumberofIslands();
        System.out.println(n.numIslands(new char[][]{{'1', '1', '0', '0', '0' }, {'1', '1', '0', '0', '0' }, {'0', '0', '1', '0', '0' }, {'0', '0', '0', '1', '1' }}));
    }
}
