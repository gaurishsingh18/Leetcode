// Last updated: 23/10/2026, 22:12:52
1class Solution {
2    public int sortPermutation(int[] nums) {
3        int ans = -1;
4        for (int i = 0; i < nums.length; ++i) {
5            if (i != nums[i]) {
6                ans &= nums[i];
7            }
8        }
9        return Math.max(ans, 0);
10    }
11}