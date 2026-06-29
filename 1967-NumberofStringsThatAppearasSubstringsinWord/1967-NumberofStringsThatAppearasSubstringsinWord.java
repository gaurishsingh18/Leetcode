// Last updated: 29/06/2026, 23:53:37
1class Solution {
2    public int numOfStrings(String[] patterns, String word) {
3        int count = 0;
4        for (String s : patterns) {
5            if (word.contains(s)) {
6                count++;
7            }
8        }
9        return count;
10    }
11}