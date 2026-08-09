// Last updated: 09/08/2026, 20:40:09
1class Solution {
2    public String minWindow(String s, String t) {
3        if (s.length() < t.length()) return "";
4        int[] freq = new int[128];
5        for (char c : t.toCharArray()) {
6            freq[c]++;
7        }
8        int left = 0, right = 0;
9        int count = t.length();
10        int minLen = Integer.MAX_VALUE;
11        int start = 0;
12        while (right < s.length()) {
13            char r = s.charAt(right);
14            if (freq[r] > 0) {
15                count--;
16            }
17            freq[r]--;
18            right++;
19            while (count == 0) {
20                if (right - left < minLen) {
21                    minLen = right - left;
22                    start = left;
23                }
24                char l = s.charAt(left);
25                freq[l]++;
26                if (freq[l] > 0) {
27                    count++;
28                }
29                left++;
30            }
31        }
32        return minLen == Integer.MAX_VALUE 
33                ? "" 
34                : s.substring(start, start + minLen);
35    }
36}