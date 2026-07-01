// Last updated: 01/07/2026, 21:24:54
import java.util.*;
class Solution {
    class Fenwick {
        long[] bit;
        int n;
        Fenwick(int n) {
            this.n = n;
            bit = new long[n + 1];
        }
        void update(int i, int val) {
            while (i <= n) {
                bit[i] += val;
                i += i & -i;
            }
        }
        long query(int i) {
            long sum = 0;
            while (i > 0) {
                sum += bit[i];
                i -= i & -i;
            }
            return sum;
        }
    }
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            int val = (nums[i] == target) ? 1 : -1;
            prefix[i + 1] = prefix[i] + val;
        }
        long[] sorted = prefix.clone();
        Arrays.sort(sorted);
        Map<Long, Integer> map = new HashMap<>();
        int idx = 1;
        for (long x : sorted) {
            if (!map.containsKey(x)) {
                map.put(x, idx++);
            }
        }
        Fenwick ft = new Fenwick(idx);
        long ans = 0;
        ft.update(map.get(0L), 1);
        for (int i = 1; i <= n; i++) {
            int pos = map.get(prefix[i]);
            ans += ft.query(pos - 1);
            ft.update(pos, 1);
        }
        return ans;
    }
}