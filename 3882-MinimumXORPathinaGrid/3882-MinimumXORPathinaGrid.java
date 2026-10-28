// Last updated: 28/10/2026, 15:42:38
1class Solution {
2    public int minCost(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5        HashSet<Integer>[][] dp = new HashSet[m][n];
6        
7        for (int i = 0; i < m; i++) {
8            for (int j = 0; j < n; j++) {
9                dp[i][j] = new HashSet<>();
10            }
11        }
12        dp[0][0].add(grid[0][0]);
13        
14        for (int i = 0; i < m; i++) {
15            for (int j = 0; j < n; j++) {
16                if (i > 0) {
17                    for (int val : dp[i - 1][j]) {
18                        dp[i][j].add(val ^ grid[i][j]);
19                    }
20                }
21                if (j > 0) {
22                    for (int val : dp[i][j - 1]) {
23                        dp[i][j].add(val ^ grid[i][j]);
24                    }
25                }
26            }
27        }
28        int minXor = Integer.MAX_VALUE;
29        for (int val : dp[m - 1][n - 1]) {
30            minXor = Math.min(minXor, val);
31        }
32        
33        return minXor;
34    }
35}