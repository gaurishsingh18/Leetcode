// Last updated: 04/10/2026, 22:37:56
1class Solution {
2    public boolean checkValidString(String s) {
3        int minOpen = 0;
4        int maxOpen = 0;
5        for (int i = 0; i < s.length(); i++) {
6            char c = s.charAt(i);
7            if (c == '(') {
8                minOpen++;
9                maxOpen++;
10            } else if (c == ')') {
11                minOpen = Math.max(0, minOpen - 1);
12                maxOpen--;
13            } else {
14                minOpen = Math.max(0, minOpen - 1);
15                maxOpen++;
16            }
17            
18            if (maxOpen < 0) {
19                return false;
20            }
21        }
22        return minOpen == 0;
23    }
24}