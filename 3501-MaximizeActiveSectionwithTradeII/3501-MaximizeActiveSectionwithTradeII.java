// Last updated: 22/07/2026, 20:22:04
1class Solution {
2    static int[][] sparseTriple;
3    static int[] logTable;
4
5    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
6        int n = s.length();
7        char[] c = s.toCharArray();
8
9        int totalOnes = 0;
10        for (int i = 0; i < n; i++) if (c[i] == '1') totalOnes++;
11
12        List<int[]> runs = new ArrayList<>();
13        int i = 0;
14        while (i < n) {
15            int j = i;
16            while (j < n && c[j] == c[i]) j++;
17            runs.add(new int[]{i, j - 1, c[i] == '1' ? 1 : 0});
18            i = j;
19        }
20        int m = runs.size();
21        int[] runStart = new int[m], runEnd = new int[m], runType = new int[m];
22        for (int k = 0; k < m; k++) {
23            runStart[k] = runs.get(k)[0];
24            runEnd[k] = runs.get(k)[1];
25            runType[k] = runs.get(k)[2];
26        }
27
28        buildSparse(runStart, runEnd, runType, m);
29
30        int Q = queries.length;
31        List<Integer> ans = new ArrayList<>(Collections.nCopies(Q, 0));
32
33        for (int qi = 0; qi < Q; qi++) {
34            int l = queries[qi][0], r = queries[qi][1];
35
36            int li = findRun(runStart, l);
37            int ri = findRun(runStart, r);
38
39            int bestGain = computeBestGain(l, r, li, ri, runStart, runEnd, runType, m);
40
41            ans.set(qi, totalOnes + bestGain);
42        }
43
44        return ans;
45    }
46
47    private int findRun(int[] runStart, int pos) {
48        int lo = 0, hi = runStart.length - 1;
49        while (lo < hi) {
50            int mid = (lo + hi + 1) / 2;
51            if (runStart[mid] <= pos) lo = mid;
52            else hi = mid - 1;
53        }
54        return lo;
55    }
56
57    // Only valid move: zero an interior 1-run (bounded by 0s on both sides,
58    // strictly inside (l,r)) then flip the merged zero region to 1.
59    // Net gain = leftZeroLen + rightZeroLen (the zeroed 1s get restored).
60    private int computeBestGain(int l, int r, int li, int ri, int[] runStart, int[] runEnd, int[] runType, int m) {
61        if (li >= ri) return 0;
62
63        int bestGain = 0;
64        int lo = li + 1, hi = ri - 1;
65        if (lo > hi) return 0;
66
67        if (runType[lo] == 1 && lo - 1 >= 0 && lo + 1 < m && runType[lo - 1] == 0 && runType[lo + 1] == 0) {
68            int leftLen = (lo - 1 == li) ? (runEnd[li] - l + 1) : (runEnd[lo - 1] - runStart[lo - 1] + 1);
69            int rightLen = (lo + 1 == ri) ? (r - runStart[ri] + 1) : (runEnd[lo + 1] - runStart[lo + 1] + 1);
70            bestGain = Math.max(bestGain, leftLen + rightLen);
71        }
72
73        if (hi != lo && runType[hi] == 1 && hi - 1 >= 0 && hi + 1 < m && runType[hi - 1] == 0 && runType[hi + 1] == 0) {
74            int leftLen = (hi - 1 == li) ? (runEnd[li] - l + 1) : (runEnd[hi - 1] - runStart[hi - 1] + 1);
75            int rightLen = (hi + 1 == ri) ? (r - runStart[ri] + 1) : (runEnd[hi + 1] - runStart[hi + 1] + 1);
76            bestGain = Math.max(bestGain, leftLen + rightLen);
77        }
78
79        if (li + 2 <= ri - 2) {
80            int maxTriple = queryMaxTriple(li + 2, ri - 2);
81            bestGain = Math.max(bestGain, maxTriple);
82        }
83
84        return bestGain;
85    }
86
87    private void buildSparse(int[] runStart, int[] runEnd, int[] runType, int m) {
88        logTable = new int[m + 1];
89        for (int i = 2; i <= m; i++) logTable[i] = logTable[i / 2] + 1;
90        int LOG = Math.max(1, logTable[m] + 1);
91
92        int[] tripleArr = new int[m];
93        for (int k = 0; k < m; k++) {
94            if (runType[k] == 1 && k - 1 >= 0 && k + 1 < m && runType[k - 1] == 0 && runType[k + 1] == 0) {
95                tripleArr[k] = (runEnd[k - 1] - runStart[k - 1] + 1) + (runEnd[k + 1] - runStart[k + 1] + 1);
96            } else {
97                tripleArr[k] = 0;
98            }
99        }
100        sparseTriple = new int[LOG][m];
101        for (int i = 0; i < m; i++) sparseTriple[0][i] = tripleArr[i];
102        for (int j = 1; j < LOG; j++) {
103            for (int i = 0; i + (1 << j) <= m; i++) {
104                sparseTriple[j][i] = Math.max(sparseTriple[j - 1][i], sparseTriple[j - 1][i + (1 << (j - 1))]);
105            }
106        }
107    }
108
109    private int queryMaxTriple(int lo, int hi) {
110        int len = hi - lo + 1;
111        int j = logTable[len];
112        return Math.max(sparseTriple[j][lo], sparseTriple[j][hi - (1 << j) + 1]);
113    }
114}