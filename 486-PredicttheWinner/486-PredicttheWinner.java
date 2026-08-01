// Last updated: 01/08/2026, 20:28:41
1class Solution {
2    public boolean predictTheWinner(int[] nums) {
3        int n = nums.length;
4        int[][] dp = new int[n][n];
5        for (int i = 0; i < n; i++) {
6            dp[i][i] = nums[i];
7        }
8        for (int len = 2; len <= n; len++) {
9            for (int i = 0; i + len - 1 < n; i++) {
10                int j = i + len - 1;
11                dp[i][j] = Math.max(nums[i] - dp[i + 1][j],
12                                    nums[j] - dp[i][j - 1]);
13            }
14        }
15        return dp[0][n - 1] >= 0;
16    }
17}