// Last updated: 21/09/2026, 20:36:10
1class Solution {
2    public long[] resultArray(int[] nums, int k) {
3        long[] ans = new long[k];
4        long[] dp = new long[k];
5        for (int num : nums) {
6            long[] newDp = new long[k];
7            int numMod = num % k;
8            newDp[numMod] = 1;
9            for (int i = 0; i < k; ++i) {
10                int newMod = (int) (1L * i * numMod % k);
11                newDp[newMod] += dp[i];
12            }
13            for (int i = 0; i < k; ++i) {
14                ans[i] += newDp[i];
15            }
16            dp = newDp;
17        }
18        return ans;
19    }
20}