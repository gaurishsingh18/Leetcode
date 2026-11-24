// Last updated: 24/11/2026, 21:25:06
1class Solution {
2    public int maxLength(int[] nums) {
3        int n = nums.length;
4        int ans = 0;
5        for (int i = 0; i < n; i++) {
6            long prod = 1;
7            long gcd = 0;
8            long lcm = 1;
9            for (int j = i; j < n; j++) {
10                long val = nums[j];
11                if (prod > Long.MAX_VALUE / val) {
12                    break;
13                }
14                prod *= val;
15                gcd = (j == i) ? val : gcd(gcd, val);
16                lcm = lcm(lcm, val);
17                if (lcm > Long.MAX_VALUE / gcd) {
18                    break;
19                }
20                if (prod == lcm * gcd) {
21                    ans = Math.max(ans, j - i + 1);
22                }
23            }
24        }
25        return ans;
26    }
27    private long gcd(long a, long b) {
28        while (b != 0) {
29            long t = a % b;
30            a = b;
31            b = t;
32        }
33        return a;
34    }
35    private long lcm(long a, long b) {
36        return (a / gcd(a, b)) * b;
37    }
38}