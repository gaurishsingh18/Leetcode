// Last updated: 09/08/2026, 20:38:19
1class Solution {
2    public int minPathSum(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5        for (int j = 1; j < n; j++) {
6            grid[0][j] += grid[0][j - 1];
7        }
8        for (int i = 1; i < m; i++) {
9            grid[i][0] += grid[i - 1][0];
10        }
11        for (int i = 1; i < m; i++) {
12            for (int j = 1; j < n; j++) {
13                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
14            }
15        }
16        return grid[m - 1][n - 1];
17    }
18}