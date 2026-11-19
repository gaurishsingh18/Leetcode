// Last updated: 19/11/2026, 12:48:52
1import java.util.Arrays;
2
3class Solution {
4    public int minimizeSum(int[] nums) {
5        int n = nums.length;
6        if (n <= 3) {
7            return 0;
8        }
9        Arrays.sort(nums);
10        int option1 = nums[n - 3] - nums[0];
11        int option2 = nums[n - 1] - nums[2];
12        int option3 = nums[n - 2] - nums[1];
13        return Math.min(option1, Math.min(option2, option3));
14    }
15}