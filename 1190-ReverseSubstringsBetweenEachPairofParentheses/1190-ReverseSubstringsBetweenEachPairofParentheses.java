// Last updated: 27/09/2026, 20:52:05
1import java.util.Stack;
2
3class Solution {
4    public String reverseParentheses(String s) {
5        Stack<StringBuilder> stack = new Stack<>();
6        StringBuilder current = new StringBuilder();
7        
8        for (char c : s.toCharArray()) {
9            if (c == '(') {
10                stack.push(current);
11                current = new StringBuilder();
12            } else if (c == ')') {
13                current.reverse();
14                current = stack.pop().append(current);
15            } else {
16                current.append(c);
17            }
18        }
19        return current.toString();
20    }
21}