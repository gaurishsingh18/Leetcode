// Last updated: 25/08/2026, 21:54:12
1class Solution {
2    public int missingMultiple(int[] nums, int k) {
3        Set<Integer> set = new HashSet<>();
4        for (int num : nums) {
5            set.add(num);
6        }
7        int multiple = k;
8        while (true) {
9            if (!set.contains(multiple)) {
10                return multiple;
11            }
12            multiple += k;
13        }
14    }
15}