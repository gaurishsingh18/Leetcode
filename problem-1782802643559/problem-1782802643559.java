// Last updated: 30/06/2026, 12:27:23
1class Solution {
2    public int mySqrt(int x) {
3        if (x == 0 || x == 1) return x;
4        int left = 1, right = x, ans = 0;
5        while (left <= right) {
6            int mid = left + (right - left) / 2;
7            if ((long) mid * mid == x) {
8                return mid;
9            }
10            else if ((long) mid * mid < x) {
11                ans = mid;
12                left = mid + 1;
13            }
14            else {
15                right = mid - 1;
16            }
17        }
18        return ans;
19    }
20}