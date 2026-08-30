// Last updated: 30/08/2026, 18:49:21
1class Solution {
2    public int minimumDeletions(int[] nums) {
3        int n = nums.length;
4        int minIndex = 0, maxIndex = 0;
5        for (int i = 0; i < n; i++) {
6            if (nums[i] < nums[minIndex]) minIndex = i;
7            if (nums[i] > nums[maxIndex]) maxIndex = i;
8        }
9        int left = Math.min(minIndex, maxIndex);
10        int right = Math.max(minIndex, maxIndex);
11        int case1 = right + 1;
12        int case2 = n - left;
13        int case3 = (left + 1) + (n - right);
14        return Math.min(case1, Math.min(case2, case3));
15    }
16}