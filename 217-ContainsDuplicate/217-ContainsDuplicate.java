// Last updated: 04/07/2026, 20:51:15
1class Solution {
2    public boolean containsDuplicate(int[] nums) {
3        HashSet<Integer> set = new HashSet<>();
4        for (int num : nums) {
5            if (set.contains(num)) {
6                return true;
7            }
8            set.add(num);
9        }
10        return false;
11    }
12}