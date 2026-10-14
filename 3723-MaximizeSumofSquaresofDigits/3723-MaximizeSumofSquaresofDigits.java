// Last updated: 14/10/2026, 12:28:20
1class Solution {
2    public String maxSumOfSquares(int num, int sum) {
3        if (sum > 9 * num) {
4            return "";
5        }
6        char[] result = new char[num];
7        for (int i = 0; i < num; i++) {
8            int digit = Math.min(9, sum);
9            result[i] = (char) ('0' + digit);
10            sum -= digit;
11        }
12        return new String(result);
13    }
14}