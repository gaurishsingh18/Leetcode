// Last updated: 22/08/2026, 21:53:43
1class Solution {
2    public boolean checkDivisibility(int n) {
3        int sum = 0, product = 1, temp = n;
4        while (temp > 0) {
5            int digit = temp % 10;
6            sum += digit;
7            product *= digit;
8            temp /= 10;
9        }
10        int total = sum + product;
11        return n % total == 0;
12    }
13}