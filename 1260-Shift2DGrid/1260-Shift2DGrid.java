// Last updated: 20/07/2026, 21:05:15
1class Solution {
2    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
3        int m = grid.length;
4        int n = grid[0].length;
5        int total = m * n;
6        k %= total;
7        int[][] ans = new int[m][n];
8        for (int i = 0; i < m; i++) {
9            for (int j = 0; j < n; j++) {
10                int curr = i * n + j;
11                int next = (curr + k) % total;
12                ans[next / n][next % n] = grid[i][j];
13            }
14        }
15        List<List<Integer>> res = new ArrayList<>();
16        for (int i = 0; i < m; i++) {
17            List<Integer> row = new ArrayList<>();
18            for (int j = 0; j < n; j++) {
19                row.add(ans[i][j]);
20            }
21            res.add(row);
22        }
23        return res;
24    }
25}