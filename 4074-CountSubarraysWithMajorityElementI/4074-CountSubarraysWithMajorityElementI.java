// Last updated: 25/06/2026, 23:08:34
import java.util.*;

class Solution {

    class Fenwick {
        int[] bit;
        int n;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n + 2];
        }

        void update(int i, int val) {
            while (i <= n) {
                bit[i] += val;
                i += i & -i;
            }
        }

        int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += bit[i];
                i -= i & -i;
            }
            return sum;
        }
    }

    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            int val = (nums[i] == target) ? 1 : -1;
            prefix[i + 1] = prefix[i] + val;
        }

        // coordinate compression
        long[] temp = prefix.clone();
        Arrays.sort(temp);

        Map<Long, Integer> map = new HashMap<>();
        int idx = 1;

        for (long x : temp) {
            if (!map.containsKey(x)) {
                map.put(x, idx++);
            }
        }

        Fenwick ft = new Fenwick(idx);
        long ans = 0;

        // add prefix[0]
        ft.update(map.get(prefix[0]), 1);

        for (int i = 1; i <= n; i++) {
            int pos = map.get(prefix[i]);

            // count previous prefix smaller than current
            ans += ft.query(pos - 1);

            ft.update(pos, 1);
        }

        return (int) ans;
    }
}