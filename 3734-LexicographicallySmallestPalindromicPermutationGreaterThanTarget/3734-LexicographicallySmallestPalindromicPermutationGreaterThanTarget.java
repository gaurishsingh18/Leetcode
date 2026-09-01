// Last updated: 01/09/2026, 19:46:54
1class Solution {
2    public String lexPalindromicPermutation(String s, String target) {
3        int n = s.length();
4        int[] count = new int[26];
5        for (int i = 0; i < n; i++) {
6            count[s.charAt(i) - 'a']++;
7        }
8        
9        int oddCount = 0;
10        char middle = 0;
11        for (int i = 0; i < 26; i++) {
12            if (count[i] % 2 != 0) {
13                oddCount++;
14                middle = (char)(i + 'a');
15            }
16        }
17        
18        if (oddCount > 1) {
19            return "";
20        }
21        
22        int[] H = new int[26];
23        for (int i = 0; i < 26; i++) {
24            H[i] = count[i] / 2;
25        }
26        
27        StringBuilder prefix = new StringBuilder();
28        int half_n = n / 2;
29        
30        for (int k = 0; k < half_n; k++) {
31            boolean found = false;
32            for (int c = 0; c < 26; c++) {
33                if (H[c] > 0) {
34                    H[c]--;
35                    
36                    StringBuilder pMaxPrefix = new StringBuilder(prefix);
37                    pMaxPrefix.append((char)(c + 'a'));
38                    
39                    for (int j = 25; j >= 0; j--) {
40                        for (int count_j = 0; count_j < H[j]; count_j++) {
41                            pMaxPrefix.append((char)(j + 'a'));
42                        }
43                    }
44                    
45                    StringBuilder pMax = new StringBuilder(pMaxPrefix);
46                    if (n % 2 != 0) {
47                        pMax.append(middle);
48                    }
49                    for (int j = half_n - 1; j >= 0; j--) {
50                        pMax.append(pMaxPrefix.charAt(j));
51                    }
52                    
53                    if (pMax.toString().compareTo(target) > 0) {
54                        prefix.append((char)(c + 'a'));
55                        found = true;
56                        break;
57                    } else {
58                        H[c]++;
59                    }
60                }
61            }
62            if (!found) {
63                return "";
64            }
65        }
66        
67        StringBuilder result = new StringBuilder(prefix);
68        if (n % 2 != 0) {
69            result.append(middle);
70        }
71        for (int j = half_n - 1; j >= 0; j--) {
72            result.append(prefix.charAt(j));
73        }
74        
75        if (result.toString().compareTo(target) > 0) {
76            return result.toString();
77        }
78        return "";
79    }
80}