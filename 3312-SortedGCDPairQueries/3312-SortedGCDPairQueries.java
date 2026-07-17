// Last updated: 17/07/2026, 21:08:54
1class Solution {
2    public int[] gcdValues(int[] nums, long[] queries) {
3        int mx = 0;
4        for (int x : nums) mx = Math.max(mx, x);
5        int[] freq = new int[mx + 1];
6        for (int x : nums) freq[x]++;
7        long[] exact = new long[mx + 1];
8        for (int g = mx; g >= 1; g--) {
9            long cnt = 0;
10            for (int m = g; m <= mx; m += g) {
11                cnt += freq[m];
12            }
13            exact[g] = cnt * (cnt - 1) / 2;
14            for (int m = g + g; m <= mx; m += g) {
15                exact[g] -= exact[m];
16            }
17        }
18        long[] prefix = new long[mx + 1];
19        for (int i = 1; i <= mx; i++) {
20            prefix[i] = prefix[i - 1] + exact[i];
21        }
22        int[] ans = new int[queries.length];
23        for (int i = 0; i < queries.length; i++) {
24            long q = queries[i];
25            int l = 1, r = mx;
26            while (l < r) {
27                int mid = l + (r - l) / 2;
28                if (prefix[mid] > q)
29                    r = mid;
30                else
31                    l = mid + 1;
32            }
33            ans[i] = l;
34        }
35        return ans;
36    }
37}