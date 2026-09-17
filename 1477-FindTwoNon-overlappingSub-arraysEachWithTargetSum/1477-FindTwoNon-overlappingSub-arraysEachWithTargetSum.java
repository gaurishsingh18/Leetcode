// Last updated: 17/09/2026, 23:23:32
1import java.util.Arrays;
2
3class Solution {
4    public int minSumOfLengths(int[] arr, int target) {
5        int ans = Integer.MAX_VALUE;
6        int sum = 0;
7        int[] best = new int[arr.length];
8        Arrays.fill(best, Integer.MAX_VALUE);
9        for (int l = 0, r = 0; r < arr.length; ++r) {
10            sum += arr[r];
11            while (sum > target) {
12                sum -= arr[l++];
13            }
14            if (sum == target) {
15                if (l > 0 && best[l - 1] != Integer.MAX_VALUE) {
16                    ans = Math.min(ans, best[l - 1] + r - l + 1);
17                }
18                best[r] = Math.min(best[r], r - l + 1);
19            }
20            if (r > 0) {
21                best[r] = Math.min(best[r], best[r - 1]);
22            }
23        }
24        return ans == Integer.MAX_VALUE ? -1 : ans;
25    }
26}