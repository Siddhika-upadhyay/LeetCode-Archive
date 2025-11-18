class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int index = 0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (board[i][j]==word.charAt(index)) {
                    if (comb(board, word, i, j, index, m, n))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean comb(char[][]board, String word,
                        int row,int col,int index,
                        int m,int n) {
        if (index==word.length()) return true;
        if (row < 0||col < 0||row == n||col == m||
            board[row][col] != word.charAt(index) ||
            board[row][col] == '#')
            return false;
        char c = board[row][col];
        board[row][col] = '#';
        boolean top = comb(board, word, row - 1, col, index + 1, m, n);
        boolean bottom = comb(board, word, row + 1, col, index + 1, m, n);
        boolean left = comb(board, word, row, col - 1, index + 1, m, n);
        boolean right = comb(board, word, row, col + 1, index + 1, m, n);
        board[row][col] = c;

        return top || bottom || left || right;
    }
}
