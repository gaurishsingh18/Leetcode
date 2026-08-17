// Last updated: 17/08/2026, 21:58:34
1class Solution {
2    public int stoneGameV(int[] stoneValue) {
3        int n = stoneValue.length;
4        int[] prefix = new int[n + 1];
5        for (int i = 0; i < n; i++) {
6            prefix[i + 1] = prefix[i] + stoneValue[i];
7        }
8        int[][] dp = new int[n][n];
9        for (int len = 2; len <= n; len++) {
10            for (int l = 0; l + len - 1 < n; l++) {
11                int r = l + len - 1;
12                for (int k = l; k < r; k++) {
13                    int left = prefix[k + 1] - prefix[l];
14                    int right = prefix[r + 1] - prefix[k + 1];
15                    if (left < right) {
16                        dp[l][r] = Math.max(
17                            dp[l][r],
18                            left + dp[l][k]
19                        );
20                    } 
21                    else if (left > right) {
22                        dp[l][r] = Math.max(
23                            dp[l][r],
24                            right + dp[k + 1][r]
25                        );
26                    } 
27                    else {
28                        dp[l][r] = Math.max(
29                            dp[l][r],
30                            left + Math.max(dp[l][k], dp[k + 1][r])
31                        );
32                    }
33                }
34            }
35        }
36        return dp[0][n - 1];
37    }
38}