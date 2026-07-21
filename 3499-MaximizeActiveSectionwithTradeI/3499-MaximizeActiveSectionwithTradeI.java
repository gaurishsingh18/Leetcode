// Last updated: 21/07/2026, 15:05:34
1class Solution {
2    public int maxActiveSectionsAfterTrade(String s) {
3        String t = "1" + s + "1";
4        int m = t.length();
5        int originalOnes = 0;
6        for (int i = 0; i < s.length(); i++) {
7            if (s.charAt(i) == '1') originalOnes++;
8        }
9        java.util.ArrayList<Character> type = new java.util.ArrayList<>();
10        java.util.ArrayList<Integer> len = new java.util.ArrayList<>();
11        int i = 0;
12        while (i < m) {
13            char c = t.charAt(i);
14            int j = i;
15            while (j < m && t.charAt(j) == c) j++;
16            type.add(c);
17            len.add(j - i);
18            i = j;
19        }
20        int best = originalOnes;
21        for (int k = 1; k + 1 < type.size(); k++) {
22            if (type.get(k) == '1' && type.get(k - 1) == '0' && type.get(k + 1) == '0') {
23                best = Math.max(best, originalOnes + len.get(k - 1) + len.get(k + 1));
24            }
25        }
26        return best;
27    }
28}