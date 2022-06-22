package lzq.leetcode.initial.normal;

public class CheckifMoveisLegal {
    private static final int[][] NEXT_MOVE_STEP = {
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1}};

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        if (board[rMove][cMove] != '.') {
            return false;
        }
        for (int i = 0; i < 8; i++) {
            int rMoveNext = rMove + NEXT_MOVE_STEP[i][1];
            int cMoveNext = cMove + NEXT_MOVE_STEP[i][0];
            int reverseNum = 0;
            while (rMoveNext >= 0 && rMoveNext < board.length && cMoveNext >= 0 && cMoveNext < board[0].length) {
                if (board[rMoveNext][cMoveNext] == color && reverseNum == 0) {
                    break;
                } else if (board[rMoveNext][cMoveNext] == color && reverseNum > 0) {
                    return true;
                } else if(board[rMoveNext][cMoveNext] == '.'){
                    break;
                }
                reverseNum++;
                rMoveNext += NEXT_MOVE_STEP[i][1];
                cMoveNext += NEXT_MOVE_STEP[i][0];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckifMoveisLegal c = new CheckifMoveisLegal();
        char[][] board = {
                {'.','.','.','B','.','.','.','.'},
                {'.','.','.','W','.','.','.','.'},
                {'.','.','.','W','.','.','.','.'},
                {'.','.','.','W','.','.','.','.'},
                {'W','B','B','.','W','W','W','B'},
                {'.','.','.','B','.','.','.','.'},
                {'.','.','.','B','.','.','.','.'},
                {'.','.','.','W','.','.','.','.'}};
        System.out.print(c.checkMove(board, 4, 3, 'B'));
    }
}
