// Last updated: 15/09/2026, 22:56:58
1class Solution {
2    private boolean[][] dp;
3    private int[] f;
4    private String s;
5    private int n;
6    private int k;
7
8    public int maxPalindromes(String s, int k) {
9        n = s.length();
10        f = new int[n];
11        this.s = s;
12        this.k = k;
13        dp = new boolean[n][n];
14        for (int i = 0; i < n; ++i) {
15            Arrays.fill(dp[i], true);
16            f[i] = -1;
17        }
18        for (int i = n - 1; i >= 0; --i) {
19            for (int j = i + 1; j < n; ++j) {
20                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
21            }
22        }
23        return dfs(0);
24    }
25    private int dfs(int i) {
26        if (i >= n) {
27            return 0;
28        }
29        if (f[i] != -1) {
30            return f[i];
31        }
32        int ans = dfs(i + 1);
33        for (int j = i + k - 1; j < n; ++j) {
34            if (dp[i][j]) {
35                ans = Math.max(ans, 1 + dfs(j + 1));
36            }
37        }
38        f[i] = ans;
39        return ans;
40    }
41}