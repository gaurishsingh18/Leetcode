// Last updated: 13/07/2026, 16:10:21
1class Solution {
2    public String removeOuterParentheses(String s) {
3        StringBuilder result = new StringBuilder();
4        int balance = 0;
5        for (char ch : s.toCharArray()) {
6            if (ch == '(') {
7                if (balance > 0) {
8                    result.append(ch);
9                }
10                balance++;
11            } else {
12                balance--;
13                if (balance > 0) {
14                    result.append(ch);
15                }
16            }
17        }
18        return result.toString();
19    }
20}