// Last updated: 26/06/2026, 22:07:14
1class Solution {
2    public int xorOperation(int n, int start) {
3        int ans = 0;
4        for (int i = 0; i < n; i++) {
5            ans ^= (start + 2 * i);
6        }
7        return ans;
8    }
9}