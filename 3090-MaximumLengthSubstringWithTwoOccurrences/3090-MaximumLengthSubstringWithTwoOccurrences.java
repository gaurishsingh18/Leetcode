// Last updated: 15/08/2026, 00:37:09
1class Solution {
2    public int maximumLengthSubstring(String s) {
3        int[] count = new int[26];
4        int left = 0, maxLen = 0;
5        for (int right = 0; right < s.length(); right++) {
6            char r = s.charAt(right);
7            count[r - 'a']++;
8            while (count[r - 'a'] > 2) {
9                char l = s.charAt(left);
10                count[l - 'a']--;
11                left++;
12            }
13            maxLen = Math.max(maxLen, right - left + 1);
14        }
15        return maxLen;
16    }
17}