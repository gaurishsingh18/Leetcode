// Last updated: 12/07/2026, 15:27:03
1class Solution {
2    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
3        int sum = 0;
4        for (int i = 0; i < nums.size(); i++) {
5            if (Integer.bitCount(i) == k) {
6                sum += nums.get(i);
7            }
8        }
9        return sum;
10    }
11}