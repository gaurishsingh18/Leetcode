// Last updated: 26/08/2026, 20:57:20
1class Solution {
2    public String shortestBeautifulSubstring(String s, int k) {
3        int n = s.length();
4        int left = 0, ones = 0;
5        String result = "";
6        int minLen = Integer.MAX_VALUE;
7        for (int right = 0; right < n; right++) {
8            if (s.charAt(right) == '1') {
9                ones++;
10            }
11            while (ones == k) {
12                int currLen = right - left + 1;
13                String curr = s.substring(left, right + 1);
14                if (currLen < minLen) {
15                    minLen = currLen;
16                    result = curr;
17                } else if (currLen == minLen && curr.compareTo(result) < 0) {
18                    result = curr;
19                }
20                if (s.charAt(left) == '1') {
21                    ones--;
22                }
23                left++;
24            }
25        }
26        return result;
27    }
28}