// Last updated: 16/07/2026, 21:42:18
1class Solution {
2    public long gcdSum(int[] nums) {
3        int n = nums.length;
4        int[] prefixGcd = new int[n];
5        int mx = 0;
6        for (int i = 0; i < n; i++) {
7            mx = Math.max(mx, nums[i]);
8            prefixGcd[i] = gcd(nums[i],mx);
9        }
10        java.util.Arrays.sort(prefixGcd);
11        long ans = 0;
12        int l = 0, r = n-1;
13        while(l < r){
14        ans+= gcd(prefixGcd[l], prefixGcd[r]);
15        l++;
16        r--;
17        }
18        return ans;
19    }
20    private int gcd(int a, int b) {
21        while (b != 0) {
22            int t = a % b;
23            a = b;
24            b = t;
25        }
26        return a;
27    }
28}
29