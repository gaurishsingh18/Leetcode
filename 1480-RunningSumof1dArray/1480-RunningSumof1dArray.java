// Last updated: 01/07/2026, 21:21:03
1class Solution {
2    public int[] runningSum(int[] nums) {
3        for (int i=1; i< nums.length; i++) {
4            nums[i] = nums[i] + nums[i - 1 ];
5        } 
6        return nums;
7    }
8}