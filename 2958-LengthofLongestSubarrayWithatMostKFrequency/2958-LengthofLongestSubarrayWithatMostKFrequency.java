// Last updated: 12/08/2026, 21:38:37
1class Solution {
2    public int maxSubarrayLength(int[] nums, int k) {
3        Map<Integer, Integer> freq = new HashMap<>();
4        int left = 0;
5        int maxLen = 0;
6        for (int right = 0; right < nums.length; right++) {
7            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
8            while (freq.get(nums[right]) > k) {
9                freq.put(nums[left], freq.get(nums[left]) - 1);
10                left++;
11            }
12            maxLen = Math.max(maxLen, right - left + 1);
13        }
14        return maxLen;
15    }
16}