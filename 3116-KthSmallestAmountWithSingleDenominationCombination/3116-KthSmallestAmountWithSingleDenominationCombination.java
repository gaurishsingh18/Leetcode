// Last updated: 21/08/2026, 20:50:07
1class Solution {
2    public long findKthSmallest(int[] coins, int k) {
3        int n = coins.length;
4        long left = 1, right = (long) 1e18;
5        long ans = 0;
6        while (left <= right) {
7            long mid = left + (right - left) / 2;
8            if (count(mid, coins) >= k) {
9                ans = mid;
10                right = mid - 1;
11            } else {
12                left = mid + 1;
13            }
14        }
15        return ans;
16    }
17    private long count(long x, int[] coins) {
18        int n = coins.length;
19        long res = 0;
20        for (int mask = 1; mask < (1 << n); mask++) {
21            long lcm = 1;
22            int bits = 0;
23            boolean overflow = false;
24            for (int i = 0; i < n; i++) {
25                if ((mask & (1 << i)) != 0) {
26                    bits++;
27                    lcm = lcm(lcm, coins[i]);
28                    if (lcm > x || lcm == 0) {
29                        overflow = true;
30                        break;
31                    }
32                }
33            }
34            if (overflow) continue;
35            long cnt = x / lcm;
36            if (bits % 2 == 1) res += cnt;
37            else res -= cnt;
38        }
39        return res;
40    }
41    private long lcm(long a, long b) {
42        return a / gcd(a, b) * b;
43    }
44    private long gcd(long a, long b) {
45        while (b != 0) {
46            long temp = a % b;
47            a = b;
48            b = temp;
49        }
50        return a;
51    }
52}