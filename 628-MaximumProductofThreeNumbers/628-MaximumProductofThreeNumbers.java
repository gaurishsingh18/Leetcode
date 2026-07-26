// Last updated: 26/07/2026, 22:41:52
1class Solution {
2    public int maximumProduct(int[] nums) {
3        Arrays.sort(nums);
4        int n = nums.length;
5        return Math.max(
6            nums[n -1] * nums[n - 2] * nums[n - 3],
7            nums[0] * nums[1] * nums[n - 1]
8        );
9    }
10}