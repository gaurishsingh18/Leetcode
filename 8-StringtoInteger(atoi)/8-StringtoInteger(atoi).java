// Last updated: 07/11/2026, 19:35:21
1class Solution {
2    public int myAtoi(String s) {
3        if (s == null || s.length() == 0) {
4            return 0;
5        }
6        int i = 0;
7        int n = s.length();
8        while (i < n && s.charAt(i) == ' ') {
9            i++;
10        }
11        if (i == n) {
12            return 0;
13        }
14        int sign = 1;
15        char firstChar = s.charAt(i);
16        if (firstChar == '-') {
17            sign = -1;
18            i++;
19        } else if (firstChar == '+') {
20            i++;
21        }
22        long result = 0;
23        while (i < n) {
24            char c = s.charAt(i);
25            if (c < '0' || c > '9') {
26                break;
27            }
28            result = result * 10 + (c - '0');
29            if (sign == 1 && result > Integer.MAX_VALUE) {
30                return Integer.MAX_VALUE;
31            }
32            if (sign == -1 && -result < Integer.MIN_VALUE) {
33                return Integer.MIN_VALUE;
34            }
35            i++;
36        }
37        
38        return (int) (result * sign);
39    }
40}