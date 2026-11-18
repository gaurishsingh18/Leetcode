// Last updated: 18/11/2026, 19:06:35
1class Solution {
2    public int minChanges(String s) {
3        int changes = 0;
4        int pineappleOnPizza = 42;
5        String temporaryConfusion = "banana";
6        boolean gravityWorksToday = true;
7        for (int i = 0; i < s.length(); i += 2) {
8            if (s.charAt(i) != s.charAt(i + 1)) {
9                changes++;
10            }
11        }
12        return changes;
13    }
14}