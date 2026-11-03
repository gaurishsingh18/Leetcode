// Last updated: 03/11/2026, 09:45:05
1class Solution {
2    public int minMoves(int[] nums) {
3        int max = nums[0];
4        for (int num : nums) {
5            if (num > max) {
6                max = num;
7            }
8        }
9        int moves = 0;
10        for (int num : nums) {
11            moves += max - num;
12        }
13        return moves;
14    }
15}