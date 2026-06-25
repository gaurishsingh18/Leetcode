// Last updated: 25/06/2026, 23:06:13
1import java.util.*;
2class Solution {
3    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
4        int q = queries.length;
5        int[] ans = new int[q];
6        for (int i = 0; i < q; i++) {
7            int k = queries[i][0];
8            int trim = queries[i][1];
9            List<String[]> list = new ArrayList<>();
10            for (int j = 0; j < nums.length; j++) {
11                String s = nums[j];
12                String trimmed = s.substring(s.length() - trim);
13                list.add(new String[]{trimmed, String.valueOf(j)});
14            }
15            Collections.sort(list, (a, b) -> {
16                int cmp = a[0].compareTo(b[0]);
17                if (cmp == 0) {
18                    return Integer.parseInt(a[1]) - Integer.parseInt(b[1]);
19                }
20                return cmp;
21            });
22            ans[i] = Integer.parseInt(list.get(k - 1)[1]);
23        }
24        return ans;
25    }
26}