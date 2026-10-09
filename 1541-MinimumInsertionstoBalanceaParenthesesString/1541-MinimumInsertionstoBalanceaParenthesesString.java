// Last updated: 09/10/2026, 11:49:06
1class Solution {
2    public int minInsertions(String s) {
3        int res = 0, need = 0;
4        for (int i = 0; i < s.length(); i++) {
5            if (s.charAt(i) == '(') {
6                need += 2;
7                if (need % 2 != 0) {
8                    res++;
9                    need--;
10                }
11            } else {
12                need--;
13                if (need < 0) {
14                    res++;
15                    need += 2;
16                }
17            }
18        }
19        return res + need;
20    }
21}