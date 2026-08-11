// Last updated: 11/08/2026, 13:09:36
1class Solution {
2    public int missingInteger(int[] nums) {
3        int n = nums.length;
4        int sum = nums[0];
5        for (int i = 1; i < n; i++) {
6            if (nums[i] == nums[i - 1] + 1) {
7                sum += nums[i];
8            } else {
9                break;
10            }
11        }
12        HashSet<Integer> set = new HashSet<>();
13        for (int num : nums) {
14            set.add(num);
15        }
16        int x = sum;
17        while (set.contains(x)) {
18            x++;
19        }
20        return x;
21    }
22}