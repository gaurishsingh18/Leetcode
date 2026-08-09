// Last updated: 09/08/2026, 20:32:20
1class Solution {
2    public int stoneGameII(int[] piles) {
3        int n = piles.length;
4        int[] suffix = new int[n];
5        suffix[n - 1] = piles[n - 1];
6        for (int i = n - 2; i >= 0; i--) {
7            suffix[i] = piles[i] + suffix[i + 1];
8        }
9        int[][] dp = new int[n][n + 1];
10        return helper(0, 1, piles, dp, suffix);
11    }
12    private int helper(int i, int M, int[] piles, int[][] dp, int[] suffix) {
13        int n = piles.length;
14        if (i + 2 * M >= n) {
15            return suffix[i];
16        }
17        if (dp[i][M] != 0) return dp[i][M];
18        int maxStones = 0;
19        for (int X = 1; X <= 2 * M; X++) {
20            int next = helper(i + X, Math.max(M, X), piles, dp, suffix);
21            maxStones = Math.max(maxStones, suffix[i] - next);
22        }
23        return dp[i][M] = maxStones;
24    }
25}