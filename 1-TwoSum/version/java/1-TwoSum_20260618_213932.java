// Last updated: 18/06/2026, 21:39:32
1class Solution {
2    public int[] twoSum(int[] nums, int target) {
3        Map<Integer, Integer> seen = new HashMap<>();
4        for (int i = 0; i < nums.length; i++) {
5            int complement = target - nums[i];
6            if (seen.containsKey(complement)) {
7                return new int[] { seen.get(complement), i };
8            }
9            seen.put(nums[i], i);
10        }
11        return new int[] {};
12    }
13}