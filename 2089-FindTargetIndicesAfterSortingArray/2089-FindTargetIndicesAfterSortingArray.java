// Last updated: 19/10/2026, 17:58:43
1class Solution {
2    public List<Integer> targetIndices(int[] nums, int target) {
3        int lessThanTarget = 0;
4        int targetCount = 0;
5        for (int num : nums) {
6            if (num < target) {
7                lessThanTarget++;
8            } else if (num == target) {
9                targetCount++;
10            }
11        }
12        List<Integer> result = new ArrayList<>();
13        for (int i = 0; i < targetCount; i++) {
14            result.add(lessThanTarget + i);
15        }
16        return result;
17    }
18}