// Last updated: 22/06/2026, 19:58:13
1class Solution {
2    
3    public List<List<String>> solveNQueens(int n) {
4        List<List<String>> result = new ArrayList<>();
5        char[][] board = new char[n][n];
6        
7        for (int i = 0; i < n; i++) {
8            Arrays.fill(board[i], '.');
9        }
10
11        placeQueen(0, n, board, result);
12        return result;
13    }
14
15    private void placeQueen(int row, int n, char[][] board, List<List<String>> result) {
16        if (row == n) {
17            result.add(buildBoard(board));
18            return;
19        }
20
21        for (int col = 0; col < n; col++) {
22            if (canPlace(row, col, board, n)) {
23                board[row][col] = 'Q';
24                placeQueen(row + 1, n, board, result);
25                board[row][col] = '.';
26            }
27        }
28    }
29
30    private boolean canPlace(int row, int col, char[][] board, int n) {
31        for (int i = 0; i < row; i++) {
32            if (board[i][col] == 'Q') return false;
33        }
34
35        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
36            if (board[i][j] == 'Q') return false;
37        }
38
39        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
40            if (board[i][j] == 'Q') return false;
41        }
42
43        return true;
44    }
45
46    private List<String> buildBoard(char[][] board) {
47        List<String> temp = new ArrayList<>();
48
49        for (char[] row : board) {
50            temp.add(new String(row));
51        }
52
53        return temp;
54    }
55}