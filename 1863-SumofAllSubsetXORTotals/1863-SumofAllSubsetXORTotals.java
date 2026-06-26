// Last updated: 26/06/2026, 14:16:44
1class Solution {
2    int sum = 0;
3    public int subsetXORSum(int[] nums) {
4        solve(nums, 0, 0);
5        return sum;
6    }
7    public void solve(int[] nums, int index, int xor) {
8        if (index == nums.length) {
9            sum += xor;
10            return;
11        }
12        solve(nums, index + 1, xor ^ nums[index]);
13        solve(nums, index + 1, xor);
14    }
15}