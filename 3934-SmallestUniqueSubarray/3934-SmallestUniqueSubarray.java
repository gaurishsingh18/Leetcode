// Last updated: 25/11/2026, 20:41:38
1import java.util.Arrays;
2
3class Solution {
4    public int smallestUniqueSubarray(int[] nums) {
5        int n = nums.length;
6        if (n == 1) {
7            return 1;
8        }
9
10        int[] sa = buildSuffixArray(nums);
11        int[] rank = new int[n];
12        for (int i = 0; i < n; i++) {
13            rank[sa[i]] = i;
14        }
15
16        int[] lcp = buildLCP(nums, sa, rank);
17
18        int[] maxMatch = new int[n];
19        for (int i = 0; i < n - 1; i++) {
20            int a = sa[i];
21            int b = sa[i + 1];
22            int len = lcp[i];
23            if (len > maxMatch[a]) {
24                maxMatch[a] = len;
25            }
26            if (len > maxMatch[b]) {
27                maxMatch[b] = len;
28            }
29        }
30
31        int ans = n;
32        for (int i = 0; i < n; i++) {
33            int reqLen = maxMatch[i] + 1;
34            if (i + reqLen <= n && reqLen < ans) {
35                ans = reqLen;
36            }
37        }
38
39        return ans;
40    }
41
42    private int[] buildSuffixArray(int[] s) {
43        int n = s.length;
44        int maxVal = 0;
45        for (int v : s) {
46            if (v > maxVal) {
47                maxVal = v;
48            }
49        }
50
51        int m = Math.max(maxVal + 1, n);
52        int[] sa = new int[n];
53        int[] rnk = new int[n];
54        int[] tmp = new int[n];
55        int[] cnt = new int[m];
56
57        for (int i = 0; i < n; i++) {
58            cnt[s[i]]++;
59        }
60        for (int i = 1; i < m; i++) {
61            cnt[i] += cnt[i - 1];
62        }
63        for (int i = n - 1; i >= 0; i--) {
64            sa[--cnt[s[i]]] = i;
65        }
66
67        rnk[sa[0]] = 0;
68        for (int i = 1; i < n; i++) {
69            rnk[sa[i]] = rnk[sa[i - 1]] + (s[sa[i]] != s[sa[i - 1]] ? 1 : 0);
70        }
71
72        for (int k = 1; k < n; k <<= 1) {
73            Arrays.fill(cnt, 0, m, 0);
74            int p = 0;
75            for (int i = n - k; i < n; i++) {
76                tmp[p++] = i;
77            }
78            for (int i = 0; i < n; i++) {
79                if (sa[i] >= k) {
80                    tmp[p++] = sa[i] - k;
81                }
82            }
83
84            for (int i = 0; i < n; i++) {
85                cnt[rnk[tmp[i]]]++;
86            }
87            for (int i = 1; i < m; i++) {
88                cnt[i] += cnt[i - 1];
89            }
90            for (int i = n - 1; i >= 0; i--) {
91                sa[--cnt[rnk[tmp[i]]]] = tmp[i];
92            }
93
94            tmp[sa[0]] = 0;
95            int classes = 1;
96            for (int i = 1; i < n; i++) {
97                int cur = sa[i];
98                int prev = sa[i - 1];
99                boolean diffFirst = rnk[cur] != rnk[prev];
100                boolean diffSecond = (cur + k < n ? rnk[cur + k] : -1) != (prev + k < n ? rnk[prev + k] : -1);
101                if (diffFirst || diffSecond) {
102                    classes++;
103                }
104                tmp[cur] = classes - 1;
105            }
106            System.arraycopy(tmp, 0, rnk, 0, n);
107            if (classes == n) {
108                break;
109            }
110        }
111
112        return sa;
113    }
114
115    private int[] buildLCP(int[] s, int[] sa, int[] rank) {
116        int n = s.length;
117        int[] lcp = new int[Math.max(0, n - 1)];
118        int h = 0;
119        for (int i = 0; i < n; i++) {
120            if (rank[i] > 0) {
121                int j = sa[rank[i] - 1];
122                while (i + h < n && j + h < n && s[i + h] == s[j + h]) {
123                    h++;
124                }
125                lcp[rank[i] - 1] = h;
126                if (h > 0) {
127                    h--;
128                }
129            }
130        }
131        return lcp;
132    }
133}