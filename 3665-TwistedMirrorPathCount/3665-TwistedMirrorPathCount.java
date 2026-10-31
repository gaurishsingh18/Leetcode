// Last updated: 31/10/2026, 22:56:18
1class Solution {
2    public int uniquePaths(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5        int mod = 1000000007;
6
7        long[][] dp = new long[n + 1][2];
8        dp[1][0] = 1;
9        dp[1][1] = 1;
10
11        for (int r = 0; r < m; r++) {
12            for (int c = 0; c < n; c++) {
13                if (grid[r][c] == 1) {
14                    dp[c + 1] = new long[] {dp[c + 1][1], dp[c][0]};
15                } else {
16                    long val = (dp[c + 1][1] + dp[c][0]) % mod;
17                    dp[c + 1] = new long[] {val, val};
18                }
19            }
20        }
21        return (int) dp[n][0];
22    }
23}