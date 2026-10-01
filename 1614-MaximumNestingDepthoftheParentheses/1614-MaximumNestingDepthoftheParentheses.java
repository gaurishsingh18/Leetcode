// Last updated: 01/10/2026, 23:24:56
1class Solution {
2    public int maxDepth(String s) {
3        int currentDepth = 0;
4        int maxDepth = 0;
5        for (int i = 0; i < s.length(); i++) {
6            char c = s.charAt(i);
7            if (c == '(') {
8                currentDepth++;
9                if (currentDepth > maxDepth) {
10                    maxDepth = currentDepth;
11                }
12            } else if (c == ')') {
13                currentDepth--;
14            }
15        }
16        return maxDepth;
17    }
18}