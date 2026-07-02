// Last updated: 02/07/2026, 21:54:40
1class Solution {
2    public void rotate(int[] nums, int k) {
3        int n = nums.length;
4        k = k % n;
5
6        reverse(nums, 0, n - 1);
7        reverse(nums, 0, k - 1);
8        reverse(nums, k, n - 1);
9    }
10
11    private void reverse(int[] nums, int start, int end) {
12        while (start < end) {
13            int temp = nums[start];
14            nums[start] = nums[end];
15            nums[end] = temp;
16            start++;
17            end--;
18        }
19    }
20}