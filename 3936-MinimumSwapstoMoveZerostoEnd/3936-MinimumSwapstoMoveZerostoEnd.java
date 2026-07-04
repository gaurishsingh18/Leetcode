// Last updated: 04/07/2026, 20:55:09
1class Solution {
2    public int minimumSwaps(int[] nums) {
3        int n = nums.length;
4        int zeroCount = 0;
5        for(int num : nums) {
6            if (num ==0) {
7                zeroCount++;
8            }
9        }
10        int swaps = 0;
11        for (int i = 0; i < n - zeroCount; i++) {
12            if (nums[i] == 0) {
13                swaps++;
14            }
15        }
16        return swaps;
17    }
18}