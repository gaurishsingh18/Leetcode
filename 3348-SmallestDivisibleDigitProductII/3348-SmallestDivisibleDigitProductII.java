// Last updated: 07/08/2026, 22:51:08
1import java.util.Arrays;
2
3class Solution {
4    int[] twos = {0, 0, 1, 0, 2, 0, 1, 0, 3, 0};
5    int[] threes = {0, 0, 0, 1, 0, 0, 1, 0, 0, 2};
6    int[] fives = {0, 0, 0, 0, 0, 1, 0, 0, 0, 0};
7    int[] sevens = {0, 0, 0, 0, 0, 0, 0, 1, 0, 0};
8
9    public String smallestNumber(String num, long t) {
10        long temp = t;
11        int req2 = 0, req3 = 0, req5 = 0, req7 = 0;
12        while (temp % 2 == 0) { req2++; temp /= 2; }
13        while (temp % 3 == 0) { req3++; temp /= 3; }
14        while (temp % 5 == 0) { req5++; temp /= 5; }
15        while (temp % 7 == 0) { req7++; temp /= 7; }
16        
17        // If t has prime factors other than 2, 3, 5, 7, it's impossible.
18        if (temp > 1) {
19            return "-1";
20        }
21        
22        // Precompute minimal digits to fulfill 2s and 3s requirements
23        String[][] dp = new String[55][40];
24        dp[0][0] = "";
25        
26        for (int i = 0; i <= 50; i++) {
27            for (int j = 0; j <= 35; j++) {
28                if (dp[i][j] == null) continue;
29                
30                for (int d : new int[]{2, 3, 4, 6, 8, 9}) {
31                    int ni = Math.min(50, i + twos[d]);
32                    int nj = Math.min(35, j + threes[d]);
33                    String nStr = addDigit(dp[i][j], (char) ('0' + d));
34                    
35                    if (dp[ni][nj] == null || isBetter(nStr, dp[ni][nj])) {
36                        dp[ni][nj] = nStr;
37                    }
38                }
39            }
40        }
41        
42        // Push optimal results backward so that asking for strictly fewer factors returns the minimal overhead
43        for (int i = 50; i >= 0; i--) {
44            for (int j = 35; j >= 0; j--) {
45                if (dp[i][j] == null) continue;
46                if (i > 0) {
47                    if (dp[i - 1][j] == null || isBetter(dp[i][j], dp[i - 1][j])) dp[i - 1][j] = dp[i][j];
48                }
49                if (j > 0) {
50                    if (dp[i][j - 1] == null || isBetter(dp[i][j], dp[i][j - 1])) dp[i][j - 1] = dp[i][j];
51                }
52            }
53        }
54
55        int n = num.length();
56        int z = num.indexOf('0');
57        if (z == -1) z = n;
58        
59        int[][] pref = new int[n + 1][4];
60        for (int i = 0; i < z; i++) {
61            for (int k = 0; k < 4; k++) pref[i + 1][k] = pref[i][k];
62            int val = num.charAt(i) - '0';
63            pref[i + 1][0] += twos[val];
64            pref[i + 1][1] += threes[val];
65            pref[i + 1][2] += fives[val];
66            pref[i + 1][3] += sevens[val];
67        }
68
69        // 1. Check if `num` is perfectly valid itself
70        if (z == n) {
71            if (pref[n][0] >= req2 && pref[n][1] >= req3 && pref[n][2] >= req5 && pref[n][3] >= req7) {
72                return num;
73            }
74        }
75
76        // 2. Try mutating a prefix from right to left
77        for (int i = Math.min(n - 1, z); i >= 0; i--) {
78            int startD = (num.charAt(i) - '0') + 1;
79            
80            for (int d = startD; d <= 9; d++) {
81                int c2 = pref[i][0] + twos[d];
82                int c3 = pref[i][1] + threes[d];
83                int c5 = pref[i][2] + fives[d];
84                int c7 = pref[i][3] + sevens[d];
85                
86                int rem2 = Math.max(0, req2 - c2);
87                int rem3 = Math.max(0, req3 - c3);
88                int rem5 = Math.max(0, req5 - c5);
89                int rem7 = Math.max(0, req7 - c7);
90                
91                String extra = dp[rem2][rem3];
92                int reqLen = rem5 + rem7 + extra.length();
93                int remSpaces = n - 1 - i;
94                
95                if (reqLen <= remSpaces) {
96                    return buildString(num.substring(0, i), d, remSpaces, rem5, rem7, extra);
97                }
98            }
99        }
100
101        // 3. If impossible to keep same length, build minimum valid extended length string > n
102        int reqLen = req5 + req7 + dp[req2][req3].length();
103        int L = Math.max(n + 1, reqLen);
104        return buildString("", -1, L, req5, req7, dp[req2][req3]);
105    }
106
107    private boolean isBetter(String a, String b) {
108        if (a.length() != b.length()) return a.length() < b.length();
109        return a.compareTo(b) < 0;
110    }
111
112    private String addDigit(String s, char d) {
113        char[] arr = (s + d).toCharArray();
114        Arrays.sort(arr);
115        return new String(arr);
116    }
117    
118    private String buildString(String prefix, int d, int remSpaces, int rem5, int rem7, String extra) {
119        StringBuilder sb = new StringBuilder();
120        sb.append(prefix);
121        if (d != -1) sb.append((char)('0' + d));
122        
123        int reqLen = rem5 + rem7 + extra.length();
124        int ones = remSpaces - reqLen;
125        for (int i = 0; i < ones; i++) {
126            sb.append('1');
127        }
128        
129        StringBuilder reqDigits = new StringBuilder();
130        for (int i = 0; i < rem5; i++) reqDigits.append('5');
131        for (int i = 0; i < rem7; i++) reqDigits.append('7');
132        reqDigits.append(extra);
133        
134        char[] arr = reqDigits.toString().toCharArray();
135        Arrays.sort(arr);
136        sb.append(new String(arr));
137        return sb.toString();
138    }
139}