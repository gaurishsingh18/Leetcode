// Last updated: 07/11/2026, 19:12:51
1import java.util.Arrays;
2
3class Solution {
4    public int threeSumClosest(int[] nums, int target) {
5        Arrays.sort(nums);
6        int closestSum = nums[0] + nums[1] + nums[2];
7        
8        for (int i = 0; i < nums.length - 2; i++) {
9            int left = i + 1;
10            int right = nums.length - 1;
11            
12            while (left < right) {
13                int currentSum = nums[i] + nums[left] + nums[right];
14                
15                if (currentSum == target) {
16                    return currentSum;
17                }
18                
19                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
20                    closestSum = currentSum;
21                }
22                
23                if (currentSum < target) {
24                    left++;
25                } else {
26                    right--;
27                }
28            }
29        }
30        return closestSum;
31    }
32}