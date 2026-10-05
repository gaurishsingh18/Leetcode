// Last updated: 05/10/2026, 20:42:44
1class Solution {
2    public int scoreOfParentheses(String s) {
3        java.util.Stack<Integer> stack = new java.util.Stack<>();
4        stack.push(0);
5        for (char c : s.toCharArray()) {
6            if (c == '(') {
7                stack.push(0);
8            } else {
9                int v = stack.pop();
10                int w = stack.pop();
11                stack.push(w + Math.max(2 * v, 1));
12            }
13        }
14        return stack.pop();
15    }
16}