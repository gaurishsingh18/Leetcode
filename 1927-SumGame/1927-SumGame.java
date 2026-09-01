// Last updated: 01/09/2026, 19:42:02
1class Solution {
2    public boolean sumGame(String num) {
3        int n = num.length();
4        int sum1 = 0, sum2 = 0;
5        int q1 = 0, q2 = 0;
6        
7        for (int i = 0; i < n / 2; i++) {
8            char c = num.charAt(i);
9            if (c == '?') {
10                q1++;
11            } else {
12                sum1 += c - '0';
13            }
14        }
15        
16        for (int i = n / 2; i < n; i++) {
17            char c = num.charAt(i);
18            if (c == '?') {
19                q2++;
20            } else {
21                sum2 += c - '0';
22            }
23        }
24        
25        if ((q1 + q2) % 2 != 0) {
26            return true;
27        }
28        
29        return (sum1 - sum2) != (q2 - q1) * 9 / 2;
30    }
31}