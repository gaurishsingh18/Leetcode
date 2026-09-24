// Last updated: 24/09/2026, 22:29:04
1class Solution {
2    public int smallestIndex(int[] nums) {
3        for (int i = 0; i < nums.length; i++) {
4            int sum = 0;
5            int temp = nums[i];
6            while (temp > 0) {
7                sum += temp % 10;
8                temp /= 10;
9            }
10            if (nums[i] == 0) {
11                sum = 0;
12            }
13            if (sum == i) {
14                return i;
15            }
16        }
17        return -1;
18    }
19}