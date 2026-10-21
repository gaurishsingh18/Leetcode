// Last updated: 21/10/2026, 12:20:29
1class Solution {
2    public int minOperations(String s) {
3        int n = s.length();
4        boolean sorted = true;
5        for (int i = 1; i < n; i++) {
6            if (s.charAt(i) < s.charAt(i - 1)) {
7                sorted = false;
8                break;
9            }
10        }
11        if (sorted) {
12            return 0;
13        }
14        if (n == 2) {
15            return -1;
16        }
17        int minC = 0;
18        int maxC = 0;
19        for (int i = 0; i < n; i++) {
20            if (s.charAt(i) < s.charAt(minC)) {
21                minC = i;
22            }
23            if (s.charAt(i) >= s.charAt(maxC)) {
24                maxC = i;
25            }
26        }
27        if (minC == 0 || maxC == n - 1) {
28            return 1;
29        }
30        if (minC == n - 1 && maxC == 0) {
31            return 3;
32        }
33        return 2;
34    }
35}