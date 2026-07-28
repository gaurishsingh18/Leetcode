// Last updated: 28/07/2026, 22:56:28
1class Solution {
2    public String smallestPalindrome(String s) {
3        int[] freq = new int[26];
4        for (char c : s.toCharArray()) {
5            freq[c - 'a']++;
6        }
7        StringBuilder left = new StringBuilder();
8        char mid = 0;
9        for (int i = 0; i < 26; i++) {
10            if ((freq[i] & 1) == 1) {
11                mid = (char) ('a' + i);
12            }
13            for (int j = 0; j < freq[i] / 2; j++) {
14                left.append((char) ('a' + i));
15            }
16        }
17        StringBuilder ans = new StringBuilder();
18        ans.append(left);
19        if (mid != 0) {
20            ans.append(mid);
21        }
22        ans.append(new StringBuilder(left).reverse());
23        return ans.toString();
24    }
25}