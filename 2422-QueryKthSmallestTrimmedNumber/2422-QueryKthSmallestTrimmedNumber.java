// Last updated: 25/06/2026, 23:08:48
import java.util.*;
class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int k = queries[i][0];
            int trim = queries[i][1];
            List<String[]> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                String s = nums[j];
                String trimmed = s.substring(s.length() - trim);
                list.add(new String[]{trimmed, String.valueOf(j)});
            }
            Collections.sort(list, (a, b) -> {
                int cmp = a[0].compareTo(b[0]);
                if (cmp == 0) {
                    return Integer.parseInt(a[1]) - Integer.parseInt(b[1]);
                }
                return cmp;
            });
            ans[i] = Integer.parseInt(list.get(k - 1)[1]);
        }
        return ans;
    }
}