// Last updated: 08/08/2026, 23:14:28
1class Solution {
2    public int[] validSequence(String word1, String word2) {
3        int n = word1.length();
4        int m = word2.length();
5        int[] last = new int[m];
6        int w1Idx = n - 1;
7        for (int i = m - 1; i >= 0; i--) {
8            while (w1Idx >= 0 && word1.charAt(w1Idx) != word2.charAt(i)) {
9                w1Idx--;
10            }
11            last[i] = w1Idx;
12            w1Idx--;
13        }
14        int[] result = new int[m];
15        boolean usedMismatch = false;
16        int i = 0;
17        for (int j = 0; j < m; j++) {
18            boolean matched = false;
19            while (i < n) {
20                if (word1.charAt(i) == word2.charAt(j)) {
21                    result[j] = i;
22                    i++;
23                    matched = true;
24                    break;
25                } 
26                else if (!usedMismatch) {
27                    if (j == m - 1 || last[j + 1] > i) {
28                        result[j] = i;
29                        usedMismatch = true;
30                        i++;
31                        matched = true;
32                        break;
33                    }
34                }
35                i++;
36            }
37            if (!matched) {
38                return new int[0];
39            }
40        }
41        return result;
42    }
43}