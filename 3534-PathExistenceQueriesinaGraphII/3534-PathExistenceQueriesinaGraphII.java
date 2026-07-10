// Last updated: 10/07/2026, 21:30:12
1class Solution {
2    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
3        int[][] arr = new int[n][2];
4
5        for (int i = 0; i < n; i++) {
6            arr[i][0] = nums[i];
7            arr[i][1] = i;
8        }
9
10        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
11
12        int[] pos = new int[n];
13        for (int i = 0; i < n; i++) {
14            pos[arr[i][1]] = i;
15        }
16
17        int[] comp = new int[n];
18        int cid = 0;
19        for (int i = 1; i < n; i++) {
20            if (arr[i][0] - arr[i - 1][0] > maxDiff) cid++;
21            comp[i] = cid;
22        }
23        int[] reach = new int[n];
24        int r = 0;
25        for (int l = 0; l < n; l++) {
26            while (r + 1 < n && arr[r + 1][0] - arr[l][0] <= maxDiff) {
27                r++;
28            }
29            reach[l] = r;
30        }
31
32        int LOG = 18;
33        int[][] jump = new int[LOG][n];
34
35        for (int i = 0; i < n; i++) jump[0][i] = reach[i];
36
37        for (int k = 1; k < LOG; k++) {
38            for (int i = 0; i < n; i++) {
39                jump[k][i] = jump[k - 1][jump[k - 1][i]];
40            }
41        }
42
43        int[] ans = new int[queries.length];
44
45        for (int qi = 0; qi < queries.length; qi++) {
46            int u = pos[queries[qi][0]];
47            int v = pos[queries[qi][1]];
48
49            if (u == v) {
50                ans[qi] = 0;
51                continue;
52            }
53
54            if (u > v) {
55                int t = u;
56                u = v;
57                v = t;
58            }
59
60            if (comp[u] != comp[v]) {
61                ans[qi] = -1;
62                continue;
63            }
64
65            int cur = u;
66            int steps = 0;
67
68            for (int k = LOG - 1; k >= 0; k--) {
69                if (jump[k][cur] < v) {
70                    steps += (1 << k);
71                    cur = jump[k][cur];
72                }
73            }
74
75            ans[qi] = steps + 1;
76        }
77
78        return ans;
79    }
80}