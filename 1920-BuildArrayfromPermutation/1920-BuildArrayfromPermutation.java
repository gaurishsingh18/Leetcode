// Last updated: 07/10/2026, 12:29:37
1class Solution {
2    public int[] buildArray(int[] nums) {
3        int n = nums.length;
4        for (int i = 0; i < n; i++) {
5            nums[i] += (nums[nums[i]] % n) * n;
6        }
7        for (int i = 0; i < n; i++) {
8            nums[i] /= n;
9        }
10        return nums;
11    }
12}