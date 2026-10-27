// Last updated: 27/10/2026, 19:50:52
1class Solution {
2    public String[] createGrid(int m, int n) {
3        char[][] grid = new char[m][n];
4        for (int i = 0; i < m; i++) {
5            for (int j = 0; j < n; j++) {
6                grid[i][j] = '#';
7            }
8        }
9        for (int j = 0; j < n; j++) {
10            grid[0][j] = '.';
11        }
12        for (int i = 0; i < m; i++) {
13            grid[i][n - 1] = '.';
14        }
15        String[] result = new String[m];
16        for (int i = 0; i < m; i++) {
17            result[i] = new String(grid[i]);
18        }
19        return result;
20    }
21}