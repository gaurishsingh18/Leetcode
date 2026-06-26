// Last updated: 26/06/2026, 22:11:41
1class Solution {
2    public int countPartitions(int[] nums) {
3        int sum = 0;
4        for (int num : nums) {
5            sum += num;
6        }
7        if (sum % 2 != 0) {
8            return 0;
9        }
10        return nums.length - 1;
11    }
12}