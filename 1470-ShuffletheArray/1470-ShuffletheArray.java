// Last updated: 12/07/2026, 15:25:56
1class Solution {
2    public int[] shuffle(int[] nums, int n) {
3        int[] ans = new int[2 * n];
4        int idx = 0;
5        for (int i = 0; i < n; i++) {
6            ans[idx++] = nums[i];
7            ans[idx++] = nums[i + n];
8        }
9        return ans;
10    }
11}