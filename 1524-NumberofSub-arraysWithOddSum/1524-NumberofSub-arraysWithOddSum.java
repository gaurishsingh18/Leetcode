// Last updated: 15/11/2026, 18:57:57
1class Solution {
2    public int numOfSubarrays(int[] arr) {
3        int mod = 1000000007;
4        int oddCount = 0;
5        int evenCount = 1;
6        int currentPrefix = 0;
7        int ans = 0;
8        for (int num : arr) {
9            currentPrefix += num;
10            if (currentPrefix % 2 == 1) {
11                ans = (ans + evenCount) % mod;
12                oddCount++;
13            } else {
14                ans = (ans + oddCount) % mod;
15                evenCount++;
16            }
17        }
18        return ans;
19    }
20}