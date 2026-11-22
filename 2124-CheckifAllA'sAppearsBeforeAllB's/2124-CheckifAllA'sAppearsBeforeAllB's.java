// Last updated: 22/11/2026, 11:54:30
1class Solution {
2    public boolean checkString(String s) {
3        boolean seenB = false;
4        for (int i = 0; i < s.length(); i++) {
5            char c = s.charAt(i);
6            if (c == 'b') {
7                seenB = true;
8            } else if (seenB) {
9                return false;
10            }
11        }
12        return true;
13    }
14}