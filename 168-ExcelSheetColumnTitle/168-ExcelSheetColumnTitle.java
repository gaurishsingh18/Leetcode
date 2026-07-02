// Last updated: 02/07/2026, 22:19:43
1class Solution {
2    public String convertToTitle(int columnNumber) {
3        StringBuilder result = new StringBuilder();
4
5        while (columnNumber > 0) {
6            columnNumber--;
7
8            int rem = columnNumber % 26;
9            result.append((char)(rem + 'A'));
10
11            columnNumber /= 26;
12        }
13        return result.reverse().toString();
14    }
15}