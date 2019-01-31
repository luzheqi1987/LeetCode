package lzq.leetcode.initial.normal;

/**
 * ValidTicTacToeState
 *
 * @author luzheqi
 * @date 2018/3/8
 * @time 下午3:46
 */
public class ValidTicTacToeState {
    public boolean validTicTacToe(String[] board) {
        char[][] boards = new char[3][3];
        int xNum = 0;
        int oNum = 0;
        int xOk = 0;
        int oOk = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boards[i][j] = board[i].charAt(j);
                if (boards[i][j] == 'X') {
                    xNum++;
                } else if (boards[i][j] == 'O') {
                    oNum++;
                }
            }
        }
        if (oNum > xNum || xNum - oNum > 1) {
            return false;
        }

        for (int i = 0; i < 3; i++) {
            if (boards[i][0] == boards[i][1] && boards[i][1] == boards[i][2] && boards[i][0] != ' ') {
                if (boards[i][0] == 'X') xOk += 1;
                else oOk += 1;
            }
            if (boards[0][i] == boards[1][i] && boards[1][i] == boards[2][i] && boards[0][i] != ' ') {
                if (boards[0][i] == 'X') xOk += 1;
                else oOk += 1;
            }
        }

        if (boards[0][0] == boards[1][1] && boards[1][1] == boards[2][2] && boards[0][0] != ' ') {
            if (boards[0][0] == 'X') xOk += 1;
            else oOk += 1;
        }

        if (boards[0][2] == boards[1][1] && boards[1][1] == boards[2][0] && boards[0][2] != ' ') {
            if (boards[0][2] == 'X') xOk += 1;
            else oOk += 1;
        }

        if (xOk > 0 && oOk > 0) {
            return false;
        } else if (xOk > 0 && xNum <= oNum) {
            return false;
        } else if (oOk > 0 && xNum > oNum) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidTicTacToeState v = new ValidTicTacToeState();
        System.out.println(v.validTicTacToe(new String[]{"XO ", "   ", "X  "}));
//        System.out.println(v.validTicTacToe(new String[]{"O  ", "   ", "   "}));
//        System.out.println(v.validTicTacToe(new String[]{"XOX", " X ", "   "}));
//        System.out.println(v.validTicTacToe(new String[]{"XXX", "   ", "OOO"}));
//        System.out.println(v.validTicTacToe(new String[]{"XOX", "O O", "XOX"}));
    }
}
