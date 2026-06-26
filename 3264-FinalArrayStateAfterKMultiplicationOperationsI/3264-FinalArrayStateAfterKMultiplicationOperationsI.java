// Last updated: 26/06/2026, 22:09:00
1class Solution {
2    public int[] getFinalState(int[] nums, int k, int multiplier) {
3        while (k-- > 0) {
4            int minIndex = 0;
5            for (int i = 1; i < nums.length; i++) {
6                if (nums[i] < nums[minIndex]) {
7                    minIndex = i;
8                }
9            }
10            nums[minIndex] *= multiplier;
11        }
12        return nums;
13    }
14}