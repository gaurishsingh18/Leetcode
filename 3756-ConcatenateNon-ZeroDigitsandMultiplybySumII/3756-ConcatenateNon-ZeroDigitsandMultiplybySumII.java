// Last updated: 08/07/2026, 20:36:15
1class Solution {
2    static final int MOD = 1_000_000_007;
3    public int[] sumAndMultiply(String s, int[][] queries) {
4        int n = s.length();
5        int[] pos = new int[n];
6        int[] digit = new int[n];
7        int cnt = 0;
8        for (int i = 0; i < n; i++) {
9            int d = s.charAt(i) - '0' ;
10            if (d != 0) {
11                pos[cnt] = i;
12                digit[cnt] = d;
13                cnt++;
14            }
15        }
16        long[] pref = new long[cnt + 1];
17        long[] sumPref = new long[cnt + 1];
18        long[] pow10 = new long[cnt + 1];
19
20        pow10[0] = 1;
21        for (int i = 1; i <= cnt; i++) {
22            pow10[i] = (pow10[i - 1] * 10) % MOD;
23        }
24        for (int i = 0; i < cnt; i++) {
25            pref[i + 1] = (pref[i] * 10 + digit[i]) % MOD;
26            sumPref[i + 1] = sumPref[i] + digit[i];
27        }
28        int[] ans = new int[queries.length];
29
30        for (int i = 0; i < queries.length; i++) {
31            int l = queries[i][0];
32            int r = queries[i][1];
33
34            int left = lowerBound(pos, cnt, l);
35            int right = upperBound(pos,cnt, r) - 1;
36
37            if (left > right) {
38                ans[i] = 0;
39                continue;
40            }
41            int len = right - left + 1;
42
43            long x = (pref[right + 1] - (pref[left] * pow10[len]) % MOD + MOD) % MOD;
44
45            long sum = sumPref[right + 1] - sumPref[left];
46
47            ans[i] = (int) ((x * (sum % MOD)) % MOD);
48        }
49        return ans;
50    }
51   private int lowerBound(int[] arr, int size, int target) {
52    int l = 0, r = size;
53
54    while (l < r) {
55        int mid = l + (r - l) / 2;
56
57        if (arr[mid] < target)
58            l = mid + 1;
59        else
60            r = mid;
61    }
62
63    return l;
64}
65
66private int upperBound(int[] arr, int size, int target) {
67    int l = 0, r = size;
68
69    while (l < r) {
70        int mid = l + (r - l) / 2;
71
72        if (arr[mid] <= target)
73            l = mid + 1;
74        else
75            r = mid;
76    }
77
78    return l;
79}
80}