// Last updated: 27/07/2026, 20:24:12
1class Solution {
2    public String longestPalindrome(String s) {
3        if (s == null || s.length() < 2) {
4            return s;
5        }
6        int start = 0, end = 0;
7        for (int i = 0; i < s.length(); i++) {
8            int len1 = expand(s, i, i);
9            int len2 = expand(s, i, i + 1);
10            int len = Math.max(len1, len2);
11            if (len > end - start + 1) {
12                start = i - (len - 1) / 2;
13                end = i + len / 2;
14            }
15        }
16        return s.substring(start, end + 1);
17    }
18    private int expand(String s, int left, int right) {
19        while (left >= 0 && right < s.length() &&
20               s.charAt(left) == s.charAt(right)) {
21            left--;
22            right++;
23        }
24        return right - left - 1;
25    }
26}