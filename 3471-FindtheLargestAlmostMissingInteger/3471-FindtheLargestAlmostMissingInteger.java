// Last updated: 18/08/2026, 11:51:04
1class Solution {
2    public int largestInteger(int[] nums, int k) {
3        int n = nums.length;
4        Map<Integer, Integer> count = new HashMap<>();
5        for (int i = 0; i <= n - k; i++) {
6            Set<Integer> set = new HashSet<>();
7            for (int j = i; j < i + k; j++) {
8                set.add(nums[j]);
9            }
10            for (int x : set) {
11                count.put(x, count.getOrDefault(x, 0) + 1);
12            }
13        }
14        int ans = -1;
15        for (int x : count.keySet()) {
16            if (count.get(x) == 1) {
17                ans = Math.max(ans, x);
18            }
19        }
20        return ans;
21    }
22}