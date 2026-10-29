// Last updated: 29/10/2026, 23:10:46
1import java.util.*;
2
3class Solution {
4    private List<List<Integer>> adj;
5    private int[] head, parent, depth, heavy, pos, size;
6    private int timer;
7    private int[] treeBit;
8    private int n;
9    private char[] charArr;
10
11    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
12        this.n = n;
13        this.charArr = s.toCharArray();
14        adj = new ArrayList<>();
15        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
16        for (int[] e : edges) {
17            adj.get(e[0]).add(e[1]);
18            adj.get(e[1]).add(e[0]);
19        }
20
21        head = new int[n];
22        parent = new int[n];
23        depth = new int[n];
24        heavy = new int[n];
25        pos = new int[n];
26        size = new int[n];
27        treeBit = new int[4 * n];
28        timer = 0;
29
30        dfs1(0, -1, 0);
31        dfs2(0, 0);
32
33        for (int i = 0; i < n; i++) {
34            updatePoint(1, 0, n - 1, pos[i], 1 << (charArr[i] - 'a'));
35        }
36
37        List<Boolean> ans = new ArrayList<>();
38        for (String q : queries) {
39            String[] parts = q.split(" ");
40            if (parts[0].equals("update")) {
41                int u = Integer.parseInt(parts[1]);
42                char c = parts[2].charAt(0);
43                charArr[u] = c;
44                updatePoint(1, 0, n - 1, pos[u], 1 << (c - 'a'));
45            } else {
46                int u = Integer.parseInt(parts[1]);
47                int v = Integer.parseInt(parts[2]);
48                int pathMask = queryPath(u, v);
49                ans.add(Integer.bitCount(pathMask) <= 1);
50            }
51        }
52        return ans;
53    }
54
55    private void dfs1(int u, int p, int d) {
56        parent[u] = p;
57        depth[u] = d;
58        heavy[u] = -1;
59        size[u] = 1;
60        int maxSub = 0;
61        for (int v : adj.get(u)) {
62            if (v != p) {
63                dfs1(v, u, d + 1);
64                size[u] += size[v];
65                if (size[v] > maxSub) {
66                    maxSub = size[v];
67                    heavy[u] = v;
68                }
69            }
70        }
71    }
72
73    private void dfs2(int u, int h) {
74        head[u] = h;
75        pos[u] = timer++;
76        if (heavy[u] != -1) {
77            dfs2(heavy[u], h);
78        }
79        for (int v : adj.get(u)) {
80            if (v != parent[u] && v != heavy[u]) {
81                dfs2(v, v);
82            }
83        }
84    }
85
86    private void updatePoint(int node, int l, int r, int idx, int val) {
87        if (l == r) {
88            treeBit[node] = val;
89            return;
90        }
91        int mid = (l + r) / 2;
92        if (idx <= mid) updatePoint(2 * node, l, mid, idx, val);
93        else updatePoint(2 * node + 1, mid + 1, r, idx, val);
94        treeBit[node] = treeBit[2 * node] ^ treeBit[2 * node + 1];
95    }
96
97    private int queryPath(int u, int v) {
98        int res = 0;
99        while (head[u] != head[v]) {
100            if (depth[head[u]] > depth[head[v]]) {
101                int temp = u;
102                u = v;
103                v = temp;
104            }
105            res ^= querySegment(1, 0, n - 1, pos[head[v]], pos[v]);
106            v = parent[head[v]];
107        }
108        if (depth[u] > depth[v]) {
109            int temp = u;
110            u = v;
111            v = temp;
112        }
113        res ^= querySegment(1, 0, n - 1, pos[u], pos[v]);
114        return res;
115    }
116
117    private int querySegment(int node, int l, int r, int ql, int qr) {
118        if (ql > r || qr < l) return 0;
119        if (ql <= l && r <= qr) return treeBit[node];
120        int mid = (l + r) / 2;
121        return querySegment(2 * node, l, mid, ql, qr) ^ querySegment(2 * node + 1, mid + 1, r, ql, qr);
122    }
123}