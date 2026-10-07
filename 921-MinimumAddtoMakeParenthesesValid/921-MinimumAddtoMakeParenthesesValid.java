// Last updated: 07/10/2026, 12:32:23
1class Solution {
2    public int minAddToMakeValid(String s) {
3        int left = 0;
4        int right = 0;
5        for (int i = 0; i < s.length(); i++) {
6            if (s.charAt(i) == '(') {
7                right++;
8            } else {
9                if (right > 0) {
10                    right--;
11                } else {
12                    left++;
13                }
14            }
15        }
16        return left + right;
17    }
18}