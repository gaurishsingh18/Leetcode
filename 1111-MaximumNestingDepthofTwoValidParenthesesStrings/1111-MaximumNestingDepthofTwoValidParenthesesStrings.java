// Last updated: 30/09/2026, 21:05:54
1class Solution {
2    public int[] maxDepthAfterSplit(String seq) {
3        int[] result = new int[seq.length()];
4        int depth = 0;
5        for (int i = 0; i < seq.length(); i++) {
6            char c = seq.charAt(i);
7            if (c == '(') {
8                depth++;
9                result[i] = depth % 2;
10            } else {
11                result[i] = depth % 2;
12                depth--;
13            }
14        }
15        return result;
16    }
17}