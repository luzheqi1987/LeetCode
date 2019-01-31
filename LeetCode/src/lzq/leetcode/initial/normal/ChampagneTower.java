package lzq.leetcode.initial.normal;

/**
 * ChampagneTower
 *
 * @author luzheqi
 * @date 2018/3/16
 * @time 下午5:31
 */
public class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if (query_row == 0 && query_glass == 0) {
            return poured > 1 ? 1 : poured;
        } else if (query_glass > query_row) {
            return 0;
        }
        double[][] array = new double[2][query_row + 1];
        array[0][0] = poured;
        for (int i = 1; i <= query_row; i++) {
            int row = i % 2;
            int otherrow = (i + 1) % 2;
            boolean changed = false;
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    if (array[otherrow][j] > 1) {
                        array[row][j] = (array[otherrow][j] - 1) / 2;
                        changed = true;
                    } else {
                        array[row][j] = 0;
                    }
                } else if (j == i) {
                    if (array[otherrow][j - 1] > 1) {
                        array[row][j] = (array[otherrow][j - 1] - 1) / 2;
                        changed = true;
                    } else {
                        array[row][j] = 0;
                    }
                } else {
                    if (array[otherrow][j] > 1 || array[otherrow][j - 1] > 1) {
                        array[row][j] = ((array[otherrow][j] > 1 ? array[otherrow][j] - 1 : 0) +
                                (array[otherrow][j - 1] > 1 ? array[otherrow][j - 1] - 1 : 0)) / 2;
                        changed = true;
                    } else {
                        array[row][j] = 0;
                    }
                }
                if (i == query_row && j == query_glass) {
                    return array[row][j] > 1 ? 1 : array[row][j];
                }
            }
            if (!changed) {
                return 0.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        ChampagneTower c = new ChampagneTower();
        System.out.println(c.champagneTower(6, 3, 1));
    }
}
