// Last updated: 02/11/2026, 10:22:40
1import java.util.Arrays;
2
3class Solution {
4    public int minMoves2(int[] nums) {
5        Arrays.sort(nums);
6        int moves = 0;
7        int left = 0;
8        int right = nums.length - 1;
9        while (left < right) {
10            moves += nums[right] - nums[left];
11            left++;
12            right--;
13        }
14        return moves;
15    }
16}