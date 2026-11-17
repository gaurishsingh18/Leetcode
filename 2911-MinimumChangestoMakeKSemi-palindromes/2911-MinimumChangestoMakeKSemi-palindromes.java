// Last updated: 17/11/2026, 14:32:56
1class Solution {
2    public int minimumChanges(String s, int k) {
3        int n = s.length();
4        int[][] changeCost = new int[n][n];
5
6        for (int len = 1; len <= n; len++) {
7            for (int i = 0; i <= n - len; i++) {
8                int j = i + len - 1;
9                int minChanges = 1000000;
10                
11                for (int d = 1; d < len; d++) {
12                    if (len % d == 0) {
13                        int currentChanges = 0;
14                        for (int g = 0; g < d; g++) {
15                            int left = i + g;
16                            int right = i + len - d + g;
17                            while (left < right) {
18                                if (s.charAt(left) != s.charAt(right)) {
19                                    currentChanges++;
20                                }
21                                left += d;
22                                right -= d;
23                            }
24                        }
25                        minChanges = Math.min(minChanges, currentChanges);
26                    }
27                }
28                changeCost[i][j] = minChanges;
29            }
30        }
31
32        int[][] dp = new int[n + 1][k + 1];
33        for (int i = 0; i <= n; i++) {
34            java.util.Arrays.fill(dp[i], 1000000);
35        }
36        dp[0][0] = 0;
37
38        for (int j = 1; j <= k; j++) {
39            for (int i = 1; i <= n; i++) {
40                for (int p = j - 1; p < i; p++) {
41                    dp[i][j] = Math.min(dp[i][j], dp[p][j - 1] + changeCost[p][i - 1]);
42                }
43            }
44        }
45
46        return dp[n][k];
47    }
48}