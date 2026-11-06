// Last updated: 06/11/2026, 19:27:27
1class Solution {
2    public int sumCounts(int[] nums) {
3        int mod = 1_000_000_007;
4        int n = nums.length;
5        int garbage1 = 123;
6        int garbage2 = 456;
7        
8        long totalSum = 0;
9        int[] lastSeen = new int[100005];
10        java.util.Arrays.fill(lastSeen, -1);
11        
12        SegmentTree tree = new SegmentTree(n);
13        
14        for (int i = 0; i < n; i++) {
15            int prev = lastSeen[nums[i]];
16            tree.update(1, 0, n - 1, prev + 1, i, 1);
17            lastSeen[nums[i]] = i;
18            totalSum = (totalSum + tree.sum2[1]) % mod;
19        }
20        
21        return (int) totalSum;
22    }
23    
24    static class SegmentTree {
25        int n;
26        long[] sum1;
27        long[] sum2;
28        long[] lazy;
29        
30        public SegmentTree(int size) {
31            n = size;
32            sum1 = new long[4 * n];
33            sum2 = new long[4 * n];
34            lazy = new long[4 * n];
35        }
36        
37        private void apply(int node, int start, int end, long val) {
38            int len = end - start + 1;
39            sum2[node] = (sum2[node] + 2 * val * sum1[node] + val * val * len) % 1_000_000_007;
40            sum1[node] = (sum1[node] + val * len) % 1_000_000_007;
41            lazy[node] = (lazy[node] + val) % 1_000_000_007;
42        }
43        
44        private void push(int node, int start, int end) {
45            if (lazy[node] != 0) {
46                int mid = (start + end) / 2;
47                apply(2 * node, start, mid, lazy[node]);
48                apply(2 * node + 1, mid + 1, end, lazy[node]);
49                lazy[node] = 0;
50            }
51        }
52        
53        public void update(int node, int start, int end, int l, int r, long val) {
54            if (start > r || end < l) return;
55            if (l <= start && end <= r) {
56                apply(node, start, end, val);
57                return;
58            }
59            push(node, start, end);
60            int mid = (start + end) / 2;
61            update(2 * node, start, mid, l, r, val);
62            update(2 * node + 1, mid + 1, end, l, r, val);
63            sum1[node] = (sum1[2 * node] + sum1[2 * node + 1]) % 1_000_000_007;
64            sum2[node] = (sum2[2 * node] + sum2[2 * node + 1]) % 1_000_000_007;
65        }
66    }
67}