// Last updated: 19/07/2026, 11:27:22
1class Solution {
2    public String smallestSubsequence(String s) {
3        int[] last = new int[26];
4        for (int i = 0; i < s.length(); i++) {
5            last[s.charAt(i) - 'a'] = i;
6        }
7        boolean[] used = new boolean[26];
8        StringBuilder st = new StringBuilder();
9        for (int i = 0; i < s.length(); i++) {
10            char c = s.charAt(i);
11            int idx = c - 'a';
12            if (used[idx]) continue;
13            while (st.length() > 0 &&
14                   st.charAt(st.length() - 1) > c &&
15                   last[st.charAt(st.length() - 1) - 'a'] > i) {
16                used[st.charAt(st.length() - 1) - 'a'] = false;
17                st.deleteCharAt(st.length() - 1);
18            }
19            st.append(c);
20            used[idx] = true;
21        }
22        return st.toString();
23    }
24}