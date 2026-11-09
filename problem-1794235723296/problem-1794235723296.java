// Last updated: 09/11/2026, 20:18:43
1class Solution {
2    public boolean isMatch(String s, String p) {
3        int m = s.length();
4        int n = p.length();
5        boolean[][] dp = new boolean[m + 1][n + 1];
6        
7        dp[0][0] = true;
8        
9        for (int j = 2; j <= n; j++) {
10            if (p.charAt(j - 1) == '*') {
11                dp[0][j] = dp[0][j - 2];
12            }
13        }
14        
15        for (int i = 1; i <= m; i++) {
16            for (int j = 1; j <= n; j++) {
17                char sc = s.charAt(i - 1);
18                char pc = p.charAt(j - 1);
19                
20                if (pc == sc || pc == '.') {
21                    dp[i][j] = dp[i - 1][j - 1];
22                } else if (pc == '*') {
23                    dp[i][j] = dp[i][j - 2];
24                    char prev = p.charAt(j - 2);
25                    if (prev == sc || prev == '.') {
26                        dp[i][j] = dp[i][j] || dp[i - 1][j];
27                    }
28                }
29            }
30        }
31        
32        return dp[m][n];
33    }
34}