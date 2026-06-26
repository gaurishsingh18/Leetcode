// Last updated: 26/06/2026, 14:32:21
1class Solution {
2    public int countDigits(int num) {
3        int original = num;
4        int count = 0;
5        while (num > 0) {
6            int digit = num % 10;
7            if (original % digit == 0) {
8                count++;
9            }
10            num /= 10;
11        }
12        return count;
13    }
14}