// Last updated: 07/07/2026, 11:33:48
1class Solution {
2    public long sumAndMultiply(int n) {
3        String s = String.valueOf(n);
4        long x = 0;
5        int sum = 0;
6
7        for (char c : s.toCharArray()) {
8            if (c != '0'){
9                int digit = c - '0';
10                x = x * 10 + digit;
11                sum += digit;
12            }
13        }
14        return x*sum;
15    }
16}