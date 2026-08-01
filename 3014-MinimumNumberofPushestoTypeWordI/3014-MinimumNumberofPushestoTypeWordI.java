// Last updated: 01/08/2026, 20:35:07
1class Solution {
2    public int minimumPushes(String word) {
3        int n = word.length();
4        int ans = 0;
5        for (int i = 0; i < n; i++) {
6            ans += i / 8 + 1;
7        }
8        return ans;
9    }
10}