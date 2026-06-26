// Last updated: 26/06/2026, 13:28:35
1import java.util.*;
2class Solution {
3    class Fenwick {
4        long[] bit;
5        int n;
6        Fenwick(int n) {
7            this.n = n;
8            bit = new long[n + 1];
9        }
10        void update(int i, int val) {
11            while (i <= n) {
12                bit[i] += val;
13                i += i & -i;
14            }
15        }
16        long query(int i) {
17            long sum = 0;
18            while (i > 0) {
19                sum += bit[i];
20                i -= i & -i;
21            }
22            return sum;
23        }
24    }
25    public long countMajoritySubarrays(int[] nums, int target) {
26        int n = nums.length;
27        long[] prefix = new long[n + 1];
28        for (int i = 0; i < n; i++) {
29            int val = (nums[i] == target) ? 1 : -1;
30            prefix[i + 1] = prefix[i] + val;
31        }
32        long[] sorted = prefix.clone();
33        Arrays.sort(sorted);
34        Map<Long, Integer> map = new HashMap<>();
35        int idx = 1;
36        for (long x : sorted) {
37            if (!map.containsKey(x)) {
38                map.put(x, idx++);
39            }
40        }
41        Fenwick ft = new Fenwick(idx);
42        long ans = 0;
43        ft.update(map.get(0L), 1);
44        for (int i = 1; i <= n; i++) {
45            int pos = map.get(prefix[i]);
46            ans += ft.query(pos - 1);
47            ft.update(pos, 1);
48        }
49        return ans;
50    }
51}