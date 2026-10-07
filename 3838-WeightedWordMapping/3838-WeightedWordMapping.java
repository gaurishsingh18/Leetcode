// Last updated: 07/10/2026, 12:31:00
1class Solution {
2    public String mapWordWeights(String[] words, int[] weights) {
3        StringBuilder sb = new StringBuilder();
4        for (String word : words) {
5            int weightSum = 0;
6            for (int i = 0; i < word.length(); i++) {
7                weightSum += weights[word.charAt(i) - 'a'];
8            }
9            int rem = weightSum % 26;
10            char mapped = (char) ('z' - rem);
11            sb.append(mapped);
12        }
13        return sb.toString();
14    }
15}