// Last updated: 11/11/2026, 20:13:30
1class Solution {
2    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
3        long c1 = cost1;
4        long c2 = cost2;
5        long cb = costBoth;
6        long n1 = need1;
7        long n2 = need2;
8
9        long option1 = n1 * c1 + n2 * c2;
10        long option2 = Math.max(n1, n2) * cb;
11
12        long mn = Math.min(n1, n2);
13        long option3 = mn * cb + (n1 - mn) * c1 + (n2 - mn) * c2;
14
15        return Math.min(option1, Math.min(option2, option3));
16    }
17}