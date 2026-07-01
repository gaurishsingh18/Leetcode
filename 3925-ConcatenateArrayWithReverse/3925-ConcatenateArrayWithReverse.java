// Last updated: 01/07/2026, 21:04:36
1class Solution {
2    public int[] concatWithReverse(int[] nums) {
3        int n = nums.length;
4        int[] ans = new int[2*n];
5        for(int i = 0; i<n; i++){
6            ans[i] = nums[i];
7            ans[i + n] = nums[n-i-1];
8        }
9        return ans;
10    }
11}