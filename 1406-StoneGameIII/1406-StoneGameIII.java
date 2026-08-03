// Last updated: 04/08/2026, 01:25:33
1class Solution {
2    public String stoneGameIII(int[] stoneValue) {
3        int n = stoneValue.length;
4        int[] dp = new int[n + 1];
5        for (int i = n - 1; i >= 0; i--) {
6            dp[i] = Integer.MIN_VALUE;
7            int sum = 0;
8            for (int k = 0; k < 3 && i + k < n; k++) {
9                sum += stoneValue[i + k];
10                dp[i] = Math.max(dp[i], sum - dp[i + k + 1]);
11            }
12        }
13        if (dp[0] > 0) return "Alice";
14        if (dp[0] < 0) return "Bob";
15        return "Tie";
16    }
17}