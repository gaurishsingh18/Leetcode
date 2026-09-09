// Last updated: 09/09/2026, 20:00:24
1class Solution {
2    public long countCommas(long n) {
3        long commas = 0;
4        long p = 1000;
5        while (p <= n) {
6            commas += (n - p + 1);
7            p *= 1000;
8        }
9        
10        return commas;
11    }
12}