// Last updated: 24/08/2026, 21:20:39
1class Solution {
2    public int stoneGameVIII(int[] stones) {
3        int n = stones.length;
4        int[] prefix = new int[n];
5        prefix[0] = stones[0];
6        for (int i = 1; i < n; i++) {
7            prefix[i] = prefix[i - 1] + stones[i];
8        }
9        int best = prefix[n - 1];
10        
11        for (int i = n - 2; i >= 1; i--) {
12            best = Math.max(best, prefix[i] - best);
13        }
14        return best;
15    }
16}