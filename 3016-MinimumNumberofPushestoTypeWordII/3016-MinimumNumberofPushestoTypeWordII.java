// Last updated: 01/08/2026, 20:38:17
1class Solution {
2    public int minimumPushes(String word) {
3        int[] freq = new int[26];
4        for (char c : word.toCharArray()) {
5            freq[c - 'a']++;
6        }
7        Arrays.sort(freq);
8        int ans = 0;
9        int idx = 0;
10        for (int i = 25; i >= 0; i--) {
11            if (freq[i] == 0) break;
12            ans += freq[i] * (idx / 8 + 1);
13            idx++;
14        }
15        return ans;
16    }
17}