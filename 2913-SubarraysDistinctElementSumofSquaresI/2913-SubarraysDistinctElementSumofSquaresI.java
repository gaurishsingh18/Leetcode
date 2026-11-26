// Last updated: 26/11/2026, 20:53:38
1import java.util.*;
2
3class Solution {
4    public int sumCounts(List<Integer> nums) {
5        int n = nums.size();
6        int ans = 0;
7        for (int i = 0; i < n; i++) {
8            Set<Integer> seen = new HashSet<>();
9            for (int j = i; j < n; j++) {
10                seen.add(nums.get(j));
11                int distinct = seen.size();
12                ans += distinct * distinct;
13            }
14        }
15        return ans;
16    }
17}