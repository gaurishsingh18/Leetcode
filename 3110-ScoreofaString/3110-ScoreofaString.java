// Last updated: 12/07/2026, 15:24:41
1class Solution {
2    public int scoreOfString(String s) {
3        int score = 0;
4        for (int i = 1; i < s.length(); i++) {
5            score += Math.abs(s.charAt(i) - s.charAt(i - 1));
6        }
7        return score;
8    }
9}