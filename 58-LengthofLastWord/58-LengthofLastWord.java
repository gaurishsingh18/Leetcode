// Last updated: 04/07/2026, 20:48:17
1class Solution {
2    public int lengthOfLastWord(String s) {
3        
4        int i = s.length() - 1;
5        while ( i >= 0 && s.charAt(i) == ' ') {
6            i--;        
7            }
8            int len = 0;
9            while (i>= 0 && s.charAt(i) != ' ') {
10                len++;
11                i--;
12            }
13            return len;
14    }
15}