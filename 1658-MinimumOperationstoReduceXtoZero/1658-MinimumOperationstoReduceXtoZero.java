// Last updated: 23/09/2026, 21:00:39
1class Solution {
2    public int minOperations(int[] nums, int x) {
3        long totalSum = 0;
4        for (int num : nums) {
5            totalSum += num;
6        }
7        long target = totalSum - x;
8        if (target < 0) return -1;
9        if (target == 0) return nums.length;
10        
11        int n = nums.length;
12        int maxLen = -1;
13        long currentSum = 0;
14        int left = 0;
15        
16        for (int right = 0; right < n; right++) {
17            currentSum += nums[right];
18            while (currentSum > target && left <= right) {
19                currentSum -= nums[left];
20                left++;
21            }
22            if (currentSum == target) {
23                maxLen = Math.max(maxLen, right - left + 1);
24            }
25        }
26        
27        return maxLen == -1 ? -1 : n - maxLen;
28    }
29}