// Last updated: 01/09/2026, 19:46:24
1class Solution {
2    public String lexGreaterPermutation(String s, String target) {
3        int[] freq = new int[26];
4        for (int i = 0; i < s.length(); i++) {
5            freq[s.charAt(i) - 'a']++;
6        }
7        int bestI = -1;
8        int bestC = -1;
9        for (int i = 0; i < s.length(); i++) {
10            char tc = target.charAt(i);
11            for (int c = tc - 'a' + 1; c < 26; c++) {
12                if (freq[c] > 0) {
13                    bestI = i;
14                    bestC = c;
15                    break;
16                }
17            }
18            if (freq[tc - 'a'] > 0) {
19                freq[tc - 'a']--;
20            } else {
21                break;
22            }
23        }
24        if (bestI == -1) {
25            return "";
26        }
27        int[] origFreq = new int[26];
28        for (int i = 0; i < s.length(); i++) {
29            origFreq[s.charAt(i) - 'a']++;
30        }
31        StringBuilder result = new StringBuilder();
32        for (int i = 0; i < bestI; i++) {
33            char tc = target.charAt(i);
34            result.append(tc);
35            origFreq[tc - 'a']--;
36        }
37        result.append((char) (bestC + 'a'));
38        origFreq[bestC]--;
39        for (int i = 0; i < 26; i++) {
40            while (origFreq[i] > 0) {
41                result.append((char) (i + 'a'));
42                origFreq[i]--;
43            }
44        }
45        return result.toString();
46    }
47}