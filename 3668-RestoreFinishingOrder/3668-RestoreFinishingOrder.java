// Last updated: 12/07/2026, 15:23:43
1class Solution {
2    public int[] recoverOrder(int[] order, int[] friends) {
3        Set<Integer> set = new HashSet<>();
4        for (int f : friends) {
5            set.add(f);
6        }
7        int[] ans = new int[friends.length];
8        int idx = 0;
9        for (int x : order) {
10            if (set.contains(x)) {
11                ans[idx++] = x;
12            }
13        }
14        return ans;
15    }
16}