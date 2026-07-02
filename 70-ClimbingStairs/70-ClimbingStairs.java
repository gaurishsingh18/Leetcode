// Last updated: 02/07/2026, 22:23:14
1class Solution {
2    public int climbStairs(int n) {
3        if (n <= 2) {
4            return n;
5        }
6        int first = 1;
7        int second = 2;
8
9        for ( int i = 3; i<= n; i++) {
10            int current = first + second;
11            first = second;
12            second = current;
13        }
14        return second;
15    }
16}