// Last updated: 03/07/2026, 21:31:06
1class Solution {
2    public int firstMissingPositive(int[] nums) {
3        int n = nums.length;
4
5        for (int i = 0; i < n; i++) {
6            while (
7                nums[i]> 0 &&
8                nums[i]<= n &&
9                nums[nums[i] - 1] != nums[i]
10            ){
11                int temp = nums[i];
12            nums[i] = nums[temp - 1];
13            nums[temp - 1] = temp;
14            }
15        }
16        for (int i = 0; i < n; i++) {
17            if (nums[i] != i + 1) {
18                return i + 1;
19            }
20        }
21        return n + 1;
22    }
23}