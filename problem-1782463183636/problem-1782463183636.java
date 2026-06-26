// Last updated: 26/06/2026, 14:09:43
1class Solution {
2    public int minimumOperations(int[] nums) {
3        int count = 0;
4        for (int num : nums) {
5            int rem = num % 3;
6            count += Math.min(rem, 3 - rem);
7        }
8        return count;
9    }
10}