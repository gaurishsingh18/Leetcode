// Last updated: 01/11/2026, 13:44:12
1class Solution {
2    public int minMoves(int[] nums) {
3        int min = nums[0];
4        for (int i = 1; i < nums.length; i++) {
5            if (nums[i] < min) {
6                min = nums[i];
7            }
8        }
9        
10        int moves = 0;
11        for (int i = 0; i < nums.length; i++) {
12            moves += nums[i] - min;
13        }
14        
15        return moves;
16    }
17}