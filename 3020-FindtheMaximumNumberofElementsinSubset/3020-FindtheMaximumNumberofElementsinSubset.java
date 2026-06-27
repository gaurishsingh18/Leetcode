// Last updated: 27/06/2026, 22:38:01
1import java.util.*;
2
3class Solution {
4    public int maximumLength(int[] nums) {
5        HashMap<Long, Integer> map = new HashMap<>();
6        for (int num : nums) {
7            map.put((long) num, map.getOrDefault((long) num, 0) + 1);
8        }
9        int ans = 1;
10        if (map.containsKey(1L)) {
11            int count = map.get(1L);
12            if (count % 2 == 0)
13                ans = Math.max(ans, count - 1);
14            else
15                ans = Math.max(ans, count);
16        }
17        for (long num : map.keySet()) {
18            if (num == 1) continue;
19            long curr = num;
20            int len = 0;
21            while (map.containsKey(curr) && map.get(curr) >= 2) {
22                len += 2;
23                curr = curr * curr;
24            }
25            if (map.containsKey(curr)) {
26                len += 1;
27            } else {
28                len -= 1;
29            }
30            ans = Math.max(ans, len);
31        }
32        return ans;
33    }
34}