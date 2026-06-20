// Last updated: 20/06/2026, 23:50:22
1class Solution {
2    public int mirrorDistance(int n) {
3        int original = n;
4        int reverse = 0;
5        while (n>0) {
6            int digit = n % 10;
7            reverse = reverse * 10 + digit;
8            n = n/10;
9        }
10        return Math.abs(original - reverse);
11        
12    }
13}