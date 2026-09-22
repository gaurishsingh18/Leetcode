// Last updated: 22/09/2026, 23:07:29
1class Solution {
2    private static class Node {
3        int[] remain;
4        int prod;
5
6        Node(int k) {
7            remain = new int[k];
8            prod = 1;
9        }
10    }
11    private int k;
12    private Node[] tree;
13    public int[] resultArray(int[] nums, int k, int[][] queries) {
14        this.k = k;
15        int n = nums.length;
16        for (int i = 0; i < n; i++) {
17            nums[i] %= k;
18        }
19        for (int i = 0; i < queries.length; i++) {
20            queries[i][1] %= k;
21        }
22        tree = new Node[4 * n];
23        for (int i = 0; i < 4 * n; i++) {
24            tree[i] = new Node(k);
25        }
26        build(nums, 0, 0, n - 1);
27        int[] ans = new int[queries.length];
28        for (int i = 0; i < queries.length; i++) {
29            int index = queries[i][0];
30            int value = queries[i][1];
31            int start = queries[i][2];
32            int x = queries[i][3];
33            update(0, 0, n - 1, index, value);
34            Node res = query(0, 0, n - 1, start, n - 1);
35            ans[i] = res.remain[x];
36        }
37
38        return ans;
39    }
40    private void build(int[] nums, int cur, int left, int right) {
41        if (left == right) {
42            tree[cur].prod = nums[left];
43            for (int i = 0; i < k; i++) {
44                tree[cur].remain[i] = 0;
45            }
46            tree[cur].remain[nums[left]] = 1;
47            return;
48        }
49        int mid = (left + right) / 2;
50        build(nums, 2 * cur + 1, left, mid);
51        build(nums, 2 * cur + 2, mid + 1, right);
52        merge(tree[cur], tree[2 * cur + 1], tree[2 * cur + 2]);
53    }
54    private void update(int treeIndex, int lo, int hi, int i, int val) {
55        if (lo == hi) {
56            tree[treeIndex].prod = val;
57            for (int j = 0; j < k; j++) {
58                tree[treeIndex].remain[j] = 0;
59            }
60            tree[treeIndex].remain[val] = 1;
61            return;
62        }
63        int mid = (lo + hi) / 2;
64        if (i <= mid) {
65            update(2 * treeIndex + 1, lo, mid, i, val);
66        } else {
67            update(2 * treeIndex + 2, mid + 1, hi, i, val);
68        }
69        merge(tree[treeIndex], tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
70    }
71    private Node query(int treeIndex, int lo, int hi, int i, int j) {
72        if (i <= lo && hi <= j) {
73            return tree[treeIndex];
74        }
75        int mid = (lo + hi) / 2;
76        if (j <= mid) {
77            return query(2 * treeIndex + 1, lo, mid, i, j);
78        } else if (i > mid) {
79            return query(2 * treeIndex + 2, mid + 1, hi, i, j);
80        } else {
81            Node leftNode = query(2 * treeIndex + 1, lo, mid, i, j);
82            Node rightNode = query(2 * treeIndex + 2, mid + 1, hi, i, j);
83            Node res = new Node(k);
84            merge(res, leftNode, rightNode);
85            return res;
86        }
87    }
88    private void merge(Node parent, Node left, Node right) {
89        parent.prod = (left.prod * right.prod) % k;
90        for (int i = 0; i < k; i++) {
91            parent.remain[i] = left.remain[i];
92        }
93        for (int i = 0; i < k; i++) {
94            parent.remain[(i * left.prod) % k] += right.remain[i];
95        }
96    }
97}