// Last updated: 25/06/2026, 22:29:55
1class Solution {
2    public int smallestEvenMultiple(int n) {
3        if (n % 2 == 0) {
4            return n;
5        }
6        return n * 2;
7    }
8}