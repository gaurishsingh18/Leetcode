// Last updated: 18/07/2026, 23:43:37
1class Solution {
2    public int findGCD(int[] nums) {
3        int min = nums[0];
4        int max = nums[0];
5        for (int num : nums) {
6            if (num < min) min = num;
7            if (num > max) max = num;
8        }
9        while (max != 0) {
10            int temp = max;
11            max = min % max;
12            min = temp;
13        }
14        return min;
15    }
16}