// Last updated: 14/07/2026, 15:14:39
1class Solution {
2    static final int MOD = 1_000_000_007;
3    public int subsequencePairCount(int[] nums) {
4        int[][] dp = new int[201][201];
5        dp[0][0] = 1;
6        for (int x : nums) {
7            int[][] next = new int[201][201];
8            for (int g1 = 0; g1 <= 200; g1++) {
9                for (int g2 = 0; g2 <= 200; g2++) {
10                    if (dp[g1][g2] == 0) continue;
11                    int ways = dp[g1][g2];
12                    next[g1][g2] = (next[g1][g2] + ways) % MOD;
13                    int ng1 = (g1 == 0) ? x : gcd(g1, x);
14                    next[ng1][g2] = (next[ng1][g2] + ways) % MOD;
15                    int ng2 = (g2 == 0) ? x : gcd(g2, x);
16                    next[g1][ng2] = (next[g1][ng2] + ways) % MOD;
17                }
18            }
19            dp = next;
20        }
21        long ans = 0;
22        for (int g = 1; g <= 200; g++) {
23            ans = (ans + dp[g][g]) % MOD;
24        }
25        return (int) ans;
26    }
27    private int gcd(int a, int b) {
28        while (b != 0) {
29            int t = a % b;
30            a = b;
31            b = t;
32        }
33        return a;
34    }
35}