// Last updated: 30/06/2026, 00:07:38
1class Solution {
2    public void moveZeroes(int[] nums) {
3        int j = 0;
4        // move non-zero elements forward
5        for (int i = 0; i < nums.length; i++) {
6            if (nums[i] != 0) {
7                nums[j] = nums[i];
8                j++;
9            }
10        }
11        // fill remaining with zeros
12        while (j < nums.length) {
13            nums[j] = 0;
14            j++;
15        }
16    }
17}