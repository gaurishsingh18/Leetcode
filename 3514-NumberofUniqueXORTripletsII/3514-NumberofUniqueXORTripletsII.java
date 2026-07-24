// Last updated: 24/07/2026, 15:21:17
1class Solution {
2    public int uniqueXorTriplets(int[] nums) {
3        final int MAX = 2048; // XOR values are in [0, 2047]
4        boolean[][] dp = new boolean[4][MAX];
5        dp[0][0] = true;
6        for (int x : nums) {
7            for (int cnt = 2; cnt >= 0; cnt--) {
8                for (int v = 0; v < MAX; v++) {
9                    if (dp[cnt][v]) {
10                        dp[cnt + 1][v ^ x] = true;
11                    }
12                }
13            }
14        }
15        int ans = 0;
16        for (int v = 0; v < MAX; v++) {
17            if (dp[1][v] || dp[3][v]) {
18                ans++;
19            }
20        }
21        return ans;
22    }
23}