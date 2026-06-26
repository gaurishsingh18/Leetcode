// Last updated: 26/06/2026, 14:19:22
1class Solution {
2    public int[] getSneakyNumbers(int[] nums) {
3        int[] freq = new int[101];
4        int[] ans = new int[2];
5        int index = 0;
6        for (int num : nums) {
7            freq[num]++;
8            if (freq[num] == 2) {
9                ans[index++] = num;
10            }
11        }
12        return ans;
13    }
14}