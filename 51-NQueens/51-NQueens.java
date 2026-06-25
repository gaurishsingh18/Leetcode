// Last updated: 25/06/2026, 23:09:13
class Solution {
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        placeQueen(0, n, board, result);
        return result;
    }

    private void placeQueen(int row, int n, char[][] board, List<List<String>> result) {
        if (row == n) {
            result.add(buildBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (canPlace(row, col, board, n)) {
                board[row][col] = 'Q';
                placeQueen(row + 1, n, board, result);
                board[row][col] = '.';
            }
        }
    }

    private boolean canPlace(int row, int col, char[][] board, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> buildBoard(char[][] board) {
        List<String> temp = new ArrayList<>();

        for (char[] row : board) {
            temp.add(new String(row));
        }

        return temp;
    }
}