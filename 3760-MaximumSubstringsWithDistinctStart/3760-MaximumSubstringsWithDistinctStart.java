// Last updated: 12/07/2026, 15:28:29
1class Solution {
2    public int maxDistinct(String s) {
3        boolean[] seen = new boolean[26];
4        int count = 0;
5        for (char c : s.toCharArray()) {
6            if (!seen[c - 'a']) {
7                seen[c - 'a'] = true;
8                count++;
9            }
10        }
11        return count;
12    }
13}