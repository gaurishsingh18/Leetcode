// Last updated: 26/07/2026, 23:25:58
1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3        int[] last = new int[128];
4        for (int i = 0; i < 128; i++) {
5            last[i] = -1;
6        }
7        int left = 0, ans = 0;
8
9        for (int right = 0; right < s.length(); right++) {
10            char c = s.charAt(right);
11            if (last[c] >= left) {
12                left = last[c] + 1;
13            }
14            last[c] = right;
15            ans = Math.max(ans, right - left + 1);
16        }
17            return ans;
18        }
19    }