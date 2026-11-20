// Last updated: 20/11/2026, 19:12:26
1class Solution {
2    public int maxSelectedElements(int[] nums) {
3        Arrays.sort(nums);
4        Map<Integer, Integer> dp = new HashMap<>();
5        int ans = 0;
6        for (int x : nums) {
7            int lenPlusOne = dp.getOrDefault(x, 0) + 1;
8            dp.put(x + 1, lenPlusOne);
9            ans = Math.max(ans, lenPlusOne);
10            int lenSame = dp.getOrDefault(x - 1, 0) + 1;
11            dp.put(x, lenSame);
12            ans = Math.max(ans, lenSame);
13        }
14        return ans;
15    }
16}