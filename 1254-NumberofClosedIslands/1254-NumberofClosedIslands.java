// Last updated: 25/10/2026, 21:44:27
1class Solution {
2    public int closedIsland(int[][] grid) {
3        int rows = grid.length;
4        int cols = grid[0].length;
5        
6        for (int i = 0; i < rows; i++) {
7            for (int j = 0; j < cols; j++) {
8                if ((i == 0 || i == rows - 1 || j == 0 || j == cols - 1) && grid[i][j] == 0) {
9                    dfs(grid, i, j);
10                }
11            }
12        }
13        int count = 0;
14        for (int i = 0; i < rows; i++) {
15            for (int j = 0; j < cols; j++) {
16                if (grid[i][j] == 0) {
17                    count++;
18                    dfs(grid, i, j);
19                }
20            }
21        }
22        
23        return count;
24    }
25    private void dfs(int[][] grid, int r, int c) {
26        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 1) {
27            return;
28        }
29        grid[r][c] = 1;
30        dfs(grid, r + 1, c);
31        dfs(grid, r - 1, c);
32        dfs(grid, r, c + 1);
33        dfs(grid, r, c - 1);
34    }
35}