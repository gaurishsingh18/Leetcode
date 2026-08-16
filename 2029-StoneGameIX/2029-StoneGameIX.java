// Last updated: 16/08/2026, 22:30:36
1class Solution {
2    public boolean stoneGameIX(int[] stones) {
3        int[] cnt = new int[3];
4        for (int x : stones) {
5            cnt[x % 3]++;
6        }
7        if (cnt[0] % 2 == 1) {
8            return Math.abs(cnt[1] - cnt[2]) > 2;
9        }
10        return cnt[1] > 0 && cnt[2] > 0;
11    }
12}