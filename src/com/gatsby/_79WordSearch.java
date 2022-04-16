package com.gatsby;

/**
 * @author -- gatsby
 * @date -- 2022/4/15
 * @description -- leetcode 79 单词搜索
 */


public class _79WordSearch {
    private char[][] board;
    private String word;
    private boolean flag;

    private void dfs(int x, int y, int row, int col, int index, char[][] visited) {
        if (x < 0 || x >= row || y < 0 || y >= col || visited[x][y] == 'y'
                || index >= word.length() || word.charAt(index) != board[x][y])
            return;

        if (index == word.length() - 1 && word.charAt(index) == board[x][y]) {
            this.flag = true;
        }
        visited[x][y] = 'y';
        dfs(x + 1, y, row, col, index + 1, visited);
        dfs(x - 1, y, row, col, index + 1, visited);
        dfs(x, y + 1, row, col, index + 1, visited);
        dfs(x, y - 1, row, col, index + 1, visited);
        visited[x][y] = 'n';
    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        int row = board.length;
        int col = board[0].length;
        char[][] visited = new char[row][col];

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                dfs(i, j, row, col, 0, visited);
                if (flag) {
                    return flag;
                }
            }
        }
        return flag;
    }
}