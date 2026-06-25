// Last updated: 25/06/2026, 22:13:11
1import java.util.*;
2
3class Solution {
4
5    class Fenwick {
6        int[] bit;
7        int n;
8
9        Fenwick(int n) {
10            this.n = n;
11            bit = new int[n + 2];
12        }
13
14        void update(int i, int val) {
15            while (i <= n) {
16                bit[i] += val;
17                i += i & -i;
18            }
19        }
20
21        int query(int i) {
22            int sum = 0;
23            while (i > 0) {
24                sum += bit[i];
25                i -= i & -i;
26            }
27            return sum;
28        }
29    }
30
31    public int countMajoritySubarrays(int[] nums, int target) {
32        int n = nums.length;
33
34        long[] prefix = new long[n + 1];
35
36        for (int i = 0; i < n; i++) {
37            int val = (nums[i] == target) ? 1 : -1;
38            prefix[i + 1] = prefix[i] + val;
39        }
40
41        // coordinate compression
42        long[] temp = prefix.clone();
43        Arrays.sort(temp);
44
45        Map<Long, Integer> map = new HashMap<>();
46        int idx = 1;
47
48        for (long x : temp) {
49            if (!map.containsKey(x)) {
50                map.put(x, idx++);
51            }
52        }
53
54        Fenwick ft = new Fenwick(idx);
55        long ans = 0;
56
57        // add prefix[0]
58        ft.update(map.get(prefix[0]), 1);
59
60        for (int i = 1; i <= n; i++) {
61            int pos = map.get(prefix[i]);
62
63            // count previous prefix smaller than current
64            ans += ft.query(pos - 1);
65
66            ft.update(pos, 1);
67        }
68
69        return (int) ans;
70    }
71}