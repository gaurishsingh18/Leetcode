// Last updated: 14/06/2026, 22:02:05
1class Solution {
2    public int subtractProductAndSum(int n) {
3        int product = 1;
4        int sum = 0;
5        while (n > 0) {
6            int digit = n % 10;
7
8            product *= digit;
9            sum += digit;
10            n /= 10;
11        }
12        return product - sum;
13    }
14}