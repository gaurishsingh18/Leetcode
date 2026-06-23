// Last updated: 23/06/2026, 19:37:03
1class Solution {
2    public int zigZagArrays(int n, int l, int r) {
3        int MOD = 1000000007;
4        int m = r - l + 1;
5
6        long[] up = new long[m];
7        long[] down = new long[m];
8
9        // Base case: length = 2
10        for (int i = 0; i < m; i++) {
11            up[i] = i;               // values smaller than i
12            down[i] = m - i - 1;    // values greater than i
13        }
14
15        // Build for length 3 to n
16        for (int len = 3; len <= n; len++) {
17
18            long[] newUp = new long[m];
19            long[] newDown = new long[m];
20
21            long[] prefixDown = new long[m];
22            long[] suffixUp = new long[m];
23
24            prefixDown[0] = down[0];
25            for (int i = 1; i < m; i++) {
26                prefixDown[i] = (prefixDown[i - 1] + down[i]) % MOD;
27            }
28
29            suffixUp[m - 1] = up[m - 1];
30            for (int i = m - 2; i >= 0; i--) {
31                suffixUp[i] = (suffixUp[i + 1] + up[i]) % MOD;
32            }
33
34            for (int i = 0; i < m; i++) {
35                // need previous move = down, current move = up
36                if (i > 0) {
37                    newUp[i] = prefixDown[i - 1];
38                }
39
40                // need previous move = up, current move = down
41                if (i < m - 1) {
42                    newDown[i] = suffixUp[i + 1];
43                }
44            }
45
46            up = newUp;
47            down = newDown;
48        }
49
50        long ans = 0;
51        for (int i = 0; i < m; i++) {
52            ans = (ans + up[i] + down[i]) % MOD;
53        }
54
55        return (int) ans;
56    }
57}