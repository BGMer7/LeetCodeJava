package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2021/12/18
 * @description -- leetcode 419 甲板战舰
 */


public class _419BattleshipsInABoard {
    private int row;
    private int col;

    public int countBattleships(char[][] board) {
        this.row = board.length;
        this.col = board[0].length;
        int res = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                // 只要左边的和上面的都是'.'，那说明此时的这个'X'就是一个船的船头，同时考虑边界问题，有哪些i、j是不能取的，警惕数组越界
                if ((i == 0 && j == 0 && board[i][j] == 'X') || (i > 0 && j == 0 && board[i][j] == 'X' && board[i - 1][j] == '.')
                        || (j > 0 && i == 0 && board[i][j] == 'X' && board[i][j - 1] == '.')
                        || (i > 0 && j > 0 && board[i][j] == 'X' && board[i - 1][j] == '.' && board[i][j - 1] == '.')) {
                    System.out.println("i: " + i + ", j: " + j);
                    ++res;
                }
            }
        }
        return res;
    }

    public int countBattleshipsByDfs(char[][] board) {
        this.row = board.length;
        this.col = board[0].length;
        int res = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] == 'X') {
                    ++res;
                    dfs(i, j, board);
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j, char[][] board) {
        if (i < 0 || j < 0 || i >= row || j >= col || board[i][j] == '.') return;
        else if (board[i][j] == 'X')
            board[i][j] = '.';

        dfs(i + 1, j, board);
        dfs(i - 1, j, board);
        dfs(i, j - 1, board);
        dfs(i, j + 1, board);
    }

    public static void main(String[] args) {
        // [["X", ".", ".", "X"],[".", ".", ".", "X"],[".", ".", ".", "X"]]
        char[][] board = {{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
        _419BattleshipsInABoard solution = new _419BattleshipsInABoard();
        System.out.println(solution.countBattleships(board));
        System.out.println(solution.countBattleshipsByDfs(board));
    }
}