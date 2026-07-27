// Last updated: 27/07/2026, 20:18:20
1class Solution {
2    public int maxProduct(int[] nums) {
3        int max1 = 0, max2 = 0;
4
5        for (int num : nums) {
6            if (num > max1) {
7                max2 = max1;
8                max1 = num;
9            } else if (num > max2) {
10                max2 = num;
11            }
12        }
13        return (max1 - 1) * (max2 - 1);
14    }
15}