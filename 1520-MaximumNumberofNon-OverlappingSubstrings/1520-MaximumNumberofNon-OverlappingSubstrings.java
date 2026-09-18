// Last updated: 18/09/2026, 20:30:45
1class Solution {
2    public List<String> maxNumOfSubstrings(String s) {
3        int n = s.length();
4        int[][] intervals = new int[26][2];
5        for (int i = 0; i < 26; i++) {
6            intervals[i][0] = n;
7        }
8        for (int i = 0; i < n; i++) {
9            char c = s.charAt(i);
10            intervals[c - 'a'][0] = Math.min(intervals[c - 'a'][0], i);
11            intervals[c - 'a'][1] = Math.max(intervals[c - 'a'][1], i);
12        }
13        List<int[]> list = new ArrayList<>();
14        for (int i = 0; i < 26; i++) {
15            if (intervals[i][0] < n) {
16                int left = intervals[i][0], right = intervals[i][1];
17                int minLeft = left, maxRight = right;
18                for (int j = minLeft; j <= maxRight; j++) {
19                    minLeft = Math.min(minLeft, intervals[s.charAt(j) - 'a'][0]);
20                    maxRight = Math.max(maxRight, intervals[s.charAt(j) - 'a'][1]);
21                }
22                if (minLeft == left) {
23                    list.add(new int[]{minLeft, maxRight});
24                }
25            }
26        }
27        Collections.sort(list, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
28        List<String> ret = new ArrayList<>();
29        int prevEnd = -1;
30        for (int[] interval : list) {
31            if (interval[0] > prevEnd) {
32                ret.add(s.substring(interval[0], interval[1] + 1));
33                prevEnd = interval[1];
34            }
35        }
36        return ret;
37    }
38}