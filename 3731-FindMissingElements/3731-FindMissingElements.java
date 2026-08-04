// Last updated: 04/08/2026, 21:02:14
1import java.util.*;
2class Solution {
3    public List<Integer> findMissingElements(int[] nums) {
4        int min = nums[0], max = nums[0];
5        HashSet<Integer> set = new HashSet<>();
6        for (int num : nums) {
7            set.add(num);
8            min = Math.min(min, num);
9            max = Math.max(max, num);
10        }
11        List<Integer> ans = new ArrayList<>();
12        for (int i = min; i <= max; i++) {
13            if (!set.contains(i)) {
14                ans.add(i);
15            }
16        }
17        return ans;
18    }
19}