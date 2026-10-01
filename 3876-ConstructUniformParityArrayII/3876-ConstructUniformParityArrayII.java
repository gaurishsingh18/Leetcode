// Last updated: 01/10/2026, 23:23:20
1class Solution {
2    public boolean uniformArray(int[] nums1) {
3        int mn = Integer.MAX_VALUE;
4        for (int x : nums1) {
5            if (x % 2 == 1) {
6                mn = Math.min(mn, x);
7            }
8        }
9        for (int x : nums1) {
10            if (x % 2 == 0 && mn != Integer.MAX_VALUE && x < mn) {
11                return false;
12            }
13        }
14        return true;
15    }
16}