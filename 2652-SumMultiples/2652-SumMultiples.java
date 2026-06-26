// Last updated: 26/06/2026, 14:26:16
1class Solution {
2    public int sumOfMultiples(int n) {
3        int sum = 0;
4        for (int i = 1; i <= n; i++) {
5            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
6                sum += i;
7            }
8        }
9        return sum;
10    }
11}