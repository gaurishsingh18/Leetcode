// Last updated: 30/06/2026, 00:00:08
1class Solution {
2    public int searchInsert(int[] nums, int target) {
3        int low = 0, high = nums.length - 1;
4        
5        while (low <= high) {
6            int mid = (low + high) / 2;
7            if (nums[mid] == target)
8                return mid;
9            else if (nums[mid] < target)
10                low = mid + 1;
11            else
12                high = mid - 1;
13        }
14        return low;   // insert position
15    }
16}