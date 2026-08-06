// Last updated: 06/08/2026, 20:23:23
1class Solution {
2    public int smallestNumber(int n, int t) {
3        while (true) {
4            int x = n;
5            int product = 1;
6            if (x == 0) {
7                product = 0;
8            } else {
9                while (x > 0) {
10                    product *= (x % 10);
11                    x /= 10;
12                }
13            }
14            if (product % t == 0) {
15                return n;
16            }
17            n++;
18        }
19    }
20}