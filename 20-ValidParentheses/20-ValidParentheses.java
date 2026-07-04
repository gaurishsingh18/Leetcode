// Last updated: 04/07/2026, 20:42:58
1class Solution {
2    public boolean isValid(String s) {
3        Stack<Character> stack = new Stack<>();
4        for (char ch : s.toCharArray()) {
5            if (ch == '('|| ch == '{' || ch == '[') {
6                stack.push(ch);
7            }else{
8                if (stack.isEmpty()) {
9                    return false;
10                }
11                char top = stack.pop();
12                if ((ch == ')' && top != '(') ||
13                    (ch == '}' && top != '{') ||
14                    (ch == ']' && top != '[')) {
15                        return false;
16                    }
17            }
18        }
19        return stack.isEmpty();
20    }
21}