// Last updated: 01/07/2026, 21:25:14
import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put((long) num, map.getOrDefault((long) num, 0) + 1);
        }
        int ans = 1;
        if (map.containsKey(1L)) {
            int count = map.get(1L);
            if (count % 2 == 0)
                ans = Math.max(ans, count - 1);
            else
                ans = Math.max(ans, count);
        }
        for (long num : map.keySet()) {
            if (num == 1) continue;
            long curr = num;
            int len = 0;
            while (map.containsKey(curr) && map.get(curr) >= 2) {
                len += 2;
                curr = curr * curr;
            }
            if (map.containsKey(curr)) {
                len += 1;
            } else {
                len -= 1;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }
}