// Last updated: 15/08/2026, 14:37:30
1class Solution {
2    public int longestSubsequence(int[] nums) {
3        int xor = 0;
4        boolean hasNonZero = false;
5        for (int num : nums) {
6            xor ^= num;
7            if (num != 0) {
8                hasNonZero = true;
9            }
10        }
11        if (xor != 0) {
12            return nums.length;
13        }
14        if (hasNonZero) {
15            return nums.length - 1;
16        }
17        return 0;
18    }
19}